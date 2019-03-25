import request from 'src/request';

export function addComArchive(com_archive_no: Number, com_archive_name: string, note: string): Object {
  let data = {
    com_archive_no,
    com_archive_name,
    note,
  };
  return request({
    url: '/api/insurance/company/archive',
    method: 'post',
    data
  })
}

export function addComArchive(com_archive_no: Number, com_archive_name: string, note: string): Object {
  let data = {
    com_archive_no,
    com_archive_name,
    note,
  };
  return request({
    url: '/api/insurance/company/archive',
    method: 'get',
    params: data
  })
}

export function updateComArchive(com_archive_no: Number, com_archive_name: string, note: string): Object {
  let data = {
    com_archive_no,
    com_archive_name,
    note,
  };
  return request({
    url: '/api/insurance/company/archive',
    method: 'put',
    data
  })
}

export function updateComArchive(com_archive_no: Number): Object {
  return request({
    url: '/api/insurance/company/archive',
    method: 'put',
    com_archive_no
  })
}
