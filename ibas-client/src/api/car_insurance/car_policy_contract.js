import request from 'src/request';

export function addCarPolicyContract(contract_no: Number, employee_no: Number, policy_no: string): Object{
  let data = {
    contract_no,
    employee_no,
    policy_no
  };
  return request({
    url: '/api/car/policy/contract',
    method: 'post',
    data
  })
}

export function getCarPolicyContract(contract_no: Number, employee_no: Number, policy_no: string): Object{
  let data = {
    contract_no,
    employee_no,
    policy_no
  };
  return request({
    url: '/api/car/policy/contract',
    method: 'get',
    params: data
  })
}

export function updateCarPolicyContract(contract_no: Number, employee_no: Number, policy_no: string): Object{
  let data = {
    contract_no,
    employee_no,
    policy_no
  };
  return request({
    url: '/api/car/policy/contract',
    method: 'put',
    data
  })
}

export function deleteCarPolicyContract(contract_no: Number): Object{
  return request({
    url: '/api/car/policy/contract',
    method: 'delete',
    contract_no
  })
}
