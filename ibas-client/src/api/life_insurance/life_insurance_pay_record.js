import request from 'src/request';

export function addLifeInsurancePayRecord(policy_no: string, check_id_date, valid_date_sice, issuce_date, pay_date): Object {
  let data = {
    policy_no,
    check_id_date,
    valid_date_sice,
    issuce_date,
    pay_date
  }
  return request({
    url: '/api/life/insurance/pay/record',
    method: 'post',
    data
  })
}

export function getLifeInsurancePayRecord(policy_no: string, check_id_date, valid_date_sice, issuce_date, pay_date): Object {
  let data = {
    policy_no,
    check_id_date,
    valid_date_sice,
    issuce_date,
    pay_date
  }
  return request({
    url: '/api/life/insurance/pay/record',
    method: 'get',
    params: data
  })
}

export function updateLifeInsurancePayRecord(policy_no: string, check_id_date, valid_date_sice, issuce_date, pay_date): Object {
  let data = {
    policy_no,
    check_id_date,
    valid_date_sice,
    issuce_date,
    pay_date
  }
  return request({
    url: '/api/life/insurance/pay/record',
    method: 'put',
    data
  })
}

export function addLifeInsurancePayRecord(policy_no: string, check_id_date): Object {
  let data = {
    policy_no,
    check_id_date
  };
  return request({
    url: '/api/life/insurance/pay/record',
    method: 'delete',
    data
  })
}
