<template>
  <div class="errorTag-container">
    <div class="search-area">
      <el-form :inline="true" :model="searchForm" class="demo-form-inline">
        <el-form-item label="标签">
          <el-input v-model="searchForm.tag" placeholder="请输入标签"></el-input>
        </el-form-item>
        <el-form-item label="创建时间">
          <el-date-picker
            v-model="searchForm.createForm"
            type="datetimerange"
            :picker-options="pickerOptions"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            align="right"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSearchSubmit">查询</el-button>
        </el-form-item>

        <el-button @click="clearFilter">清空</el-button>

        <div class="add-class">
          <el-button @click="addErrorTag" type="warning">+ 增加标签</el-button>
        </div>
      </el-form>
    </div>
    <el-table :data="tableData" style="width: 100%" align="center" :loading="tableLoading">
      <el-table-column type="index" label="编号" width="150"></el-table-column>
      <el-table-column prop="tag" label="标签" width="380"></el-table-column>
      <el-table-column prop="createDate" label="创建日期" sortable width="220" :formatter="formatter"></el-table-column>
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

    <el-dialog :title="addTagForm.formName" :visible.sync="addTagForm.dialogFormVisible">
      <el-form ref="addTagForm" :model="addTagForm" :rules="validRules">
        <el-form-item label="标签名称" :label-width="addTagForm.formLabelWidth">
          <div class="save-input-class">
            <el-input ref="tag" v-model="addTagForm.tag"></el-input>
          </div>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="clearSaveTag()">取 消</el-button>
        <el-button type="primary" @click="saveTag()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { query, save, remove } from '@/api/errorTag'
import { parseTime } from '@/utils/index'
export default {
  data() {
    const validateRule = (rule, value, callback) => {
      console.log(value)
      if (value.length < 1) {
        console.log(value)
        callback(new Error('请填写信息'))
      } else {
        console.log(value)
        callback()
      }
    }
    return {
      pickerOptions: {
        shortcuts: [
          {
            text: '最近一周',
            onClick(picker) {
              const end = new Date()
              const start = new Date()
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
              picker.$emit('pick', [start, end])
            }
          },
          {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date()
              const start = new Date()
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
              picker.$emit('pick', [start, end])
            }
          },
          {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date()
              const start = new Date()
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
              picker.$emit('pick', [start, end])
            }
          }
        ]
      },
      tableLoading: true,
      searchForm: {
        tag: '',
        createDate: '',
        pageIndex: 1,
        pageSize: 10,
        total: 0
      },
      tableData: [],
      addTagForm: {
        id: '',
        tag: '',
        dialogFormVisible: false,
        formLabelWidth: '120px',
        formName: ''
      },
      validRules: {
        tag: [{ required: true, trigger: 'blur', validator: validateRule }]
      }
    }
  },
  methods: {
    resetDateFilter() {
      this.$refs.filterTable.clearFilter('date')
    },
    clearFilter() {
      this.searchForm.tag = ''
    },
    formatter(row, column) {
      return parseTime(row.createDate)
    },
    filterTag(value, row) {
      return row.error_tag === value
    },
    filterHandler(value, row, column) {
      const property = column['property']
      return row[property] === value
    },
    handleEdit(index, row) {
      console.log(index, row)
      this.addTagForm.tag = row.tag
      this.addTagForm.id = row.id
      this.addTagForm.formName = '编辑标签'
      this.addTagForm.dialogFormVisible = true
    },
    handleDelete(index, row) {
      console.log(index, row)
      remove(row.id).then(res => {
        if (res.result) {
          this.$message.success('删除成功!')
          this.search()
        } else {
          this.$message.success('删除失败!')
        }
      })
    },
    onSearchSubmit() {
      console.log('submit!')
      this.search()
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
      this.searchForm.pageSize = val
      this.search()
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
      this.searchForm.pageIndex = val
      this.search()
    },
    search() {
      console.log(this.tableLoading)
      this.tableLoading = true

      console.log(this.tableLoading)
      query(this.searchForm).then(res => {
        console.log(res)
        if (res.result) {
          this.tableData = res.data.dataList
          this.searchForm.pageIndex = res.data.pageIndex
          this.searchForm.pageSize = res.data.pageSize
          this.searchForm.total = res.data.totalCount
        }
      })
      this.tableLoading = false
      console.log(this.tableLoading)
    },
    addErrorTag() {
      this.addTagForm.dialogFormVisible = true
      this.addTagForm.formName = '增加标签'
    },
    saveTag() {
      this.$refs.addTagForm.validate(valid => {
        if (!valid) {
          console.log('error submit!!')
          return
        }
      })
      save(this.addTagForm).then(res => {
        if (res.result) {
          this.$message.success('保存成功')
          this.search()
        } else {
          this.$message.error('保存失败')
        }
      })
      this.clearSaveTag()
    },
    clearSaveTag() {
      this.addTagForm = {
        tag: '',
        dialogFormVisible: false,
        formLabelWidth: '120px'
      }
    }
  },
  mounted() {
    this.search()
  }
}
</script>


<style lang="scss" scoped>
.search-area {
  width: 98%;
  height: 20%;
  margin: 10px 15px;
  padding: 5px;
}
.errorTag-container {
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