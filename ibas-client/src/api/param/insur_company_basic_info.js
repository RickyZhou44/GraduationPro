import request from 'src/request';

export function addInsuranceComBasicInfo(insuranceComBasicJson: Object):Object {
  return request({
    url: '/api/insurance/company/basic/info',
    method: 'post',
    insuranceComBasicJson
  })
}

export function getInsuranceComBasicInfo(insuranceComBasicJson: Object):Object {
  return request({
    url: '/api/insurance/company/basic/info',
    method: 'get',
    params: insuranceComBasicJson
  })
}

export function updateInsuranceComBasicInfo(insuranceComBasicJson: Object):Object {
  return request({
    url: '/api/insurance/company/basic/info',
    method: 'put',
    insuranceComBasicJson
  })
}

export function deleteInsuranceComBasicInfo(company_id: Number):Object {
  return request({
    url: '/api/insurance/company/basic/info',
    method: 'delete',
    company_id
  })
}
