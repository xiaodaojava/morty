<template>
  <div class="add-caseInfo-class">
    <el-form :model="addCaseInfoForm" label-position="top" label-width="80px">
      <el-form-item label="案例标题">
        <el-input
          style="width:60%"
          size="small"
          v-model="addCaseInfoForm.title"
          placeholder="请输入案例标题"
          maxLength="50"
        ></el-input>
      </el-form-item>
      <el-form-item label="案例描述">
        <el-input
          type="textarea"
          style="width:80%"
          rows="5"
          v-model="addCaseInfoForm.content"
          placeholder="请输入该案例的描述"
          maxLength="50"
        ></el-input>
      </el-form-item>
      <el-form-item label="案例标签">
        <el-tag
          :type="itemIndex%2 == 0? 'danger' : 'warning'"
          :key="item.tag"
          v-for="(item,itemIndex) in addCaseInfoForm.caseTags"
          closable
          :disable-transitions="false"
          @close="handleClose(item)"
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

        <add-tags v-else @click.native="showInput" addTagsName="增加标签" />
        <br />
        <el-button style="margin-top:10px;" type="warning" icon="el-icon-delete" @click="deleteThisCaseInfo">删除该案例</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { contains } from '@/utils/index'
export default {
  name: 'AddCaseInfo',
  props: {
    caseInfoIndex: {
      type: Number,
      required: true
    },
    addCaseInfoForm: {
      type: Object,
      default() {
        return {
          title: '',
          content: '',
          caseTags: []
        }
      }
    }
  },
  data() {
    return {
      inputVisible: false,
      inputValue: ''
    }
  },
  computed: {},
  methods: {
    handleClose(item) {
      console.log(item)
      this.addCaseInfoForm.caseTags.splice(
        this.addCaseInfoForm.caseTags.indexOf(item),
        1
      )
    },
    handleInputConfirm() {
      let inputValue = this.inputValue
      if (contains(this.addCaseInfoForm.caseTags, 'tag', inputValue)) {
        this.$message.warning('标签名重复添加')
        this.inputVisible = false
        this.inputValue = ''
        return
      }
      if (inputValue) {
        this.addCaseInfoForm.caseTags.push({ tag: inputValue })
      }
      this.inputVisible = false
      this.inputValue = ''
    },
    showInput() {
      console.log('click')
      this.inputVisible = true
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus()
      })
    },
    deleteThisCaseInfo() {
      this.$emit('delete', this.caseInfoIndex)
    }
  },
  mounted(){
    console.log('addCaseInfo-------》')
    console.log(this.addCaseInfoForm)
  }
}
</script>

<style scoped>
.add-caseInfo-class {
  padding-left: 10px;
  width: 80%;
}
</style>
