import request from 'src/request';

export function addEmployeeEduExperience(employeeEduJson: Object): Object {
  return request({
    url: '/api/employee/education/experience',
    method: 'post',
    employeeEduJson
  })
}

export function getEmployeeEduExperience(employeeEduJson: Object): Object {
  return request({
    url: '/api/employee/education/experience',
    method: 'get',
    params:employeeEduJson
  })
}

export function updateEmployeeEduExperience(employeeEduJson: Object): Object {
  return request({
    url: '/api/employee/education/experience',
    method: 'put',
    employeeEduJson
  })
}

export function deleteEmployeeEduExperience(employee_no: Number): Object {
  return request({
    url: '/api/employee/education/experience',
    method: 'delete',
    employee_no
  })
}
