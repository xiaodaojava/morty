import request from '@/utils/request'

export function query(params) {
  return request({
    url: '/oecpRole/query',
    method: 'get',
    params: {
      // name: params.name,
      // officeId: params.officeId || null,
      pageIndex: params.pageIndex,
      pageSize: params.pageSize
    }
  })
}

export function save(params) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: '/oecpRole/save',
    method: 'post',
    params
  })
}

export function get(params) {
  return request({
    url: '/oecpRole/get',
    method: 'get',
    params
  })
}

export function remove(id) {
  return request({
    url: '/oecpRole/remove',
    method: 'get',
    params: {
      id: id
    }
  })
}