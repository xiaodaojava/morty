import request from '@/utils/request'

export function getAuthInfo(accessToken, appId) {
  return request({
    url: '/aliLogin/getAuthInfo',
    method: 'get',
    params: {
      accessToken: accessToken,
      appId: appId
    }
  })
}

export function authRedirect(authCode, appId) {
  return request({
    url: '/aliLogin/authRedirect',
    method: 'get',
    params: {
      authCode: authCode,
      appId: appId
    }
  })
}