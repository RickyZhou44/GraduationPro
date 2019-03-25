import request from 'src/request';

export function AddClient(clientJson: Object): Object {
  return request({
    url: 'api/client',
    method: 'post',
    clientJson
  })
}

export function getClient(clientJson: Object): Object{
  return request({
    url: 'api/client',
    method: 'get',
    params: clientJson
  })
}

export function updateClient(clientJson: Object): Object{
  return request({
    url: 'api/client',
    method: 'put',
    clientJson
  })
}

export function deleteClient(clientId: string): Object{
  return request({
    url: 'api/client',
    method: 'delete',
    clientId
  })
}
