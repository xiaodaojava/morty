<template>
  <div class="content-container">
    <div class="search-area">
      <el-form :inline="true" :model="searchForm" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="searchForm.name" placeholder="请输入名称"></el-input>
        </el-form-item>
        <el-form-item label="机构地址">
          <el-input v-model="searchForm.address" placeholder="机构地址"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSearchSubmit">查询</el-button>
        </el-form-item>

        <el-button @click="clearFilter">清空</el-button>

        <div class="add-class">
          <el-button @click="addOrg" type="warning">+ 增加机构</el-button>
        </div>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%" align="center" :loading="tableLoading">
      <el-table-column prop="sort" label="排序" width="150"></el-table-column>
      <el-table-column prop="name" label="机构名字" width="200"></el-table-column>
      <el-table-column prop="grade" label="机构等级" width="100"></el-table-column>
      <el-table-column prop="address" label="联系地址" width="300"></el-table-column>
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

    <el-dialog :name="addOrgForm.formName" :visible.sync="addOrgForm.dialogFormVisible">
      <el-form ref="addOrgForm" :model="addOrgForm" :rules="validRules">
        <el-form-item label="机构名称" :label-width="addOrgForm.formLabelWidth">
          <div class="save-input-class">
            <el-input ref="name" v-model="addOrgForm.name"></el-input>
          </div>
        </el-form-item>
        <el-form-item label="机构地址" :label-width="addOrgForm.formLabelWidth">
          <div class="save-input-textarea-class">
            <el-input
              ref="address"
              type="textarea"
              :rows="5"
              v-model="addOrgForm.address"
              placeholder="请输入内容"
            ></el-input>
          </div>
        </el-form-item>
        <el-form-item label="排序" :label-width="addOrgForm.formLabelWidth">
          <div class="save-input-class">
            <el-input v-model="addOrgForm.sort"></el-input>
          </div>
        </el-form-item>
        <el-form-item label="机构等级" :label-width="addOrgForm.formLabelWidth">
          <div class="save-input-class">
            <el-input v-model="addOrgForm.grade"></el-input>
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
import { query, save, remove } from "@/api/errorOrg";
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
        name: "",
        address: "",
        pageIndex: 1,
        pageSize: 10,
        total: 0
      },
      tableData: [],
      addOrgForm: {
        id: "",
        name: "",
        address: "",
        sort: "",
        grade: "",
        dialogFormVisible: false,
        formLabelWidth: "120px",
        formName: ""
      },
      validRules: {
        name: [{ required: true, trigger: "blur", validator: validateRule }],
        address: [{ required: true, trigger: "blur", validator: validateRule }]
      }
    };
  },
  methods: {
    resetDateFilter() {
      this.$refs.filterTable.clearFilter("date");
    },
    clearFilter() {
      this.searchForm.name = "";
      this.searchForm.address = "";
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
      this.addOrgForm.name = row.name;
      this.addOrgForm.id = row.id;
      this.addOrgForm.address = row.address;
      this.addOrgForm.formName = "编辑机构";
      this.addOrgForm.dialogFormVisible = true;
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
    addOrg() {
      this.addOrgForm.dialogFormVisible = true;
      this.addOrgForm.formName = "增加机构";
    },
    saveCode() {
      this.$refs.addOrgForm.validate(valid => {
        if (!valid) {
          console.log("error submit!!");
          return;
        }
      });
      save(this.addOrgForm).then(res => {
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
      this.addOrgForm = {
        name: "",
        address: "",
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