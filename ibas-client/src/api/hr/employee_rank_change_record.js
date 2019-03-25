import request from 'src/request';

export function getEmployeeRankChangeRecord(employeeJson: Json): Object{
  return request({
    url: '/api/employee/rank/change/record',
    method: 'get',
    params: employeeJson
  })
}

export function addEmployeeRankChangeRecord(employeeJson: Json): Object{
  return request({
    url: '/api/employee/rank/change/record',
    method: 'post',
    employeeJson
  })
}

export function updateEmployeeRankChangeRecord(employeeJson: Json): Object{
  return request({
    url: '/api/employee/rank/change/record',
    method: 'put',
    employeeJson
  })
}

export function deleteEmployeeRankChangeRecord(rank_change_no: Number): Object{
  return request({
    url: '/api/employee/rank/change/record',
    method: 'delete',
    rank_change_no
  })
}
