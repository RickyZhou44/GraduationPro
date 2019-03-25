import request from '@/request'

export function getCustomer (searchJson: Object) :Object {
  return request({
    url: '/api/customer',
    method: 'get',
    params: searchJson
  })
}

export function addCustomer (searchJson: Object) :Object {
  return request({
    url: '/api/customer',
    method: 'post',
    data: searchJson
  })
}
