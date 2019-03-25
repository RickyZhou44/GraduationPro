import request from 'src/request';

export function addTraceRecord(traceClaimJson: Object): Object {
  return request({
    url: '/api/ClaimTraceRecord',
    method: 'post',
    traceClaimJson
  })
}
export function updateTraceRecord(traceClaimJson: Object): Object {
  return request({
    url: '/api/ClaimTraceRecord',
    method: 'put',
    traceClaimJson
  })
}

export function getTraceRecord(traceClaimJson: Object): Object {
  return request({
    url: '/api/ClaimTraceRecord',
    method: 'get',
    params: traceClaimJson
  })
}

export function deleteTraceRecord(claim_no: string): Object {
  return request({
    url: '/api/ClaimTraceRecord',
    method: 'delete',
    claim_no
  })
}
