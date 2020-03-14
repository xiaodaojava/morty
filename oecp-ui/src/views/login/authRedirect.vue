<template>
  <div class="redirect">
  How are you?
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
      console.log("auth_code =",this.auth_code);  
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
   font-size:40px;
}
</style>

