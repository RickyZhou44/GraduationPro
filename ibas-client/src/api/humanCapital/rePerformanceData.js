import request from '@/request'

export function reCalculate (searchJson: Object) :Object {
  return request({
    url: '/api/rePerformanceData',
    method: 'put',
    data: searchJson
  })
}
