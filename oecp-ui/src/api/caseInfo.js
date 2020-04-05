import request from '@/utils/request'

export function get(params) {
  return request({
    url: '/oecpCaseInfo/get',
    method: 'get',
    params
  })
}
