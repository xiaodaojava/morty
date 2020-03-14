import request from '@/utils/request'

export function health(params) {
  return request({
    url: '/oecp/health.do',
    method: 'post',
    params
  })
}