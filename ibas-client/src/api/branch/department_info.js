import request from 'src/request';

export function addDeptInfo(dept_id: Number, cname: string, sname: string, branch_id: Number): Object {
  let data = {
    dept_id,
    cname,
    sname,
    branch_id
  };
  return request({
    url: '/api/department_info',
    method: 'post',
    data
  })
}

export function getDeptInfo(dept_id: Number, cname: string, sname: string, branch_id: Number): Object {
  let data = {
    dept_id,
    cname,
    sname,
    branch_id
  };
  return request({
    url: '/api/department_info',
    method: 'get',
    params: data
  })
}

export function updateDeptInfo(dept_id: Number, cname: string, sname: string, branch_id: Number): Object {
  let data = {
    dept_id,
    cname,
    sname,
    branch_id
  };
  return request({
    url: '/api/department_info',
    method: 'put',
    data
  })
}

export function deleteDeptInfo(dept_id: Number): Object {
  return request({
    url: '/api/department_info',
    method: 'post',
    dept_id
  })
}
