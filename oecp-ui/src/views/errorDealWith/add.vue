<template>
  <oecp-page title="错误码新建" class="editCodePage">
    <el-form :model="addCodeForm" label-position="top" label-width="80px">
      <el-form-item label="错误码">
        <el-input style="width:30%" v-model="addCodeForm.code" placeholder="输入你要添加的错误码"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <el-input
          type="textarea"
          style="width:80%"
          rows="5"
          v-model="addCodeForm.errorInfo"
          placeholder="请输入该错误码的描述"
        ></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input style="width:50%" v-model="addCodeForm.errorDesc" placeholder="输入备注"></el-input>
      </el-form-item>
      <el-form-item label="标签">
        <el-tag
          :key="item.tag"
          v-for="item in tags"
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
        <el-form-item label="案例">
          <add-case-info
            v-for="(addCaseInfoForm,index) in oecpCaseInfoRequests"
            :key="index"
            :caseInfoIndex="index"
            :addCaseInfoForm="addCaseInfoForm"
            @delete="deleteCaseInfo"
          />
          <el-button
            type="primary"
            icon="el-icon-edit"
            style="margin-top:5px;margin-left: 10px;"
            @click="addCaseInfo"
          >增加案例</el-button>
        </el-form-item>
      </el-form-item>
      <!-- <el-button  class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button> -->
      <div class="confirm-class">
        <el-button @click="cancelCommit">取消</el-button>
        <el-button type="primary" @click="goToCommit">保存</el-button>
      </div>
    </el-form>
  </oecp-page>
</template>

<script>
import { query, save, remove, saveOecpErrorInfo } from '@/api/errorInfo'
import { contains } from '@/utils/index'
export default {
  data() {
    return {
      addCodeForm: {
        code: '',
        errorInfo: '',
        errorDesc: ''
      },
      tags: [],
      inputVisible: false,
      inputValue: '',
      oecpCaseInfoRequests: []
    }
  },
  methods: {
    handleClose(raw) {
      this.tags.splice(this.tags.indexOf(raw), 1)
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
      if (contains(this.tags, 'tag', inputValue)) {
        this.$message.warning('错误码标签重复添加')
        this.inputVisible = false
        this.inputValue = ''
        return
      }
      if (inputValue) {
        this.tags.push({ tag: inputValue })
      }
      this.inputVisible = false
      this.inputValue = ''
    },

    cancelCommit() {
      this.addCodeForm = {
        code: '',
        errorInfo: ''
      }
      this.tags = []
    },
    goToCommit() {
      let data = {
        code: this.addCodeForm.code,
        errorInfo: this.addCodeForm.errorInfo,
        tags: this.tags,
        oecpCaseInfoRequests: this.oecpCaseInfoRequests,
        errorDesc: this.addCodeForm.errorDesc
      }
      saveOecpErrorInfo(data).then(res => {
        if (res.result && !res.code) {
          this.$message.success('错误码新建成功!')
          this.$router.push('/fastcreateerrorcode/success')
        } else {
          this.$message.error('保存失败')
        }
      })
    },
    addCaseInfo() {
      this.oecpCaseInfoRequests.push({
        title: '',
        content: '',
        tags: []
      })
      console.log(this.oecpCaseInfoRequests)
    },
    deleteCaseInfo(index) {
      console.log(index)
      console.log(this.oecpCaseInfoRequests)
      this.oecpCaseInfoRequests.splice(index, 1)
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
</style>