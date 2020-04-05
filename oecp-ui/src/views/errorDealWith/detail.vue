<template>
  <oecp-page title="错误码详情" class="editCodePage">
    <el-form :model="addCodeForm" label-position="top" label-width="80px">
      <el-form-item label="错误码">{{addCodeForm.code}}</el-form-item>
      <el-form-item label="描述">{{addCodeForm.errorInfo}}</el-form-item>
      <el-form-item label="标签">
        <el-tag
          :key="tagIndex"
          v-for="(item,tagIndex) in dynamicTags"
          :disable-transitions="false"
          @close="handleClose(tag)"
        >{{item.tag}}</el-tag>
        <el-input
          class="input-new-tag"
          v-if="inputVisible"
          v-model="inputValue"
          ref="saveTagInput"
          size="small"
          @keyup.enter.native="handleInputConfirm"
          @blur="handleInputConfirm"
        ></el-input>

        <!-- <add-tags v-else @click.native="showInput" addTagsName="增加标签" /> -->
      </el-form-item>
      <el-form-item label="相关案例">
        <div class="case-class" v-for="(item,index) in caseInfos" :key="index" @click="gotoCaseDetail(item)">{{item.title}}</div>
      </el-form-item>
      <!-- <el-button  class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button> -->
    </el-form>
  </oecp-page>
</template>

<script>
export default {
  data() {
    return {
      addCodeForm: {
        code: '',
        errorInfo: ''
      },
      dynamicTags: [],
      caseInfos:[],
      inputVisible: false,
      inputValue: ''
    }
  },
  methods: {
    gotoCaseDetail(item){
       this.$router.push({path:'/searchboardResult/caseDetail',query:{id:item.caseId}})
    }
  },
  mounted() {
    let params = this.$route.params.data;
    this.addCodeForm = params;
    this.dynamicTags = params.errorTags;
    this.caseInfos = params.caseInfos;

  }
}
</script>

<style scoped>
</style>
<style>
.el-tag + .el-tag {
  margin-left: 10px;
}
.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}
.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}
.label-class {
  font-size: 16px;
  margin: 5px;
}
.confirm-class {
  padding-left: 30%;
}
.editCodePage .el-form-item__label {
  line-height: 35px;
  font-size: 16px;
  padding: 10px 0 0;
}
.case-class {
  font-size: 14px;
  color: black;
}
.case-class:hover {
  color: #00c1de;
  cursor: pointer;
}
</style>