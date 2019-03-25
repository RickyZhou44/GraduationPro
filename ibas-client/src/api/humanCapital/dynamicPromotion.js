import request from '@/request'

export function fetchList (searchJson: Object) :Object {
  return request({
    url: '/api/dynamicPromotion',
    method: 'get',
    params: searchJson
  })
}
