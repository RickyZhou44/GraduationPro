import request from 'src/request';

export function getEmployeeArchiveInfo(employeeJson: Json) {
  return request({
    url: '/api/employee/archive/info',
    method: 'get',
    params: employeeJson
  })
}

export function addEmployeeArchiveInfo(employeeJson: Json) {
  return request({
      url: '/api/employee/archive/info',
    method: 'post',
    employeeJson
  })
}

export function updateEmployeeArchiveInfo(employeeJson: Json) {
  return request({
    url: '/api/employee/archive/info',
    method: 'put',
    employeeJson
  })
}

export function deleteEmployeeArchiveInfo(employee_no: Number) {
  return request({
    url: '/api/employee/archive/info',
    method: 'delete',
    employee_no
  })
}
