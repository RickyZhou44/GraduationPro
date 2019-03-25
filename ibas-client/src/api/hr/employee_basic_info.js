import request from 'src/request';

export function getEmployeeBasicInfo(employeeJson: Object): Object {
  return request({
    url: '/api/employInfo',
    method:'get',
    params: employeeJson
  })
}

export function updateEmployeeBasicInfo(employeeJson: Object): Object{
  return request({
    url: '/api/employInfo',
    method:'put',
    employeeJson
  })
}

export function addEmployeeBasicInfo(employeeJson: Object): Object{
  return request({
    url: '/api/employInfo',
    method:'post',
    employeeJson
  })
}

export function deleteEmployeeBasicInfo(employee_no: string): Object{
  return request({
    url: '/api/employInfo',
    method:'delete',
    employee_no
  })
}
