(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-53512569"],{"48ff":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],attrs:{data:t.list,"element-loading-text":"Loading",border:"",fit:"","highlight-current-row":""}},[a("el-table-column",{attrs:{align:"center",label:"ID",width:"95"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.$index+1))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"Title"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.title))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"Author",width:"110",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.author))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"Pageviews",width:"110",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.pageviews))]}}])}),t._v(" "),a("el-table-column",{attrs:{"class-name":"status-col",label:"Status",width:"110",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-tag",{attrs:{type:t._f("statusFilter")(e.row.status)}},[t._v(t._s(e.row.status))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",prop:"created_at",label:"Display_time",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-time"}),t._v(" "),a("span",[t._v(t._s(e.row.display_time))])]}}])})],1)],1)},l=[],s=(a("ad8f"),{filters:{statusFilter:function(t){var e={published:"success",draft:"gray",deleted:"danger"};return e[t]}},data:function(){return{list:[{id:"1",title:"234123123123123",status:"publish",author:"name",display_time:"2020-03-16",pageviews:"123"}],listLoading:!0,exampleSearchText:"",formInline:{}}},created:function(){this.fetchData()},methods:{fetchData:function(){this.listLoading=!0,this.listLoading=!1},onSubmit:function(){console.log("submit!")},addExample:function(){this.$router.push("/errorInfo/example-add")}}}),i=s,r=(a("4e01"),a("2877")),o=Object(r["a"])(i,n,l,!1,null,"218822e4",null);e["default"]=o.exports},"4e01":function(t,e,a){"use strict";var n=a("9f27"),l=a.n(n);l.a},"9f27":function(t,e,a){},ad8f:function(t,e,a){"use strict";a("b775")}}]);