import request from 'src/request';

export function addCarInsuranceAttachmentInfo(carInsuranceAttachmentInfo: Object): Object {
  return request({
    url: '/api/car/insurance/attachment/info',
    method: 'post',
    carInsuranceAttachmentInfo
  })
}

export function getCarInsuranceAttachmentInfo(carInsuranceAttachmentInfo: Object): Object {
  return request({
    url: '/api/car/insurance/attachment/info',
    method: 'get',
    params: carInsuranceAttachmentInfo
  })
}

export function updateCarInsuranceAttachmentInfo(carInsuranceAttachmentInfo: Object): Object {
  return request({
    url: '/api/car/insurance/attachment/info',
    method: 'put',
    carInsuranceAttachmentInfo
  })
}

export function deleteCarInsuranceAttachmentInfo(attach_id: Number): Object {
  return request({
    url: '/api/car/insurance/attachment/info',
    method: 'delete',
    attach_id
  })
}
