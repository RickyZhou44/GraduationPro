import request from '../request'

export function signInByUsername (userIdentifier: string, userPassword: string): Object {
  const data = {
    userIdentifier,
    userPassword
  }
  return request({
    url: '/api/signin',
    method: 'post',
    data
  })
}

export function logout (): Object {
  return request({
    url: '/api/signout',
    method: 'post'
  })
}

export function getUserInfo (token: string): Object {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}
export function validateCode (email: string, code: number): Object {
  return request({
    url: '/api/validatecode',
    method: 'get',
    params: { email, code }
  })
}

export function getCode (email: string): Object {
  return request({
    url: '/api/getcode',
    method: 'get',
    params: { email }
  })
}

export function validateUserName (username: string): Object {
  return request({
    url: '/api/validatename',
    method: 'get',
    params: { username }
  })
}

export function fetchList (query: Object, search: Object, filter) {
  return request({
    url: '/insurance/list',
    method: 'get',
    params: { ...query, ...search, ...filter }
  })
}

export function fetchFilters () {
  return request({
    url: '/insurance/filters',
    method: 'get'
  })
}

export function queryEmployee (query: string) {
  return request({
    url: '/insurance/queryemployee',
    method: 'get',
    params: { query }
  })
}
