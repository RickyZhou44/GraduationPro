import request from 'src/request';

export function getEmployeeUnitRank(employeeJson: Object): Object {
  return request({
    url: '/api/employee/unit/rank',
    method: 'get',
    params: employeeJson
  })
}

export function addEmployeeUnitRank(employeeJson: Object): Object {
  return request({
    url: '/api/employee/unit/rank',
    method: 'post',
    employeeJson
  })
}

export function updateEmployeeUnitRank(employeeJson: Object): Object {
  return request({
    url: '/api/employee/unit/rank',
    method: 'put',
    employeeJson
  })
}

export function deleteEmployeeUnitRank(employee_no: string): Object {
  return request({
    url: '/api/employee/unit/rank',
    method: 'delete',
    employee_no
  })
}
