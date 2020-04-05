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
      'Content-Type': 'application/json'
    },
    url: '/oecpErrorInfo/save',
    method: 'post',
    data:params
  })
}

export function saveOecpErrorInfo(data) {
  return request({
    url: '/saveOecpErrorInfo',
    method: 'post',
    data
  })
}

export function getErrorInfoAndCase() {
  return request({
    url: '/getErrorInfoAndCase',
    method: 'get'
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

export function findByErrorCode(code) {
  if(!code){
    code ='';
  }
  return request({
    url: '/es/findByErrorCode',
    method: 'get',
    params: {
      errorCode: code
    }
  })
}

export function searchErrorCode(info) {
  if(!info){
    info ='';
  }
  return request({
    url: '/es/searchErrorCode',
    method: 'get',
    params: {
      info: info
    }
  })
}