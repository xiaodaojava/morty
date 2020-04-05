<template>
  <oecp-page title="申请错误码成功">
    <div class="message-class">
     <img :src="successImg" class="create-success-class"/>
     <div class="text-class">
       您已成功申请错误码<br/>
       <span @click="goToMyErrorCode">我的错误码</span>进行查看 &nbsp;&nbsp;
       <span @click="goToAllErrorCode">平台错误码</span>进行查看
     </div>
    </div>
    
  </oecp-page>
</template>
<script>
import { save } from '@/api/errorInfo'
import CreateSuccessLogo from '@/assets/images/fast-create-success.png'
export default {
  data(){
    return{
      successImg: CreateSuccessLogo
    }
  },
  methods:{
    goToMyErrorCode(){
      this.$router.push('/errorDealWith/list')
    },
    goToAllErrorCode(){
      this.$router.push('/searchboardResult/normalResult')
    }
  },
  mounted(){
    console.log(this.successImg)
  }
}
</script>
<style lang="scss" scoped>
.create-success-class{
  width:25%;
  vertical-align: middle;
}
.message-class{
  display: block;
  text-align: center;
}
.text-class{
  font:  normal 20px/55px '微软雅黑', 'Arial';
  color: #36373c;
  span{
    cursor: pointer;
    color: #11a9ef;
  }
}
</style>