<template>
<div class="errorInfo-container">
<el-form :inline="true" :model="formInline" class="demo-form-inline">
  <el-form-item label="标签名称">
    <el-input v-model="formInline.user" placeholder="请输入标签名称"></el-input>
  </el-form-item>
  <el-form-item label="状态">
    <el-select v-model="formInline.region" placeholder="活动区域">
      <el-option label="区域一" value="shanghai"></el-option>
      <el-option label="区域二" value="beijing"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </el-form-item>
</el-form>
 <el-table
    ref="filterTable"
    :data="tableData"
    style="width: 100%"
    align="center"
    >
    </el-table-column>
     <el-table-column
      type="index"
      label="编号"
      width="150">
    </el-table-column>

    <el-table-column
      prop="code"
      label="错误码"
      width="150">
    </el-table-column>
    <el-table-column
      prop="error_info"
      label="描述"
      width="150"
      :formatter="formatter">
    </el-table-column>
    <el-table-column
      prop="error_tag"
      label="标签"
      width="180"
      :filters="[{ text: '公共错误码', value: '公共错误码' }, { text: '个人错误码', value: '个人错误码' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.error_tag === '公共错误码' ? 'primary' : 'success'"
          disable-transitions>{{scope.row.error_tag}}</el-tag>
      </template>
    </el-table-column>
      <el-table-column
      prop="creator"
      label="创建人"
      width="150">
    </el-table-column>
    <el-table-column
      prop="date"
      label="创建日期"
      sortable
      width="180"
      column-key="date"
      :filters="[{text: '2020-03-15', value: '2020-03-15'}, 
      {text: '2020-03-16', value: '2020-03-16'}, 
      {text: '2020-03-17', value: '2020-03-17'}, 
      {text: '2020-03-18', value: '2020-03-18'}]"
      :filter-method="filterHandler"
    >
    </el-table-column>
     <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</div>
</template>
<script>
  export default {
    data() {
      return {
        formInline: {
          user: '',
          region: ''
        },
        tableData: [{
          code: '404',
          error_info: '错误码信息',
          error_tag: '公共错误码',
          date: '2020-03-15',
          creator:'王小虎'
        }, {
          code: '403',
          error_info: '错误码信息',
          error_tag: '公共错误码',
          date: '2020-03-16',
          creator:'王小虎'
        }, {
          code: '405',
          error_info: '错误码信息',
          error_tag: '个人错误码',
          date: '2020-03-17',
          creator:'王小虎'
        }, {
          code: '406',
          error_info: '错误码信息',
          error_tag: '个人错误码',
          date: '2020-03-18',
          creator:'王小虎'
        },{
          code: '407',
          error_info: '错误码信息',
          error_tag: '个人错误码',
          date: '2020-03-18',
          creator:'王小虎'
        }]
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
        resetDateFilter() {
        this.$refs.filterTable.clearFilter('date');
      },
      clearFilter() {
        this.$refs.filterTable.clearFilter();
      },
      formatter(row, column) {
        return row.error_info;
      },
      filterTag(value, row) {
        return row.error_tag === value;
      },
      filterHandler(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      },
    }
  }
</script>
<style lang="scss" scoped>
.errorInfo-container{
  width:98%;
  margin: 20px 15px;
}
</style>