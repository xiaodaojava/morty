<template>
  <div class="app-container">
    <div class="row_border">
      <el-row :gutter="20">
        <el-col :span="20"><h2>错误码代码检测</h2></el-col>
        <el-col :span="2"><el-button type="primary" :loading="listLoading" @click="simpleCode">示例代码</el-button></el-col>
        <el-col :span="2"><el-button type="success" :loading="listLoading" @click="detectCode">提交检测</el-button></el-col>
      </el-row>
    </div>
    <div>
      <el-input
        type="textarea"
        :rows="30"
        placeholder="请输入你的代码"
        v-model="code">
      </el-input>
    </div>
  </div>
</template>

<script>
import { detect,health } from '@/api/codeDetect'
import axios from "axios";

export default {
  data() {
    return {
      listLoading: false,
      code: ""
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
    },
    detectCode() {
      detect({'code': this.code}).then(res=> {
        if(res.result) {
          this.$message({
            message: '恭喜你，检测不存在未定义错误码',
            type: 'success'
          });
        } else {
          this.$message.error(res.msg); 
        }
        
      }).catch(error => {
        this.$message.error(error.msg);
      })
    },
    // 填充示例代码
    simpleCode: function() {
      this.code = `
        package com.platform.oecp.admin.test;

        /**
        * 检测测试，检测 Throw new Exception 中不存在的错误码，这里 123123 和 404 都是已经存在的错误码.
        *
        * @version 1.0.0
        */
        public class TestDetect {

            public static final String code1 = "404";

            private String code2 = "234";

            public void test1() throws Exception {
                throw new Exception("123123");
            }

            public void test2() throws Exception {
                throw new Exception(code1);
            }

            public void test3() throws Exception {
                throw new Exception(code2);
            }

        }

      `
    }
  }
}
</script>
<style lang="scss" scoped>
.row_border {
  border-width: 1px;
  border-bottom-style: dashed;
}
</style>