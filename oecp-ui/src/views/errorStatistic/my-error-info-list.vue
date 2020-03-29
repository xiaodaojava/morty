<template>
  <oecp-page title="错误码列表" class="editCodePage">
    <search-message :searchContent="searchContent" />
    <el-table :data="tableData" style="width: 100%" border fit highlight-current-row>
      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-table :data="scope.row.caseInfos" style="width:100%" border fit highlight-current-row>
            <el-table-column type="index" label="案例编号" width="80"></el-table-column>
            <el-table-column prop="title" label="标题"></el-table-column>
            <el-table-column prop="content" label="案例详情"></el-table-column>
          </el-table>
        </template>
      </el-table-column>
      <el-table-column type="index" label="ID" width="100"></el-table-column>
      <el-table-column prop="code" label="错误码" width="180"></el-table-column>
      <el-table-column prop="errorMsg" label="错误信息"></el-table-column>
      <el-table-column prop="errorInfo" label="错误描述"></el-table-column>
      <el-table-column prop="errorTags" label="相关标签">
        <template slot-scope="scope">
          <span
            v-for="(item,index) in scope.row.errorTags"
            :key="index"
            style="margin-right:5px;"
          >{{item.tag}}</span>
        </template>
      </el-table-column>
    </el-table>
  </oecp-page>
</template>

<script>
import { getErrorInfoAndCase } from '@/api/errorInfo'
export default {
  data() {
    return {
      searchContent: '',
      tableData: [
        {
          id: 3,
          code: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorInfo: '建议联系平台核查原因',
          errorTags: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          caseInfos: [
            {
              id: 1,
              title: 'ddd',
              content: 'dddddd'
            },
            {
              id: 2,
              title: 'ccc',
              content: 'cccccc'
            }
          ]
        },
        {
          id: 4,
          code: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorInfo: '建议联系平台核查原因',
          errorTags: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          caseInfos: [
            {
              id: 1,
              title: 'ddd',
              content: 'dddddd'
            },
            {
              id: 2,
              title: 'ccc',
              content: 'cccccc'
            }
          ]
        },
        {
          id: 5,
          code: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorInfo: '建议联系平台核查原因',
          errorTags: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          caseInfos: [
            {
              id: 1,
              title: 'ddd',
              content: 'dddddd'
            },
            {
              id: 2,
              title: 'ccc',
              content: 'cccccc'
            }
          ]
        },
        {
          id: 6,
          code: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorInfo: '建议联系平台核查原因',
          errorTags: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          caseInfos: [
            {
              id: 1,
              title: 'ddd',
              content: 'dddddd'
            },
            {
              id: 2,
              title: 'ccc',
              content: 'cccccc'
            }
          ]
        },
        {
          id: 7,
          code: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorInfo: '建议联系平台核查原因',
          errorTags: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          caseInfos: [
            {
              id: 1,
              title: 'ddd',
              content: 'dddddd'
            },
            {
              id: 2,
              title: 'ccc',
              content: 'cccccc'
            }
          ]
        }
      ]
    }
  },
  methods: {},
  mounted() {
    this.searchContent = this.$route.query.searchContent
    console.log(this.$route.query)
    console.log(this.searchContent)
    getErrorInfoAndCase().then(res => {
        if (res.result && !res.code) {
          console.log(res.data)
          this.tableData = res.data
        } else {
          this.$message.error('保存失败')
        }
      })
  }
}
</script>

<style scoped>
</style>
<style>
</style>