package com.platform.oecp.business.manager.impl;

import com.alipay.api.internal.util.file.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.oecp.business.manager.OecpErrorInfoEsManager;
import com.platform.oecp.models.document.OecpErrorDocument;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 和 ES 交互的接口实现类
 *
 * @author: dingaimin
 * @date: 2020/3/20 21:33
 */
@Component
public class OecpErrorInfoEsManagerImpl implements OecpErrorInfoEsManager {
    private static final String ERROR_CODE_INDEX = "error_codes";

    private RestHighLevelClient client;
    private ObjectMapper objectMapper;

    @Autowired
    public OecpErrorInfoEsManagerImpl(RestHighLevelClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    @Override
    public String createErrorCodeIndex() throws IOException {
        ClassPathResource resource = new ClassPathResource("mapping.json");
        String mappings = IOUtils.toString(resource.getInputStream(), "UTF-8");
        resource.getInputStream().close();
        CreateIndexRequest request = new CreateIndexRequest(ERROR_CODE_INDEX);
        request.mapping(mappings, XContentType.JSON);
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        System.out.println("创建索引的结果：" + acknowledged);
        if (acknowledged) {
            return "create success";
        } else {
            return "create fail";
        }
    }

    @Override
    public OecpErrorDocument findById(String id) throws IOException {
        GetRequest getRequest = new GetRequest(ERROR_CODE_INDEX, id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> resultMap = getResponse.getSource();
        return convertMapToProfileDocument(resultMap);
    }

    @Override
    public String editErrorCode(OecpErrorDocument document) throws IOException {
        IndexRequest indexRequest = new IndexRequest(ERROR_CODE_INDEX);
        indexRequest.id(document.getId());
        // 如果属性和 mapping 映射文件不一致，会覆盖
        indexRequest.source(convertProfileDocumentToMap(document));
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = indexResponse.getResult();
        System.out.println("更新索引的结果：" + result);
        return result.toString();
    }

    @Override
    public List<OecpErrorDocument> searchErrorCode(String info) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(ERROR_CODE_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("id", info))
                .should(QueryBuilders.matchQuery("errorCode", info))
                .should(QueryBuilders.matchQuery("errorMsg", info))
                .should(QueryBuilders.matchQuery("errorDesc", info))
                .should(QueryBuilders.matchQuery("errorTag", info));
        searchSourceBuilder.query(boolQuery);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse =
                client.search(searchRequest, RequestOptions.DEFAULT);
        return getSearchResult(searchResponse);
    }

    @Override
    public List<OecpErrorDocument> suggestErrorCode(String info) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(ERROR_CODE_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        CompletionSuggestionBuilder completionSuggestionBuilder = SuggestBuilders
                .completionSuggestion("errorMsg.msgSuggest")
                .prefix(info);
        suggestBuilder.addSuggestion("msgSuggest", completionSuggestionBuilder);
        searchSourceBuilder.suggest(suggestBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse =
                client.search(searchRequest, RequestOptions.DEFAULT);
        return getSuggestResult(searchResponse);
    }

    @Override
    public String deleteErrorCode(String id) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(ERROR_CODE_INDEX, id);
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println("删除结果：" + response.getResult());
        return response.getResult().name();
    }

    private List<OecpErrorDocument> getSearchResult(SearchResponse response) {
        SearchHit[] searchHit = response.getHits().getHits();
        List<OecpErrorDocument> errorCodeDocuments = new ArrayList<>();
        for (SearchHit hit : searchHit) {
            errorCodeDocuments
                    .add(objectMapper
                            .convertValue(hit
                                    .getSourceAsMap(), OecpErrorDocument.class));
        }
        return errorCodeDocuments;
    }

    private List<OecpErrorDocument> getSuggestResult(SearchResponse response) {
        Suggest suggest = response.getSuggest();
        CompletionSuggestion completionSuggestion = suggest.getSuggestion("msgSuggest");
        List<OecpErrorDocument> errorCodeDocuments = new ArrayList<>();
        for (CompletionSuggestion.Entry entry : completionSuggestion.getEntries()) {
            for (CompletionSuggestion.Entry.Option option : entry) {
                SearchHit hit = option.getHit();
                errorCodeDocuments
                        .add(objectMapper
                                .convertValue(hit.getSourceAsMap(), OecpErrorDocument.class));
            }
        }
        return errorCodeDocuments;
    }

    private OecpErrorDocument convertMapToProfileDocument(Map<String, Object> map) {
        return objectMapper.convertValue(map, OecpErrorDocument.class);
    }

    private Map<String, Object> convertProfileDocumentToMap(OecpErrorDocument oecpError) {
        return objectMapper.convertValue(oecpError, Map.class);
    }
}
