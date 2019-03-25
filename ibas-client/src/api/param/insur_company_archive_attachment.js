import request from 'src/request';

export function addComArchiveAttachment(attachment_no: Number, com_archive_no: Number, attachment: string,
                                        attac_valid_strattime, attac_valid_endtime): Object {
  let data = {
    attachment_no,
    com_archive_no,
    attachment,
    attac_valid_strattime,
    attac_valid_endtime,
  };
  return request({
    url: '/api/insurance/company/archive/attachment',
    method: 'post',
    data
  })
}

export function getComArchiveAttachment(attachment_no: Number, com_archive_no: Number, attachment: string,
                                        attac_valid_strattime, attac_valid_endtime): Object {
  let data = {
    attachment_no,
    com_archive_no,
    attachment,
    attac_valid_strattime,
    attac_valid_endtime,
  };
  return request({
    url: '/api/insurance/company/archive/attachment',
    method: 'get',
    params : data
  })
}

export function updateComArchiveAttachment(attachment_no: Number, com_archive_no: Number, attachment: string,
                                        attac_valid_strattime, attac_valid_endtime): Object {
  let data = {
    attachment_no,
    com_archive_no,
    attachment,
    attac_valid_strattime,
    attac_valid_endtime,
  };
  return request({
    url: '/api/insurance/company/archive/attachment',
    method: 'put',
    data
  })
}

export function deleteComArchiveAttachment(attachment_no: Number): Object {
  return request({
    url: '/api/insurance/company/archive/attachment',
    method: 'delete',
    attachment_no
  })
}
