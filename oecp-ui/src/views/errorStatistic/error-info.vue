<template>
  <div class="errorInfo-container">
    <div class="search-area">
      <el-form :inline="true" :model="searchForm" class="demo-form-inline">
        <el-form-item label="错误码">
          <el-input v-model="searchForm.code" placeholder="请输入错误码"></el-input>
        </el-form-item>
        <el-form-item label="错误码描述">
          <el-input v-model="searchForm.errorInfo" placeholder="请输入错误码描述"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSearchSubmit">查询</el-button>
        </el-form-item>

        <el-button @click="clearFilter">清空</el-button>

        <div class="add-class">
          <el-button @click="addErrorCode" type="warning">+ 增加错误码</el-button>
        </div>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%" align="center" :loading="tableLoading">
      <el-table-column type="index" label="编号" width="150"></el-table-column>
      <el-table-column prop="code" label="错误码" width="250"></el-table-column>
      <el-table-column prop="errorInfo" label="错误码描述" width="350"></el-table-column>
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

    <el-dialog :title="addCodeForm.formName" :visible.sync="addCodeForm.dialogFormVisible">
      <el-form ref="addCodeForm" :model="addCodeForm" :rules="validRules">
        <el-form-item label="错误码名称" :label-width="addCodeForm.formLabelWidth">
          <div class="save-input-class">
            <el-input ref="code" v-model="addCodeForm.code"></el-input>
          </div>
        </el-form-item>
        <el-form-item label="错误码描述" :label-width="addCodeForm.formLabelWidth">
          <div class="save-input-textarea-class">
            <el-input
              ref="errorInfo"
              type="textarea"
              :rows="5"
              v-model="addCodeForm.errorInfo"
              placeholder="请输入描述"
            ></el-input>
          </div>
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
import { query, save, remove } from "@/api/errorInfo";
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
        code: "",
        errorInfo: "",
        pageIndex: 1,
        pageSize: 10,
        total: 0
      },
      tableData: [],
      addCodeForm: {
        id: "",
        code: "",
        errorInfo: "",
        dialogFormVisible: false,
        formLabelWidth: "120px",
        formName: ""
      },
      validRules: {
        code: [{ required: true, trigger: "blur", validator: validateRule }],
        errorInfo: [
          { required: true, trigger: "blur", validator: validateRule }
        ]
      }
    };
  },
  methods: {
    resetDateFilter() {
      this.$refs.filterTable.clearFilter("date");
    },
    clearFilter() {
      this.searchForm.code = "";
      this.searchForm.errorInfo = "";
    },
    formatter(row, column) {
      return parseTime(row.createDate);
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
      this.addCodeForm.code = row.code;
      this.addCodeForm.id = row.id;
      this.addCodeForm.errorInfo = row.errorInfo;
      this.addCodeForm.formName = "编辑错误码";
      this.addCodeForm.dialogFormVisible = true;
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
      console.log("submit!");
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
    addErrorCode() {
      this.addCodeForm.dialogFormVisible = true;
      this.addCodeForm.formName = "增加错误码";
    },
    saveCode() {
      this.$refs.addCodeForm.validate(valid => {
        if (!valid) {
          console.log("error submit!!");
          return;
        }
      });
      save(this.addCodeForm).then(res => {
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
      this.addCodeForm = {
        code: "",
        errorInfo: "",
        dialogFormVisible: false,
        formLabelWidth: "120px"
      };
    }
  },
  mounted() {
    this.search();
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
.errorInfo-container {
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