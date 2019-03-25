import request from 'src/request';

export function addCarInfurancePolicyMid(car_insur_policy_id: Number, policy_id: string, car_insur_id: Number): Object{
  let data = {
    car_insur_policy_id,
    policy_id,
    car_insur_id,
  };
  return request({
    url: '/api/car/insurance/policy/mid',
    method: 'post',
    data
  })
}

export function getCarInfurancePolicyMid(car_insur_policy_id: Number, policy_id: string, car_insur_id: Number): Object{
  let data = {
    car_insur_policy_id,
    policy_id,
    car_insur_id,
  };
  return request({
    url: '/api/car/insurance/policy/mid',
    method: 'get',
    params: data
  })
}

export function updateCarInfurancePolicyMid(car_insur_policy_id: Number, policy_id: string, car_insur_id: Number): Object{
  let data = {
    car_insur_policy_id,
    policy_id,
    car_insur_id,
  };
  return request({
    url: '/api/car/insurance/policy/mid',
    method: 'put',
    data
  })
}

export function deleteCarInfurancePolicyMid(car_insur_policy_id: Number): Object{
  let data = {
    car_insur_policy_id,
    policy_id,
    car_insur_id,
  };
  return request({
    url: '/api/car/insurance/policy/mid',
    method: 'delete',
    car_insur_policy_id
  })
}
