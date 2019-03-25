import request from 'src/request';

export function addUserAccount(userJson: Object): Object {
  return request({
    url: '/api/usr/account',
    method: 'post',
    userJson
  })
}

export function getUserAccount(userJson: Object): Object {
  return request({
    url: '/api/usr/account',
    method: 'get',
    params: userJson
  })
}

export function updateUserAccount(userJson: Object): Object {
  return request({
    url: '/api/usr/account',
    method: 'put',
    userJson
  })
}

export function deleteUserAccount(user_no: Number): Object {
  return request({
    url: '/api/usr/account',
    method: 'delete',
    user_no
  })
}
