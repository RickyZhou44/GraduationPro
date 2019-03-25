import request from 'src/request';

export function addCarBasicInfo(carJson: Object): Object {
  return request({
    url: '/api/car/basic/info',
    method: 'post',
    carJson
  })
}

export function getCarBasicInfo(carJson: Object): Object {
  return request({
    url: '/api/car/basic/info',
    method: 'get',
    params: carJson
  })
}

export function updateCarBasicInfo(carJson: Object): Object {
  return request({
    url: '/api/car/basic/info',
    method: 'put',
    carJson
  })
}

export function deleteCarBasicInfo(license_plate_no: string): Object {
  return request({
    url: '/api/car/basic/info',
    method: 'delete',
    license_plate_no
  })
}
