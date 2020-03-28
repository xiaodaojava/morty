import request from '@/utils/request'

export function detect(data) {
  return request({
    headers: {
      'Content-Type': 'application/json'
    },
    url: '/oecpCodeDetect',
    method: 'post',
    data: JSON.stringify({"codeDto":data})
  })
}

export function health(params) {
  return request({
    url: '/oecpCodeDetect/health',
    method: 'get',
    params
  })
}