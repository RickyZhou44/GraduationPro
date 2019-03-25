import request from 'src/request';

export function addLifePolicyContract(contract_no: Number, employee_no: Number, policy_no: string): Object{
  let data = {
    contract_no,
    employee_no,
    policy_no
  };
  return request({
    url: '/api/life/policy/contract',
    method: 'post',
    data
  })
}

export function getLifePolicyContract(contract_no: Number, employee_no: Number, policy_no: string): Object{
  let data = {
    contract_no,
    employee_no,
    policy_no
  };
  return request({
    url: '/api/life/policy/contract',
    method: 'get',
    params: data
  })
}

export function updateLifePolicyContract(contract_no: Number, employee_no: Number, policy_no: string): Object{
  let data = {
    contract_no,
    employee_no,
    policy_no
  };
  return request({
    url: '/api/life/policy/contract',
    method: 'put',
    data
  })
}

export function deleteLifePolicyContract(contract_no: Number): Object{
  return request({
    url: '/api/life/policy/contract',
    method: 'delete',
    contract_no
  })
}
