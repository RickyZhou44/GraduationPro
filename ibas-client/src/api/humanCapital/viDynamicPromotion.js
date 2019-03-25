import request from '@/request'

export function fetchList (searchJson: Object) :Object {
  return request({
    url: '/api/viDynamicPromotion',
    method: 'get',
    params: searchJson
  })
}
