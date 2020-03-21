import request from '@/utils/request'

export function login(data) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: '/account/login',
    method: 'post',
    params: data
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

// 第三方登录第二步 获取用户信息
export function getAuthInfo(accessToken, appId) {
  return request({
    url: '/api/getAuthInfo',
    method: 'get',
    params: {
      accessToken: accessToken,
      appId: appId
    }
  })
}

// 修改用户密码
export function updateUserInfo(data) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: '/updateUserInfo',
    method: 'post',
    params: data
  })
}