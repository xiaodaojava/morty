<template>
  <div class="social-signup-container">
    <div class="sign-btn" @click="alipayHandleClick('alipay')">
      <span class="ali-svg-container"><svg-icon icon-class="ali" class="icon" /></span>
        &nbsp;&nbsp;支付宝登录
    </div>
   <!-- <div class="sign-btn" @click="tencentHandleClick('tencent')">
      <span class="qq-svg-container"><svg-icon icon-class="qq" class="icon" /></span>
      QQ
    </div>
   -->
   </div>
</template>

<script>
import openWindow from '@/utils/open-window'

export default {
  name: 'SocialSignin',
  methods: {
    alipayHandleClick(thirdpart) {
      //alert('ok')
      this.$store.commit('SET_AUTH_TYPE', thirdpart)
      const appid = '2021001141609481'
      const redirect_uri = encodeURIComponent('https://oecp.lixiang.red/auth-redirect')
      const url = 'https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=' + appid + '&scope= auth_user&redirect_uri=' + redirect_uri
      
      openWindow(url, thirdpart, 750,600)
    },
    tencentHandleClick(thirdpart) {
      alert('ok')
      // this.$store.commit('SET_AUTH_TYPE', thirdpart)
      // const client_id = 'xxxxx'
      // const redirect_uri = encodeURIComponent('xxx/redirect?redirect=' + window.location.origin + '/auth-redirect')
      // const url = 'https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=' + client_id + '&redirect_uri=' + redirect_uri
      // openWindow(url, thirdpart, 540, 540)
    }
  }
}
</script>

<style lang="scss" scoped>
  .social-signup-container {
    margin: 0 0;
    .sign-btn {
      display: inline-block;
      cursor: pointer;
    }
    .icon {
      color: #fff;
      font-size: 42px;
      margin-right: 5px;
    }
    .ali-svg-container,
    .qq-svg-container {
      display: inline-block;
      width: 30px;
      height: 30px;
      line-height: 40px;
      text-align: center;
      padding-top: 1px;
      border-radius: 4px;
      margin-bottom: 20px;
      margin-right: 5px;
    }
    .ali-svg-container {
      background-color: #fff;
    }
    .qq-svg-container {
      background-color: #6BA2D6;
      margin-left: 50px;
    }
  }
</style>
