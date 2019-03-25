import request from '@/request'

export function fetchPerformanceWarn (searchJson: Object) :Object {
  return request({
    url: '/api/performanceWarn',
    method: 'get',
    params: searchJson
  })
}
