import request from '@/utils/request'

export function searchCode(params) {
  return request({
    url: '/errorCode/search',
    method: 'post',
    params
  })
}