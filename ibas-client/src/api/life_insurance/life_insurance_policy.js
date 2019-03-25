import request from 'src/request';

export function addLifeInsurancePolicy(lifeInsurancePolicyJson: Object): Object {
  return request({
    url: '/api/life/insurace/policy',
    method: 'post',
    lifeInsurancePolicyJson
  })
}

export function getLifeInsurancePolicy(lifeInsurancePolicyJson: Object): Object {
  return request({
    url: '/api/life/insurace/policy',
    method: 'get',
    params: lifeInsurancePolicyJson
  })
}

export function putLifeInsurancePolicy(lifeInsurancePolicyJson: Object): Object {
  return request({
    url: '/api/life/insurace/policy',
    method: 'put',
    lifeInsurancePolicyJson
  })
}

export function deleteLifeInsurancePolicy(policy_no: string): Object {
  return request({
    url: '/api/life/insurace/policy',
    method: 'delete',
    policy_no
  })
}
