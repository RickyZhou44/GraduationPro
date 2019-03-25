import request from 'src/request';

export function addClientContact(clientAId: string, clientBId: string, relation: string): Object{
  let data = {
    clientAId,
    clientBId,
    relation
  };
  return request({
    url: 'api/client/contact',
    method: 'post',
    data
  })
}

export function updateClientContact(clientAId: string, clientBId: string, relation: string): Object{
  let data = {
    clientAId,
    clientBId,
    relation
  };
  return request({
    url: 'api/client/contact',
    method: 'put',
    data
  })
}

export function deleteClientContact(clientAId: string, clientBId: string, relation: string): Object{
  let data = {
    clientAId,
    clientBId,
    relation
  };
  return request({
    url: 'api/client/contact',
    method: 'delete',
    data
  })
}
