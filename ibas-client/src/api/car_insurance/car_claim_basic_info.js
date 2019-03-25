import request from 'src/request';

export function getCarClaimBasicInfo(claimJson: Object): Object {
  return request({
    url: '/api/CarClaimBasic',
    method: 'get',
    params: claimJson
  })
}

export function addNewCarClaim(claimJson: Object): Object {
  return request({
    url: '/api/CarClaimBasic',
    method: 'post',
    claimJson
  })
}

export function updateNewCarClaim(claimJson: Object): Object {
  return request({
    url: '/api/CarClaimBasic',
    method: 'put',
    claimJson
  })
}

export function deleteNewCarClaim(claim_no: string): Object {
  return request({
    url: '/api/CarClaimBasic',
    method: 'delete',
    claim_no
  })
}
