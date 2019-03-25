import request from 'src/request';

export function addBranchInfo(branchInfoJson: Object): Object {
  return request({
    url: '/api/branch/info',
    method: 'post',
    branchInfoJson
  })
}

export function getBranchInfo(branchInfoJson: Object): Object {
  return request({
    url: '/api/branch/info',
    method: 'get',
    params: branchInfoJson
  })
}

export function updateBranchInfo(branchInfoJson: Object): Object {
  return request({
    url: '/api/branch/info',
    method: 'put',
    branchInfoJson
  })
}

export function deleteBranchInfo(branch_id: Number): Object {
  return request({
    url: '/api/branch/info',
    method: 'post',
    branch_id
  })
}
