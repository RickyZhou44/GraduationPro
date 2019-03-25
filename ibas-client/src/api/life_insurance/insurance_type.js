import request from 'src/request';

export function addInsuranceType(insuranceTypeJson: Object): Object {
  return request({
    url: '/api/insurance/type',
    methods: 'post',
    insuranceTypeJson
  })
}

export function getInsuranceType(insuranceTypeJson: Object): Object {
  return request({
    url: '/api/insurance/type',
    methods: 'get',
    params: insuranceTypeJson
  })
}

export function updateInsuranceType(insuranceTypeJson: Object): Object {
  return request({
    url: '/api/insurance/type',
    methods: 'put',
    insuranceTypeJson
  })
}

export function deleteInsuranceType(insur_id: Number): Object {
  return request({
    url: '/api/insurance/type',
    methods: 'delete',
    insur_id
  })
}
