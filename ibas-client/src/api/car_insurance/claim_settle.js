import request from 'src/request';

export function addClaimSettle(claimSettleJson: Object): Object {
  return request({
    url: '/api/ClaimSettle',
    method: 'post',
    claimSettleJson
  })
}

export function getClaimSettle(claimSettleJson: Object): Object {
  return request({
    url: '/api/ClaimSettle',
    method: 'get',
    params: claimSettleJson
  })
}

export function updateClaimSettle(claimSettleJson: Object): Object {
  return request({
    url: '/api/ClaimSettle',
    method: 'put',
    claimSettleJson
  })
}

export function deleteClaimSettle(claim_no: string): Object {
  return request({
    url: '/api/ClaimSettle',
    method: 'delete',
    claim_no
  })
}
