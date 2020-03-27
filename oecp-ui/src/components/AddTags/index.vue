<template>
  <div class="add-tags-class">
    <svg-icon icon-class="addto" class="icon" />
    <div class="addTags">{{addTagsName}}</div>
  </div>
</template>

<script>
export default {
  name: "AddTags",
  props: {
    addTagsName: {
      type: String,
      required: true
    }
  },
  computed: {}
};
</script>

<style scoped>
.icon {
  width: 25px;
  height: 30px;
  padding: 0 0 0 0;
  margin: -3px -5px 0 0;
  vertical-align: middle;
}
.addTags {
  color: #1693d6;
  margin: 0px 0px 0px 0px;
  display: inline-block;
  font-size: 14px;
}
.add-tags-class {
  display: inline-block;
  cursor: pointer;
  width: 105px;
  padding-top: 5px;
}
</style>
