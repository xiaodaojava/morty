<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="昵称：">
        <div class="input-class"><el-input v-model="userData.nickName" disabled/></div>
      </el-form-item>
      <el-form-item label="来源：">
        <el-select v-model="userData.province">
          <el-option :label="userData.province" :value="userData.province" />
        </el-select>
        <el-select v-model="userData.city">
          <el-option :label="userData.city" :value="userData.city" />
        </el-select>
      </el-form-item>
      <el-form-item label="头像：">
        <img class="user-avatar" :src="userData.avatar"/>
      </el-form-item>
      <div
    </el-form>
  </div>
</template>

<script>
import {getUserInfo} from '@/utils/auth'
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
    this.userData = JSON.parse(getUserInfo());
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
.input-class{
  width:20%;
}
.user-avatar {
   width:150px;
   height:150px;
}
</style>

