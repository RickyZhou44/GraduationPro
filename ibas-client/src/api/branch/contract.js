import request from 'src/request';

export function addContract(contractJson: Object): Object{
  return request({
    url: '/api/contract',
    method: 'post',
    contractJson
  })
}

export function getContract(contractJson: Object): Object{
  return request({
    url: '/api/contract',
    method: 'get',
    params: contractJson
  })
}

export function updateContract(contractJson: Object): Object{
  return request({
    url: '/api/contract',
    method: 'put',
    contractJson
  })
}

export function deleteContract(id: Number): Object{
  return request({
    url: '/api/contract',
    method: 'post',
    id
  })
}
