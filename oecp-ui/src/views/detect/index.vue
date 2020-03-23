<template>
  <div class="app-container">
    <div class="row_border">
      <el-row :gutter="20">
        <el-col :span="20"><h2>错误码代码检测</h2></el-col>
        <el-col :span="4"><el-button type="success">提交检测</el-button></el-col>
      </el-row>
    </div>
    <div>
      <el-input
        type="textarea"
        :rows="30"
        placeholder="请输入你的代码"
        v-model="code">
      </el-input>
    </div>
  </div>
</template>

<script>
import { getList } from '@/api/table'

export default {
  data() {
    return {
      listLoading: false,
      code: ""
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
    }
  }
}
</script>
<style lang="scss" scoped>
.row_border {
  border-width: 1px;
  border-bottom-style: dashed;
}
</style>