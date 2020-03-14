import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/user/login.do',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}

export function getAuthInfo(accessToken) {
  return request({
    url: '/api/getAuthInfo',
    method: 'get',
    params: { access_token: accessToken }
  })
}