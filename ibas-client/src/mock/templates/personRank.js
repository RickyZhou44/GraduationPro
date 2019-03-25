import Mock from 'mockjs'

export default Mock.mock({
  'data|50-60': [
    {
      'staffName': /([A-Z][a-z]{1,5}\s){2,3}/,
      'staffSex|1': ['男', '女'],
      'dept': /([A-Z][a-z]{1,3}\s)+/,
      'branch': /([A-Z][a-z]{1,3}\s)+/,
      'rank': /([A-Z][a-z]{1,3}\s)/,
      'joinDate': '@date("yyyy-MM-dd")',
      'validDate': '@date("yyyy-MM-dd")',
      'birthday': '@date("yyyy-MM-dd")',
      'staffNo': /[0-9]{11,12}/,
      'tel': /[0-9]{11,13}/,
      'status|1': ['在职', '离职', '回收站']
    }
  ]
})
