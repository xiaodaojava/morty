import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/oecp/table/list',
    method: 'get',
    params
  })
}