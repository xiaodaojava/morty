<template>
  <div class="redirect">
  您的appId是{{this.params.app_id}}<br/>
  source:{{this.params.source}}<br/>
  scope:{{this.params.scope}}<br/>
  authCode：{{this.params.auth_code}}
  
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      params:{},
      auth_code:''
    }
  },
  methods: {
    
  },
  activated () {
      console.log('activated');  
      this.params = this.$route.query;
      console.log(this.params);  
  },
  mounted() {
      console.log('mounted');  
      this.params = this.$route.query;
      this.auth_code = this.params.auth_code;
      console.log("params =",this.params);  
      // 提交authCode给后台 然后进行登录 axios.post()
      //if success 重定向到主页面
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
.redirect{
   font-size:25px;
   display:none;
}
</style>

