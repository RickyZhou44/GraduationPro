import Mock from 'mockjs'

export default Mock.mock({
  'user|50-100': {
    'id': '@id',
    'name': /^([_a-zA-Z\d]|[-]){1,8}$/,
    'avatar': ''/* Mock.Random.image('200x100', '#894FC4', '#FFF', 'png', 00) */,
    'email': '@email',
    'role|1': ['admin', 'editor', 'normal_user'],
    'password': /^(?=.*[A-Z])(?=.*[A-Z])(?=.*\d)[_A-Za-z\d]{6,16}$/
  }
})
