import request from '@/utils/request'

export function query(params) {
  return request({
    url: '/oecpTag/query',
    method: 'get',
    params
  })
}

export function save(data) {
  return request({
    url: '/oecpTag/save',
    method: 'post',
    data
  })
}

export function get(params) {
  return request({
    url: '/oecpTag/get',
    method: 'get',
    params
  })
}

export function remove(id) {
  return request({
    url: '/oecpTag/remove',
    method: 'get',
    params: {
      id: id
    }
  })
}