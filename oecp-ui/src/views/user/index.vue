<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px" class="userInfo-el-class">
      <el-form-item label="昵称：">
        <div class="input-class">
          <el-input v-model="userData.nickName" disabled />
        </div>
      </el-form-item>
      <el-form-item label="用户名：(accountId)">
        <div class="input-class" style="margin-top:10px;">
          <el-input v-model="userData.accountId" disabled />
        </div>
      </el-form-item>
      <el-form-item label="密码：">
        <div class="password-class">
          <div class="input-class">
            <el-input value="*********" disabled />
          </div>
          <el-button type="warning" @click="dialogPasswordFormVisible = true">修改密码</el-button>
        </div>
      </el-form-item>
      <el-form-item label="来源：">
        <el-select v-model="userData.province">
          <el-option :label="userData.province" :value="userData.province" />
        </el-select>
        <el-select v-model="userData.city">
          <el-option :label="userData.city" :value="userData.city" />
        </el-select>
      </el-form-item>
      <el-form-item label="头像：">
        <img class="user-avatar" :src="userData.avatar" />
      </el-form-item>
    </el-form>

    <el-dialog title="修改密码" :visible.sync="dialogPasswordFormVisible" class="fix-password-dialog">
      <el-form :model="passwordForm">
        <el-form-item v-if="!passwordForm.thirtyLogin" label="旧密码" :label-width="formLabelWidth">
          <div class="fix-password-class">
            <el-input v-model="passwordForm.oldPassword" autocomplete="off" show-password></el-input>
          </div>
        </el-form-item>
        <el-form-item label="新密码" :label-width="formLabelWidth">
          <div class="fix-password-class">
            <el-input v-model="passwordForm.newPassword" autocomplete="off" show-password></el-input>
          </div>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogPasswordFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirmPassword">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getUserInfo, getAuthCode } from "@/utils/auth";
import { updateUserInfo } from "@/api/user";
export default {
  data() {
    return {
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      },
      userData: {},
      dialogPasswordFormVisible: false,
      formLabelWidth: "120px",
      passwordForm: {
        accountId: "",
        oldPassword: "",
        newPassword: "",
        thirtyLogin: false
      }
    };
  },
  methods: {
    onSubmit() {
      this.$message("submit!");
    },
    onCancel() {
      this.$message({
        message: "cancel!",
        type: "warning"
      });
    },
    confirmPassword() {
      if (this.passwordForm.newPassword == "") {
        this.$message.error("请输入密码且不少于6位");
        return;
      }
      updateUserInfo(this.passwordForm).then(res => {
        console.log(res);
        if (res.result) {
          this.dialogPasswordFormVisible = false;
          this.$message.success("修改成功");
        }
      });
    }
  },
  mounted() {
    this.userData = JSON.parse(getUserInfo());
    this.passwordForm.accountId = this.userData.accountId;
    let authCode = getAuthCode();
    if (authCode != null && authCode != undefined && authCode != "") {
      this.passwordForm.thirtyLogin = true;
    }
  }
};
</script>

<style lang="scss" scoped>
.line {
  text-align: center;
}
.input-class {
  width: 20%;
}
.user-avatar {
  width: 150px;
  height: 150px;
}
.password-class {
  width: 50%;
  display: inline-flex;
}
.fix-password-class {
  width: 45%;
}
</style>

<style lang="scss">
.userInfo-el-class .el-form-item__label {
  font: normal 14px/30px "微软雅黑", "Arial";
  margin-top: 10px;
}
.fix-password-dialog .el-form-item__label {
  font: normal 17px/37px "微软雅黑", "Arial";
}
</style>
