import request from 'src/request';

export function addEmployeeWorkHistory(employeeWorkJson: Json): Object {
  return request({
    url: '/api/employee/work/history',
    method: 'post',
    employeeWorkJson
  })
}

export function getEmployeeWorkHistory(employeeWorkJson: Json): Object {
  return request({
    url: '/api/employee/work/history',
    method: 'get',
    params: employeeWorkJson
  })
}

export function updateEmployeeWorkHistory(employeeWorkJson: Json): Object {
  return request({
    url: '/api/employee/work/history',
    method: 'put',
    employeeWorkJson
  })
}

export function deleteEmployeeWorkHistory(employee_no: Number): Object {
  return request({
    url: '/api/employee/work/history',
    method: 'delete',
    employee_no
  })
}
