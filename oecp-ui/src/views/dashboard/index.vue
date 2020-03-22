<template>
  <div class="dashboard-container">
    <!-- <div class="dashboard-text">name: {{ name }}</div> -->
    <div class="dashboard-text">One ErrorCode Platform</div>
    <div class="searchClass">
      <el-input v-model="searchContent" placeholder="Enter Your ErrorCode">
        <el-button
          slot="append"
          icon="el-icon-search"
          @keydown.enter.native="searchEnter"
          @click="searchEnter"
        ></el-button>
      </el-input>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Dashboard",
  computed: {
    ...mapGetters(["name"])
  },
  data() {
    return {
      searchContent: ""
    };
  },
  methods: {
    searchEnter() {
      //searchCode(searchContent);
      this.$router.push(
        `/errorInfo/example?searchContent=${this.searchContent}`
      );
    }
  }
};
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}

.dashboard-text {
  font: normal 36px/30px "微软雅黑", "Arial";
  color: RGB(0, 160, 255);
  text-align: center;
  margin-top: 5%;
}
</style>

<style>
.searchClass {
  border: 1px solid #c5c5c5;
  border-radius: 20px;
  background: #fff;
  margin: 5% auto 0 auto;
  width: 61.8%;
}
.searchClass .el-input-group__prepend {
  border: none;
  background-color: transparent;
  padding: 0 10px 0 30px;
}
.searchClass .el-input-group__append {
  border: none;
  background-color: transparent;
}
.searchClass .el-input__inner {
  height: 36px;
  line-height: 36px;
  border: none;
  background-color: transparent;
}
.searchClass .el-icon-search {
  font-size: 16px;
}
.searchClass .centerClass {
  height: 100%;
  line-height: 100%;
  display: inline-block;
  vertical-align: middle;
  text-align: right;
}
.searchClass .line {
  width: 1px;
  height: 26px;
  background-color: #c5c5c5;
  margin-left: 14px;
}
.searchClass:hover {
  border: 1px solid #d5e3e8;
  background: #fff;
}
.searchClass:hover .line {
  background-color: #d5e3e8;
}
.searchClass:hover .el-icon-search {
  color: #409eff;
  font-size: 16px;
}
</style>
