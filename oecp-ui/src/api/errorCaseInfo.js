import request from '@/utils/request'

export function query(params) {
  return request({
    url: '/oecpCaseInfo/query',
    method: 'get',
    params
  })
}

export function save(params) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: '/oecpCaseInfo/save',
    method: 'post',
    params
  })
}

export function get(params) {
  return request({
    url: '/oecpCaseInfo/get',
    method: 'get',
    params
  })
}

export function remove(id) {
  return request({
    url: '/oecpCaseInfo/remove',
    method: 'get',
    params: {
      id: id
    }
  })
}