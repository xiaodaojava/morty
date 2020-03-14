<template>
   <div class="testboard-container">
    <div class="testboard-title">
        测试接口心跳!
    </div>
     <div class="el-input-button">
    <el-button type="primary" icon="el-icon-search" @click="testApi">测试</el-button>
    </div>
   <div class="el-input-class">
   <el-input v-model="input" placeholder="请输入内容"></el-input>
   </div>
   <div class="el-input-button">
   <el-button type="primary" icon="el-icon-search" @click="search">搜索</el-button>
   </div>
   </div>
</template>


<script>
export default {
  name:'TestboardIndex',
  data(){
      return {
          content:'',
          input:''
      }
  },
  mouted(){
      
  },
  methods:{
      search(){
          
      },
      testApi(){
         
      }
  }

}
</script>



<style lang="scss" scoped>
.testboard-container{
    margin-left:3%;
    margin-top:2%;
}
.textboard-text{
   font:  normal 20px/30px '微软雅黑', 'Arial';
   text-align: left;
}
.el-input-class{
    width:300px;

}
.el-input-button{
    width: 85px;
    height: auto;
    margin: 20px 0;
}
</style>