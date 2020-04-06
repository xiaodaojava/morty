<template>
  <oecp-page title="案例详情">
    <h2>{{caseDetail.title}}</h2>
    <div v-if="caseDetail.creatorName" class="creator-class">
      
     <img :src="caseDetail.creatorAvator" class="avatar-class" />
      <span>{{caseDetail.creatorName}}</span>
      <span style="margin-left:48px;">创建时间: {{parseDate(caseDetail.createDate)}}</span>
    </div>

    <div class="content-class">
      {{caseDetail.content}}
    </div>
  </oecp-page>
</template>
<script>
import { formatUTCTime } from "@/utils/index";
import { get } from '@/api/caseInfo'
export default {
  data(){
    return{
      caseDetail:{}
    }
  },
  mounted(){
    this.caseDetail.id = this.$route.query.id
    get({id:this.caseDetail.id}).then(res=>{
      if(res.result){
        this.caseDetail = res.data
      }
    })
  },
  methods:{
    parseDate(time){
      return formatUTCTime(time,"yyyy年dd月MM日 HH:mm:ss")
    }
  }
}
</script>
<style lang="scss">
.avatar-class{
  width:40px;
  height:40px;
  border-radius:25px;
  vertical-align: middle;
}
.creator-class{
  font-size:12px;
  color: #3f3f3f;
}
</style>