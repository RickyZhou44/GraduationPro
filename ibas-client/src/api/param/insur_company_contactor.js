import request from 'src/request';

export function addComContactor(com_ctact_id: Number, company_id: Number, employee_id: Number): Object {
  let data = {
    com_ctact_id,
    company_id,
    employee_id,
  };
  return request({
    url: '/api/insurance/company/contactor',
    method: 'post',
    data
  })
}

export function getComContactor(com_ctact_id: Number, company_id: Number, employee_id: Number): Object {
  let data = {
    com_ctact_id,
    company_id,
    employee_id,
  };
  return request({
    url: '/api/insurance/company/contactor',
    method: 'get',
    params: data
  })
}

export function updateComContactor(com_ctact_id: Number, company_id: Number, employee_id: Number): Object {
  let data = {
    com_ctact_id,
    company_id,
    employee_id,
  };
  return request({
    url: '/api/insurance/company/contactor',
    method: 'put',
    data
  })
}

export function deleteComContactor(com_ctact_id: Number): Object {
  return request({
    url: '/api/insurance/company/contactor',
    method: 'delete',
    com_ctact_id
  })
}
