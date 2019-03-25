import request from 'src/request';

export function addCarInsuranceType(carInsuranceJson: Object): Object {
  return request({
    url: '/api/car/insurance/type',
    method: 'post',
    carInsuranceJson
  })
}

export function getCarInsuranceType(carInsuranceJson: Object): Object {
  return request({
    url: '/api/car/insurance/type',
    method: 'get',
    params: carInsuranceJson
  })
}

export function updateCarInsuranceType(carInsuranceJson: Object): Object {
  return request({
    url: '/api/car/insurance/type',
    method: 'put',
    carInsuranceJson
  })
}

export function deleteCarInsuranceType(car_insurance_type: Number): Object {
  return request({
    url: '/api/car/insurance/type',
    method: 'delete',
    car_insurance_type
  })
}
