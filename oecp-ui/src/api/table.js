import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/tableMock/list',
    method: 'get',
    params
  })
}