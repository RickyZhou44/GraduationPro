import request from 'src/request';

export function addClientVehicle(id: Number, certf_if: string, license_plate_no: string): Object {
  let data = {
    id,
    certf_if,
    license_plate_no,
  }
  return request({
    url: '/api/client/vehicle',
    method: 'post',
    data
  })
}

export function getClientVehicle(id: Number, certf_if: string, license_plate_no: string): Object {
  let data = {
    id,
    certf_if,
    license_plate_no,
  }
  return request({
    url: '/api/client/vehicle',
    method: 'get',
    params: data
  })
}

export function updateClientVehicle(id: Number, certf_if: string, license_plate_no: string): Object {
  let data = {
    id,
    certf_if,
    license_plate_no,
  }
  return request({
    url: '/api/client/vehicle',
    method: 'put',
    data
  })
}

export function deleteClientVehicle(id: Number): Object {
  return request({
    url: '/api/client/vehicle',
    method: 'delete',
    id
  })
}
