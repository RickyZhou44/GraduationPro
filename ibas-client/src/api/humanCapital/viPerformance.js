import request from '@/request'

export function fetchViPerformance (searchJson: Object) :Object {
  return request({
    url: '/api/viPerformanceWarn',
    method: 'get',
    params: searchJson
  })
}
