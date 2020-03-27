<template>
  <oecp-page title="错误码详情" class="editCodePage">
    <el-form :model="addCodeForm" label-position="top" label-width="80px">
      <el-form-item label="错误码">{{addCodeForm.code}}</el-form-item>
      <el-form-item label="描述">{{addCodeForm.content}}</el-form-item>
      <el-form-item label="标签">
        <el-tag
          :key="tag"
          v-for="tag in dynamicTags"
          :disable-transitions="false"
          @close="handleClose(tag)"
        >{{tag}}</el-tag>
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
        <div class="case-class">没有找到对应的用户，一般为ACCESSKEY信息不正确，或者使用区域域名错误</div>
        <div class="case-class">排序表达式中的text_relevance(field)、fieldterm_proximity(field)等文本错误</div>
        <div class="case-class">feature中的field必须在查询的索引包含的源字段中，否则会报错，但不影响搜索结果</div>
        <div class="case-class">数据管理DMS产品内的工单审批、工单执行状态会通过2种方式进行通知</div>
        <div class="case-class">路由表必须为json串</div>
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
        code: 'RealNameAuthenticationError',
        content: 'Your account has not passed the real-name authentication yet.'
      },
      dynamicTags: ['111', '222', '333', '444', '555'],
      inputVisible: false,
      inputValue: ''
    }
  },
  methods: {
    handleClose(tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1)
    },

    showInput() {
      console.log('click')
      this.inputVisible = true
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus()
      })
    },

    handleInputConfirm() {
      let inputValue = this.inputValue
      if (inputValue) {
        this.dynamicTags.push(inputValue)
      }
      this.inputVisible = false
      this.inputValue = ''
    },

    cancelCommit() {
      this.addCodeForm = {
        code: '',
        content: ''
      }
      this.dynamicTags = []
    },
    goToCommit() {
      this.$message.success('错误码新建成功!')
    }
  },
  mounted() {}
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