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
</div>
</template>
<script>
  export default {
    data() {
      return {
        formInline: {
          user: '',
          region: ''
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>
<style lang="scss" scoped>
.errorInfo-container{
  width:98%;
  margin: 20px 15px;
}
</style>