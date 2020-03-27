import request from '@/utils/request'

export function detect(data) {
  return request({
    url: '/oecpCodeDetect',
    method: 'post',
    data: data
  })
}