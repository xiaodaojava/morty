<template>
  <oecp-page title="错误码新建" class="editCodePage">
    <el-form :model="addCodeForm" label-position="top" label-width="80px">
      <el-form-item label="错误码">
        <el-input style="width:50%" v-model="addCodeForm.code" placeholder="输入你要添加的错误码"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <el-input
          type="textarea"
          style="width:80%"
          rows="5"
          v-model="addCodeForm.content"
          placeholder="请输入该错误码的描述"
        ></el-input>
      </el-form-item>
      <el-form-item label="标签">
        <el-tag
          :key="tag"
          v-for="tag in dynamicTags"
          closable
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

        <add-tags v-else @click.native="showInput" addTagsName="增加标签" />
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
export default {
  data() {
    return {
      addCodeForm: {
        code: "",
        content: ""
      },
      dynamicTags: [],
      inputVisible: false,
      inputValue: ""
    };
  },
  methods: {
    handleClose(tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
    },

    showInput() {
      console.log("click");
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },

    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.dynamicTags.push(inputValue);
      }
      this.inputVisible = false;
      this.inputValue = "";
    },

    cancelCommit() {
      this.addCodeForm = {
        code: "",
        content: ""
      };
      this.dynamicTags = [];
    },
    goToCommit() {
      this.$message.success("错误码新建成功!");
    }
  },
  mounted() {}
};
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