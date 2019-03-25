import request from 'src/request';

export function addEmployeeTrainingRecord(employeeTrainingJson: Json): Object {
  return request({
    url: '/api/employee/training/record',
    method: 'post',
    employeeTrainingJson
  })
}

export function getEmployeeTrainingRecord(employeeTrainingJson: Json): Object {
  return request({
    url: '/api/employee/training/record',
    method: 'get',
    params: employeeTrainingJson
  })
}

export function updateEmployeeTrainingRecord(employeeTrainingJson: Json): Object {
  return request({
    url: '/api/employee/training/record',
    method: 'put',
    employeeTrainingJson
  })
}

export function deleteEmployeeTrainingRecord(employeeTrainingJson: Json): Object {
  return request({
    url: '/api/employee/training/record',
    method: 'delete',
    employeeTrainingJson
  })
}
