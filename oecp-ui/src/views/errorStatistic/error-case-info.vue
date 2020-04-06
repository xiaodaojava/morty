<template>
  <div class="content-container">
    <div class="search-area">
      <el-form :inline="true" :model="searchForm" class="demo-form-inline">
        <!-- <el-form-item label="案例标题">
          <el-input v-model="searchForm.title" placeholder="请输入案例标题"></el-input>
        </el-form-item>
        <el-form-item label="案例内容">
          <el-input v-model="searchForm.content" placeholder="请输入案例内容"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSearchSubmit">查询</el-button>
        </el-form-item>

        <el-button @click="clearFilter">清空</el-button> -->

        <div class="add-class">
          <el-button @click="addCaseInfo" type="warning">+ 增加案例</el-button>
        </div>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%" align="center" :loading="tableLoading">
      <el-table-column type="index" label="编号" width="150"></el-table-column>
      <el-table-column prop="title" label="案例标题" width="200"></el-table-column>
      <el-table-column prop="content" label="案例内容" width="400"></el-table-column>
      <el-table-column prop="createDate" label="创建日期" sortable width="200" :formatter="formatter"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="searchForm.pageIndex"
        :page-sizes="[5, 10, 20, 100]"
        :page-size="searchForm.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="searchForm.total"
        prev-text="上一页"
        next-text="下一页"
      ></el-pagination>
    </div>

    <el-dialog :title="formName" :visible.sync="dialogFormVisible">
      <el-form ref="addCaseInfoForm" :model="addCaseInfoForm" :rules="validRules">
        <el-form-item label="案例标题" :label-width="formLabelWidth">
          <div class="save-input-class">
            <el-input ref="title" v-model="addCaseInfoForm.title"></el-input>
          </div>
        </el-form-item>
        <el-form-item label="案例内容" :label-width="formLabelWidth">
          <div class="save-input-textarea-class">
            <el-input
              ref="content"
              type="textarea"
              :rows="5"
              v-model="addCaseInfoForm.content"
              placeholder="请输入内容"
            ></el-input>
          </div>
        </el-form-item>
        <el-form-item label="关联错误码" :label-width="formLabelWidth">
           <el-select
              filterable
              v-model="addCaseInfoForm.codeId"
              placeholder="请输入错误码">
              <el-option
                v-for="item in errorCodeList"
                :key="item.codeId"
                :label="item.code"
                :value="item.codeId">
              </el-option>
            </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="clearSaveCode()">取 消</el-button>
        <el-button type="primary" @click="saveCode()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { query, save, remove } from "@/api/errorCaseInfo";
import { getErrorInfoAndCase } from '@/api/errorInfo'
import { parseTime } from "@/utils/index";
export default {
  data() {
    const validateRule = (rule, value, callback) => {
      console.log(value);
      if (value.length < 1) {
        console.log(value);
        callback(new Error("请填写信息"));
      } else {
        console.log(value);
        callback();
      }
    };
    return {
      tableLoading: true,
      searchForm: {
        title: "",
        content: "",
        pageIndex: 1,
        pageSize: 10,
        total: 0
      },
      tableData: [],
      addCaseInfoForm: {
        id: "",
        title: "",
        content: "",
        codeId:'',
      },
        formName: "",
        dialogFormVisible: false,
        formLabelWidth: "120px",
      validRules: {
        title: [{ required: true, trigger: "blur", validator: validateRule }],
        content: [{ required: true, trigger: "blur", validator: validateRule }]
      },
      errorCodeList:[]
    };
  },
  methods: {
    resetDateFilter() {
      this.$refs.filterTable.clearFilter("date");
    },
    clearFilter() {
      this.searchForm.title = "";
      this.searchForm.content = "";
    },
    formatter(row, column) {
      if(!row.createDate){
        return '--';
      }
      return  parseTime(row.createDate);
    },
    filterTag(value, row) {
      return row.error_tag === value;
    },
    filterHandler(value, row, column) {
      const property = column["property"];
      return row[property] === value;
    },
    handleEdit(index, row) {
      console.log(index, row);
      this.addCaseInfoForm.title = row.title;
      this.addCaseInfoForm.id = row.id;
      this.addCaseInfoForm.content = row.content;
      this.addCaseInfoForm.codeId = row.codeId;
      this.formName = "编辑案例";
      this.dialogFormVisible = true;
    },
    handleDelete(index, row) {
      console.log(index, row);
      remove(row.id).then(res => {
        if (res.result) {
          this.$message.success("删除成功!");
          this.search();
        } else {
          this.$message.success("删除失败!");
        }
      });
    },
    onSearchSubmit() {
      this.search();
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.searchForm.pageSize = val;
      this.search();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.searchForm.pageIndex = val;
      this.search();
    },
    search() {
      console.log(this.tableLoading);
      this.tableLoading = true;

      console.log(this.tableLoading);
      query(this.searchForm).then(res => {
        console.log(res);
        if (res.result) {
          this.tableData = res.data.dataList;
          this.searchForm.pageIndex = res.data.pageIndex;
          this.searchForm.pageSize = res.data.pageSize;
          this.searchForm.total = res.data.totalCount;
        }
      });
      this.tableLoading = false;
      console.log(this.tableLoading);
    },
    addCaseInfo() {
      this.dialogFormVisible = true;
      this.formName = "增加案例";
    },
    saveCode() {
      if(!this.addCaseInfoForm.title){
        this.$message.warning('请填写案例标题信息')
        return;
      }
      if(!this.addCaseInfoForm.content){
        this.$message.warning('请填写案例内容信息')
        return;
      }
      if(!this.addCaseInfoForm.codeId){
        this.$message.warning('请选择错误码')
        return;
      }
      save(this.addCaseInfoForm).then(res => {
        if (res.result) {
          this.$message.success("保存成功");
          this.search();
        } else {
          this.$message.error("保存失败");
        }
      });
      this.clearSaveCode();
    },
    clearSaveCode() {
      this.addCaseInfoForm = {
        title: "",
        content: "",
        codeId:''
      
      };
        this.dialogFormVisible = false,
        this.formLabelWidth ="120px"
    },
    getErrorCodeList(){
      getErrorInfoAndCase({pageIndex:1,pageSize:100}).then(res => {
        if (res.result && !res.code) {
          this.errorCodeList = res.data.dataList
        }
      })
    }
  },
  mounted() {
    this.search();
    this.getErrorCodeList();
  }
};
</script>


<style lang="scss" scoped>
.search-area {
  width: 98%;
  height: 20%;
  margin: 10px 15px;
  padding: 5px;
}
.content-container {
  width: 98%;
  margin: 20px 15px;
}
.add-class {
  float: right;
  margin-right: 5%;
}
.save-input-class {
  width: 45%;
  margin-top: 1%;
}
.save-input-textarea-class {
  width: 60%;
}
.dialog-footer {
  margin-right: 3%;
}
</style>