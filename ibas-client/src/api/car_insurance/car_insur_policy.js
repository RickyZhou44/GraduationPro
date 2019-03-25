import request from 'src/request';

export function addCarInsurPolicy(carInsuranceJson: Object): Object {
  return request({
    url: '/api/car/insurance/policy',
    method: 'post',
    carInsuranceJson
  })
}

export function getCarInsurPolicy(carInsuranceJson: Object): Object {
  return request({
    url: '/api/car/insurance/policy',
    method: 'get',
    params: carInsuranceJson
  })
}

export function updateCarInsurPolicy(carInsuranceJson: Object): Object {
  return request({
    url: '/api/car/insurance/policy',
    method: 'put',
    carInsuranceJson
  })
}

export function deleteCarInsurPolicy(policy_no: string): Object {
  return request({
    url: '/api/car/insurance/policy',
    method: 'delete',
    policy_no
  })
}
