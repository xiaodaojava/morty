(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-248d1dbe"],{"7cea":function(e,a,t){"use strict";var s=t("9b62"),r=t.n(s);r.a},"9b62":function(e,a,t){},e382:function(e,a,t){"use strict";t.r(a);var s=function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",{staticClass:"app-container"},[t("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[t("el-form-item",{attrs:{label:"昵称："}},[t("div",{staticClass:"input-class"},[t("el-input",{attrs:{disabled:""},model:{value:e.userData.nickName,callback:function(a){e.$set(e.userData,"nickName",a)},expression:"userData.nickName"}})],1)]),e._v(" "),t("el-form-item",{attrs:{label:"来源："}},[t("el-select",{model:{value:e.userData.province,callback:function(a){e.$set(e.userData,"province",a)},expression:"userData.province"}},[t("el-option",{attrs:{label:e.userData.province,value:e.userData.province}})],1),e._v(" "),t("el-select",{model:{value:e.userData.city,callback:function(a){e.$set(e.userData,"city",a)},expression:"userData.city"}},[t("el-option",{attrs:{label:e.userData.city,value:e.userData.city}})],1)],1),e._v(" "),t("el-form-item",{attrs:{label:"头像："}},[t("img",{staticClass:"user-avatar",attrs:{src:e.userData.avatar}})])],1)],1)},r=[],n=t("5f87"),i={data:function(){return{form:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},userData:{}}},methods:{onSubmit:function(){this.$message("submit!")},onCancel:function(){this.$message({message:"cancel!",type:"warning"})}},mounted:function(){this.userData=JSON.parse(Object(n["c"])())}},c=i,l=(t("7cea"),t("2877")),u=Object(l["a"])(c,s,r,!1,null,"2ef40076",null);a["default"]=u.exports}}]);