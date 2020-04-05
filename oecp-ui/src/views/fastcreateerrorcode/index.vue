<template>
  <oecp-page title="快速申请错误码">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px">
      <el-form-item label="错误码code" prop="code">
        <el-input v-model="ruleForm.code"></el-input>
      </el-form-item>
      <el-form-item label="错误码描述" prop="errorInfo">
        <el-input type="textarea" v-model="ruleForm.errorInfo"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </oecp-page>
</template>
<script>
import { save } from '@/api/errorInfo'
export default {
  data(){
    return{
      ruleForm:{
        code:'',
        errorInfo:''
      },
      rules:{
        code:[
          {required:true,message:'请输入错误码名称',trigger:'blur'},
          {min:3,max:50,message:'长度在3到64个字符',trigger:'blur'}
        ],
        errorInfo:[
          {required:true,message:'请填写错误码描述',trigger:'blur'}
        ]
      }
    }
  },
  methods:{
    submitForm(formName){
      let self = this;
      console.log(formName)
      this.$refs[formName].validate((valid) =>{
        if(valid){
          save(self.ruleForm).then(res => {
            if (res.result && !res.code) {
              console.log('错误码新建成功!')
              this.$router.push('/fastcreateerrorcode/success')
            } else {
              this.$router.push({path:'/fastcreateerrorcode/failed',query:res})
            }
      })
        } else {
          console.log('error submit!!!');
          return false;
        }
      })
    },
    resetForm(formName){
      console.log(formName)
      this.$refs[formName].resetFields();
    }
  }
}
</script>
<style lang="scss" scoped>
</style>