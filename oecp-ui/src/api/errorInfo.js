import request from '@/utils/request'

export function query(params) {
  return request({
    url: '/oecpErrorInfo/query',
    method: 'get',
    params
  })
}

export function save(params) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: '/oecpErrorInfo/save',
    method: 'post',
    params
  })
}

export function saveOecpErrorInfo(data) {
  return request({
    url: '/saveOecpErrorInfo',
    method: 'post',
    data
  })
}

export function get(params) {
  return request({
    url: '/oecpErrorInfo/get',
    method: 'get',
    params
  })
}

export function remove(id) {
  return request({
    url: '/oecpErrorInfo/remove',
    method: 'get',
    params: {
      id: id
    }
  })
}