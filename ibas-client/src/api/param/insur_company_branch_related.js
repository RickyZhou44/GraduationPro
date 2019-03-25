import request from 'src/request';

export function addComBranchRelated(com_bran_id: Number, insur_company_id: Number, branch_id: Number): Object {
  let data = {
    com_bran_id,
    insur_company_id,
    branch_id,
  };
  return request({
    url: '/api/insurance/company/branch/related',
    method: 'post',
    data
  })
}

export function getComBranchRelated(com_bran_id: Number, insur_company_id: Number, branch_id: Number): Object {
  let data = {
    com_bran_id,
    insur_company_id,
    branch_id,
  };
  return request({
    url: '/api/insurance/company/branch/related',
    method: 'get',
    params: data
  })
}

export function updateComBranchRelated(com_bran_id: Number, insur_company_id: Number, branch_id: Number): Object {
  let data = {
    com_bran_id,
    insur_company_id,
    branch_id,
  };
  return request({
    url: '/api/insurance/company/branch/related',
    method: 'put',
    data
  })
}

export function deleteComBranchRelated(com_bran_id: Number): Object {
  return request({
    url: '/api/insurance/company/branch/related',
    method: 'delete',
    com_bran_id
  })
}
