import request from '@/utils/request'

export function detect(data) {
  return request({
    url: '/oecpCodeDetect',
    method: 'post',
    data: data
    //data
  })
}

export function health(params) {
  return request({
    url: '/oecpCodeDetect/health',
    method: 'get',
    params
  })
}