(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-73793489"],{"7a2d":function(t,e,n){},c99f:function(t,e,n){"use strict";var o=n("7a2d"),c=n.n(o);c.a},f26c:function(t,e,n){"use strict";n.r(e);var o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("div",{staticClass:"row_border"},[n("el-row",{attrs:{gutter:20}},[n("el-col",{attrs:{span:20}},[n("h2",[t._v("错误码代码检测")])]),t._v(" "),n("el-col",{attrs:{span:2}},[n("el-button",{attrs:{type:"primary",loading:t.listLoading},on:{click:t.simpleCode}},[t._v("示例代码")])],1),t._v(" "),n("el-col",{attrs:{span:2}},[n("el-button",{attrs:{type:"success",loading:t.listLoading},on:{click:t.detectCode}},[t._v("提交检测")])],1)],1)],1),t._v(" "),n("div",[n("el-input",{attrs:{type:"textarea",rows:30,placeholder:"请输入你的代码"},model:{value:t.code,callback:function(e){t.code=e},expression:"code"}})],1)])},c=[],s=n("b775");function a(t){return Object(s["a"])({headers:{"Content-Type":"application/json"},url:"/oecpCodeDetect",method:"post",data:t})}n("bc3a");var i={data:function(){return{listLoading:!1,code:""}},created:function(){this.fetchData()},methods:{fetchData:function(){},detectCode:function(){var t=this;a({code:this.code}).then((function(e){e.result?t.$message({message:"恭喜你，检测不存在未定义错误码",type:"success"}):t.$message.error(e.msg)})).catch((function(e){t.$message.error(e.msg)}))},simpleCode:function(){this.code='\n        package com.platform.oecp.admin.test;\n\n        /**\n        * 检测测试，检测 Throw new Exception 中不存在的错误码，这里 123123 和 404 都是已经存在的错误码.\n        *\n        * @version 1.0.0\n        */\n        public class TestDetect {\n\n            public static final String code1 = "404";\n\n            private String code2 = "234";\n\n            public void test1() throws Exception {\n                throw new Exception("123123");\n            }\n\n            public void test2() throws Exception {\n                throw new Exception(code1);\n            }\n\n            public void test3() throws Exception {\n                throw new Exception(code2);\n            }\n\n        }\n\n      '}}},r=i,d=(n("c99f"),n("2877")),l=Object(d["a"])(r,o,c,!1,null,"77403d39",null);e["default"]=l.exports}}]);