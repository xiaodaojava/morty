<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="案例主题：">
        <div class="input-class"><el-input v-model="form.name" /></div>
      </el-form-item>
      <el-form-item label="是否私密">
        <el-switch v-model="form.delivery" />
      </el-form-item>
      <el-form-item label="详情">
        <el-input 
        v-model="form.desc" 
        type="textarea" 
        :rows="15"
        placeholder="请输入内容"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">创建</el-button>
        <el-button @click="onCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
       userData:{}
    }
  },
  methods: {
    onSubmit() {
      this.$message('submit!')
    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    }
  },
    mounted(){
    this.userData = getUserInfo();
    console.log(this.userData) 
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
.input-class{
  width:50%;
}
</style>

