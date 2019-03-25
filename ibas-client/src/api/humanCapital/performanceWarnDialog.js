import request from '@/request'

export function fetchPeopleList (searchJson: Object) :Object {
  return request({
    url: '/api/performanceWarnPeople',
    method: 'get',
    params: searchJson
  })
}
