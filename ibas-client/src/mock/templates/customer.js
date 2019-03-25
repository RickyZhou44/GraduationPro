import Mock from 'mockjs'

export default Mock.mock({
  'data|20-30': [
    {
      'clientName': /[a-z]{5,10}/,
      'idCard': /[0-9]{18}/,
      'sex|1': ['男', '女'],
      'address': /[A-Z][a-z]{0,13}/,
      'tel': /[0-9]{11}/,
      'email': /[a-z]{5,10}@[a-z]{3}\.com/,
      'birthday': '@date("yyyy-MM-dd")',
      'clientType|1': ['已投保客户', '潜在客户', '团险客户']
    }
  ]
})
