<template>
  <div v-if="ifHaveSearch" class="search-result-class">
    你要搜索的内容：“{{ searchContent }}”,有以下结果
  </div>
  <!-- <div v-else class="search-result-class">没有什么结果{{searchContent}}</div> -->
</template>
<script>
export default {
  name: "SearchMessage",
  props: {
    searchContent: {
      type: String,
      required: false
    }
  },
  computed: {
    ifHaveSearch() {
      return this.searchContent != null && this.searchContent != "";
    }
  }
};
</script>
<style scoped>
.search-result-class {
  color: #00c1de;
  margin-top: 5px;
  margin-bottom: 15px;
}
</style>
