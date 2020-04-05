<template>
  <oecp-page title="我的错误码" class="editCodePage">
    <el-button style="float:right;" type="primary" @click="createCode">新建错误码</el-button>
    <el-table :data="tableData" style="width: 100%" border fit highlight-current-row :loading="tableLoading">
      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-table :data="scope.row.caseInfos" style="width:100%" border fit highlight-current-row>
            <el-table-column type="index" label="案例编号" width="100"></el-table-column>
            <el-table-column prop="title" label="标题"></el-table-column>
            <el-table-column prop="content" label="案例详情" ></el-table-column>
            <el-table-column prop="errorTags" label="相关标签">
            <template slot-scope="scope">
              <el-tag
                v-for="(item,index) in scope.row.caseTags"
                :key="index"
                v-show="item.tag"
              >{{item.tag}}</el-tag>
            </template>
            </el-table-column>
         
          </el-table>
        </template>
      </el-table-column>
      <el-table-column type="index" label="ID" width="100"></el-table-column>
      <el-table-column prop="code" label="错误码" width="180"></el-table-column>
      <el-table-column prop="errorMsg" label="错误信息"></el-table-column>
      <el-table-column prop="errorInfo" label="错误描述"></el-table-column>
      <el-table-column prop="errorTags" label="相关标签">
        <template slot-scope="scope">
          <el-tag
            v-for="(item,index) in scope.row.errorTags"
            :key="index"
            v-show="item.tag"
          >{{item.tag}}</el-tag>
        </template>
      </el-table-column>
         <el-table-column prop="content" label="操作" width="150">
             <template slot-scope="scope">
               <el-button type="text">查看详情</el-button>
               <el-button type="text" @click="deleteCode(scope.row)">删除</el-button>
             </template>
             </el-table-column>
    </el-table>
  </oecp-page>
</template>

<script>
import { getErrorInfoAndCase,remove } from '@/api/errorInfo'
export default {
  data() {
    return {
      searchContent: '',
      tableData:[],
      tableLoading:false,
      pageIndex:1,
      pageSize:10
    }
  },
  methods: {
      deleteCode(row){
        console.log(row)
        remove(row.codeId).then(res => {
           if (res.result && !res.code) {
              this.search()
              this.$message.success('删除成功')
            } else {
              this.$message.error('删除失败')
            }
        })
      },
      search(){
        this.tableLoading = true;
        getErrorInfoAndCase({pageIndex:this.pageIndex,pageSize:this.pageSize}).then(res => {
            if (res.result && !res.code) {
              console.log(res.data)
              this.tableData = res.data.dataList
            } else {
              this.$message.error('保存失败')
            }
          })
          this.tableLoading = false;
      },
      createCode(){
        this.$router.push('/errorDealWith/add')
      }
  },
  mounted() {
    this.searchContent = this.$route.query.searchContent
    this.search();

  }
}
</script>

<style scoped>
</style>
<style>
</style>