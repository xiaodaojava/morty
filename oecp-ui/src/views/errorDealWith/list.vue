<template>
  <oecp-page title="错误码列表" class="editCodePage">
    <search-message :searchContent="searchContent" />
    <el-table :data="tableData" style="width: 100%" border fit highlight-current-row>
      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-table :data="scope.row.errorCase" style="width:100%" border fit highlight-current-row>
            <el-table-column prop="id" label="案例编号"></el-table-column>
            <el-table-column prop="title" label="标题"></el-table-column>
            <el-table-column prop="content" label="案例详情"></el-table-column>
          </el-table>
        </template>
      </el-table-column>
      <el-table-column prop="id" label="ID" width="100"></el-table-column>
      <el-table-column prop="errorCode" label="错误码" width="180"></el-table-column>
      <el-table-column prop="errorMsg" label="错误信息"></el-table-column>
      <el-table-column prop="errorDesc" label="错误描述"></el-table-column>
      <el-table-column prop="errorTag" label="相关标签">
        <template slot-scope="scope">
          <span
            v-for="(item,index) in scope.row.errorTag"
            :key="index"
            style="margin-right:5px;"
          >{{item.tag}}</span>
        </template>
      </el-table-column>
    </el-table>
  </oecp-page>
</template>

<script>
export default {
  data() {
    return {
      searchContent: '',
      tableData: [
        {
          id: 3,
          errorCode: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorDesc: '建议联系平台核查原因',
          errorTag: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          errorCase: [
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
          errorCode: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorDesc: '建议联系平台核查原因',
          errorTag: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          errorCase: [
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
          errorCode: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorDesc: '建议联系平台核查原因',
          errorTag: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          errorCase: [
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
          errorCode: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorDesc: '建议联系平台核查原因',
          errorTag: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          errorCase: [
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
          errorCode: 'DB:0504',
          errorMsg: '已超过LICENSE限定数量',
          errorDesc: '建议联系平台核查原因',
          errorTag: [
            {
              id: 3,
              tag: 'MQ'
            },
            {
              id: 4,
              tag: 'yao'
            }
          ],
          errorCase: [
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
  }
}
</script>

<style scoped>
</style>
<style>
</style>