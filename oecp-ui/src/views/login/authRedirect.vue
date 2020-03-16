<template>
</template>

<script>
import { setAuthCode } from '@/utils/auth'
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
    setAuthCode(this.params.auth_code);
    window.close();
  },
  mounted() {
      this.params = this.$route.query;
      this.auth_code = this.params.auth_code;
      setAuthCode(this.params.auth_code);
      window.close();
  }
}
</script>
