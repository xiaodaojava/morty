<template>
  <div class="app-container">
    <!--
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <div class="searchInput">
        <el-input v-model="exampleSearchText" placeholder="请输入案例相关信息"></el-input>
      </div>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
      <el-form-item style="float:right">
        <el-button icon="el-icon-plus" @click="addExample" type="success">增加案例</el-button>
      </el-form-item>
    </el-form>
    -->
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column label="Title">
        <template slot-scope="scope">{{ scope.row.title }}</template>
      </el-table-column>
      <el-table-column label="Author" width="110" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Pageviews" width="110" align="center">
        <template slot-scope="scope">{{ scope.row.pageviews }}</template>
      </el-table-column>
      <el-table-column class-name="status-col" label="Status" width="110" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="Display_time" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.display_time }}</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getList } from "@/api/table";
export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: "success",
        draft: "gray",
        deleted: "danger"
      };
      return statusMap[status];
    }
  },
  data() {
    return {
      list: [
        {
          id: "1",
          title: "234123123123123",
          status: "publish",
          author: "name",
          display_time: "2020-03-16",
          pageviews: "123"
        }
      ],
      listLoading: true,
      exampleSearchText: "",
      formInline: {}
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.listLoading = true;
      this.listLoading = false;
      // getList().then(response => {
      //   this.list = response.data.items
      //   this.listLoading = false
      // })
    },
    onSubmit() {
      console.log("submit!");
    },
    addExample() {
      this.$router.push("/errorInfo/example-add");
    }
  }
};
</script>

<style lang="scss" scoped>
.searchInput {
  width: 30%;
  display: inline-block;
  margin-right: 1%;
}
</style>