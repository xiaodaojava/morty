import request from '@/utils/request'

export function query(params) {
  return request({
    url: '/oecpOrg/query',
    method: 'get',
    params
  })
}

export function save(params) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: '/oecpOrg/save',
    method: 'post',
    params
  })
}

export function get(params) {
  return request({
    url: '/oecpOrg/get',
    method: 'get',
    params
  })
}

export function remove(id) {
  return request({
    url: '/oecpOrg/remove',
    method: 'get',
    params: {
      id: id
    }
  })
}