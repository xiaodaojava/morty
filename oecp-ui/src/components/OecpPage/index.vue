<template>
  <div class="page-class">
    <div class="inner-page-class">
      <div class="title-class">{{title}}</div>
      <div class="content-class">
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "OecpPage",
  props: {
    title: {
      type: String,
      required: true
    }
  },
  computed: {}
};
</script>

<style scoped>
.page-class {
  padding: 20px;
}
.inner-page-class {
  background-color: #fff;
}
.title-class {
  border-left: 5px solid yellow;
  padding: 0px 20px 2px 8px;
  font-weight: 600;
  font-size: 20px;
  color: #606a87;
}
.content-class {
  padding: 17px 0px 10px;
}
</style>
