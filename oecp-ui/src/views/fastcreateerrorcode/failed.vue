<template>
  <oecp-page title="申请错误码失败">
    <div class="message-class">
     <img :src="failedImg" class="create-failed-class"/>
     <div class="text-class">
       申请错误码失败<br/>
       <div class="err-desc-class">
       错误代码:<div class="red-font">{{failedReason.code}}</div><br/>
       错误原因:<div class="red-font">{{failedReason.msg}}</div><br/>
       </div>
       <span @click="goBackToCreated">返回上一级</span>
     </div>
    </div>
    
  </oecp-page>
</template>
<script>
import CreateFailedLogo from '@/assets/images/error.png'
export default {
  data(){
    return{
      failedImg: CreateFailedLogo,
      failedReason:{

      }
    }
  },
  methods:{
    goBackToCreated(){
      this.$router.push('/fastcreateerrorcode/index')
    }
  },
  mounted(){
    console.log(this.failedImg)
    this.failedReason = this.$route.query
  }
}
</script>
<style lang="scss" scoped>
.create-failed-class{
  width:20%;
  vertical-align: middle;
}
.message-class{
  display: block;
  text-align: center;
}
.text-class{
  font:  bold 20px/34px'微软雅黑', 'Arial';
  color: #36373c;
  margin-top:10px;
  span{
    cursor: pointer;
    color: #11a9ef;
    font:  normal 20px/55px '微软雅黑', 'Arial';
  }
}
.red-font{
  color:red;
  display:inline-block;
}
.err-desc-class{
  text-align: left;
  width: 225px;
  margin: 20px auto;
}
</style>