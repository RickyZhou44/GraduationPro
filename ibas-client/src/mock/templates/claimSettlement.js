import Mock from 'mockjs'

export default Mock.mock({
  'data|50-60': [
    {
      'settlementName': /[0-9]{11,12}/,
      'reportTime': '@date("yyyy-MM-dd")',
      'reportNum': /[0-9]{11,12}/,
      'surveyLocation': /([A-Z][a-z]{1,3}\s)+/,
      'surveyor': /([A-Z][a-z]{1,5}){2,3}/,
      'process': '',
      'isFinished|1': ['未结案', '已结案'],
      'taskType|1': ['查勘定损', '查勘', '单定损']
    }
  ]
})
