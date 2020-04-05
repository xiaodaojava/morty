<template>
  <oecp-page title="错误码搜索结果">
    <el-form :inline="true">
      <el-form-item label="搜索内容">
        <el-input v-model="searchContent" placeholder="请输入搜索内容"></el-input>
      </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSearchSubmit">查询</el-button>
        </el-form-item>
    </el-form>
     <div v-if="searchContent" class="search-result-class">
    你要搜索的内容：“{{ searchContent }}”,结果如下
  </div>
    <el-table :data="tableData" style="width:100%" align="center" :loading="tableLoading"  border >
       <el-table-column type="expand">
       <template slot-scope="props">
         <el-table :data="props.row.errorCase" align="center">
            <el-table-column prop="title" label="案例"></el-table-column>
            <el-table-column label="案例标签">
              <template slot-scope="caseScope">
                <el-tag type="warning" v-for="(item,index) in caseScope.row.caseTag" :key="index">{{item.tag}}</el-tag>
              </template>
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="caseScope">
              <el-button type="text" @click="showErrorCaseDetail(caseScope.row.id)">查看详情</el-button>
              </template>
            </el-table-column>
         </el-table>
       </template>
       </el-table-column>
      <el-table-column type="index" label="编号" width="150"></el-table-column>
      <el-table-column prop="errorCode" label="错误码" width="150"></el-table-column>
      <el-table-column prop="errorMsg" label="错误码信息" width="150"></el-table-column>
      <el-table-column label="标签">
        <template slot-scope="scope">
          <el-tag v-for="(item,index) in scope.row.errorTag" :key="index">{{item.tag}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="errorDesc" label="备注" width="150"></el-table-column>
      <el-table-column label="相关案例数">
        <template slot-scope="scope" v-if="scope.row.errorCase">
          {{scope.row.errorCase.length}}
        </template>
      </el-table-column>
      
      <!-- <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="text" @click="showDetail(scope.$index, scope.row)">查看详情</el-button>
        </template>
      </el-table-column> -->
    </el-table>
  </oecp-page>
</template>
<script>
import { findByErrorCode } from '@/api/errorInfo'
export default {
  data(){
    return{
      tableData:[
        {
          errorCode:'768',
          errorMsg:'8979879',
          errorDesc:'87987987098',
          errorTag:[
            {
              id:'',
              tag:'768'
            },
            {
              id:'',
              tag:'78687'
            },
            {
              id:'',
              tag:'238334'
            }
          ],
          errorCase:[
            {
              id:'1112223333',
              title:'123',
              caseTag:[
                {
                  id:'1',
                  tag:'2'
                },
                {
                  id:'2',
                  tag:'11'
                }
              ]
            }
          ]
        }
      ], 
    searchContent:'',
    page:1,
    size:10,
    tableLoading:false
    }
  },
  methods:{
    onSearchSubmit(){
      this.search();
    },
    search(){
      findByErrorCode(this.searchContent).then(res =>{
        if(!res){
            this.tableData = []
        }else if(res.result){
          console.log(res)
          this.tableData = res;
        }
      })
    },
    showDetail(){
    },
    showErrorCaseDetail(id){
      //this.$router.push({path:'/searchboard/caseDetail'})
    }
  },
  mounted(){
    this.searchContent = this.$route.query.searchContent;
    this.search()
  }
  
}
</script>
<style lang="scss">
.search-result-class {
  color: #00c1de;
  margin-top: 5px;
  margin-bottom: 15px;
}
</style>