import Cookies from 'js-cookie'

const TokenKey = 'morty_token'

const authCodeKey = 'morty_authCode'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function getAuthCode() {
  return Cookies.get(authCodeKey);
}

export function setAuthCode(authCode) {
  return Cookies.set(authCodeKey, authCode);
}

export function removeAuthCode() {
  return Cookies.remove(authCodeKey)
}