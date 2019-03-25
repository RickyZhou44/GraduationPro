import Mock from 'mockjs'

export default Mock.mock({
  'data|20-30': [
    {
      'relateNo': /([0-9]{5,10})|\s/,
      'policyNo': /[0-9]{5,10}/,
      'insurer|1': ['中国人寿', '百年人寿', '地表最强', '木叶第一'],
      'status|1': ['预收件', '承保件 ', '失效件'],
      'holder': '@cname',
      'agent|1': ['木叶分部', '云隐分部', '北京分部', '上海分部', '武汉分部'],
      'employee': '@cname',
      'checkInDate': '@date("yyyy/MM/dd")',
      'validDate': '@date("yyyy/MM/dd")',
      'period|0-30': 30,
      'policyCode': /^[A-Z]{5}[0-9]{2}$/,
      'insurance|1': ['意外险', '医疗险', '生命险', '养老险', '失业险'],
      'insured|1': '@cname',
      'account|50-1000.2-2': 100000000.00,
      'unit|1': ['元', '万元', '亿'],
      'premium|50-1000.2-2': 100000000.00,
      'agentType': '个人件'
    }
  ]
})
