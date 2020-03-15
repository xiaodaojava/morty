<template>
  <div class="login-container">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">

      <div class="title-container">
        <h3 class="title">oecp-账号登录</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        />
        <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span>
      </el-form-item>

      <el-button :loading="loading" type="primary" style="width:100%;margin-bottom:30px;" @click.native.prevent="handleLogin">登录</el-button>

      <div class="tips">
        <span style="margin-right:20px;">username: admin</span>
        <span> password: any</span>
      </div>
       <el-button class="thirdparty-button" type="primary" @click="showDialog=true">
          第三方登录
        </el-button>
      <!-- <icon-svg icon-class="ali"></icon-svg> -->
    </el-form>

    <el-dialog title="第三方登录" :visible.sync="showDialog">
      <social-sign @authCode="getAuthCode" @appId="getAppId"/>
    </el-dialog>
    <!-- <el-button type="success" @click="testApi">测试</el-button> -->
  </div>
</template>

<script>
import { validUsername } from '@/utils/validate'
import { health } from '@/api/test'
import axios from 'axios'
import SocialSign from './components/SocialSignin'
import { getAuthInfo } from '@/api/user'
export default {
  name: 'Login',
  components: { SocialSign },
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!validUsername(value)) {
        callback(new Error('Please enter the correct user name'))
      } else {
        callback()
      }
    }
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('The password can not be less than 6 digits'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        username: 'admin',
        password: '111111'
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur', validator: validateUsername }],
        password: [{ required: true, trigger: 'blur', validator: validatePassword }]
      },
      loading: false,
      passwordType: 'password',
      redirect: undefined,
      showDialog: false,
      authCode:'',
      accessToken:'',
      appId:''
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  methods: {
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          this.$store.dispatch('user/login', this.loginForm).then(() => {
            this.$router.push({ path: this.redirect || '/' })
            this.loading = false
          }).catch(() => {
            this.loading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    thirdLogin() {
      this.loading = true
      this.$store.dispatch('user/thirdLogin', this.authCode).then(() => {
        this.$router.push({ path: this.redirect || '/' })
        this.loading = false
      }).catch(() => {
        this.loading = false
      })
    },
    getUserInfo(acceccToken,appId){
      let _this = this;
      if(acceccToken == null){
        _this.$message.error("accessToken已过期");
      }
      this.$message.success("已进入getUserInfo方法");
      this.loading = true
      getAuthInfo(acceccToken,appId).then((res) => {
        console.log(res);  
        this.loading = false;
      }).catch(() => {
        this.loading = false
      })
    },
    testApi(){
      //   health().then(response => {
      //    this.$message.success("qweqwesxasfad");
      // })
      axios.post('/oecp/health.do',{

      }).then((res)=>{
        this.$message.success("接口调用成功");
      }).catch(()=>{
        this.$message.error("------qaq");
      })
    },
    getAuthCode(data){
      this.authCode = data;
      console.log('authCode为:'+data);
      if(data != undefined && data != 'undefined' && data != null && data != ''){
        console.log('code不为空,可以登录请求接口了')
        axios.get('/api/authRedirect',
        {
          params:{
            authCode: this.authCode,
            appId:this.appId
          }
         }
        ).then((res)=>{

            console.log(res);
            console.log(res.data);
            console.log(res.data.accessToken);
            this.accessToken = res.data.accessToken;
            this.getUserInfo(res.data.accessToken,this.appId);
            console.log("获取assToken成功");
            console.log("我要去登录了"); 
            console.log("我要去登录了"); 
            console.log("我要去登录了"); 
            console.log("我要去登录了"); 
            console.log("我要去登录了"); 
            console.log("我要去登录了"); 
            console.log("我要去登录了"); 
            this.handleLogin();
          }).catch(error=>{
            this.$message.error("获取token有点问题:",error);
          })
      }
    },
    getAppId(appId){
      this.appId = appId;
    }
  }
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg:#283443;
$light_gray:#fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }

   .thirdparty-button {
    position: absolute;
    right: 0;
    bottom: 6px;
  }

  @media only screen and (max-width: 470px) {
    .thirdparty-button {
      display: none;
    }
  }
}
</style>
