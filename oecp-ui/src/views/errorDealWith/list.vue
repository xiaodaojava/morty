<template>
  <oecp-page title="我的错误码" class="editCodePage">
    <search-message :searchContent="searchContent" />
    <el-table :data="tableData" style="width: 100%" border fit highlight-current-row>
      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-table :data="scope.row.caseInfos" style="width:100%" border fit highlight-current-row>
            <el-table-column type="index" label="案例编号" width="80"></el-table-column>
            <el-table-column prop="title" label="标题" width="50"></el-table-column>
            <el-table-column prop="content" label="案例详情" width="50"></el-table-column>
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
               <el-input type="text">查看详情</el-input>
               <el-input type="text" @click="deleteCode(scope.row.id)">删除</el-input>
             </template>
             </el-table-column>
    </el-table>
  </oecp-page>
</template>

<script>
import { getErrorInfoAndCase } from '@/api/errorInfo'
export default {
  data() {
    return {
      searchContent: '',
      tableData:[]
    }
  },
  methods: {
      deleteCode(){
        console.log('2183798217398213')
      },
      search(){
    getErrorInfoAndCase().then(res => {
        if (res.result && !res.code) {
          console.log(res.data)
          this.tableData = res.data
        } else {
          this.$message.error('保存失败')
        }
      })
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