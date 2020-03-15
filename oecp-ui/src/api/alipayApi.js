import request from '@/utils/request'

export function getAuthCode(params) {
  return request({
    url: '/oecp/health.do',
    method: 'post',
    params
  })
}