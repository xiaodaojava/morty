package com.platform.oecp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @version 1.0
 * @className: JsonUtils
 * @author: LILIANG
 * @date: Create In 2020/3/16 9:45
 * @description:
 */
public class JsonUtils {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * @author: LILIANG
     * @date: 2020/3/16 9:59
     * @Param : data
     * @return: java.lang.String
     * @description: 将对象转换成json字符串。
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            logger.info("对象转换成json字符串异常，一场内容为:{}",e.getMessage());
        }
        return null;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 9:59
     * @Param : jsonData
     * @Param : beanType
     * @return: T
     * @description: 将json结果集转化为对象
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            logger.info("json结果集转化为对象异常，异常内容为:{}",e.getMessage());
        }
        return null;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 10:00
     * @Param : jsonData
     * @Param : beanType
     * @return: java.util.List<T>
     * @description: 将json数据转换成pojo对象list
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            logger.info("json数据转换成pojo对象list异常，异常内容为:{}",e.getMessage());
        }
        return null;
    }
}
