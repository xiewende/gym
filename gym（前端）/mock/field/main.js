import Mock from 'mockjs'

const options = Mock.mock({
  'options|5': [{
    label: '选项@increment',
    value: '@integer(1, 10)'
  }]
})

const list = Mock.mock({
  'list|10': [{
    fieldId: '@id',
    'fieldName|1': ['篮球场地', '足球场地', '羽毛球场地'],
    fieldLocale: '东区@integer(1, 5)',
    fieldTime: '@integer(7, 18):00 - 21:00',
    fieldManagername: '@cname',
    filedManegertel: '@integer(1, 9)644585565',
    fieldCharge: '@integer(5, 20)/小时',
    fieldSpecialUsage: '',
    fieldSpecialUsageExplain: ''
  }]
})
export default [
  {
    url: '/field/main/options',
    type: 'get',
    response: config => {
      return {
        code: 20000,
        data: {
          options: options.options
        }
      }
    }
  },
  {
    url: '/field/main/list',
    type: 'get',
    response: config => {
      return {
        code: 20000,
        data: {
          list: list.list
        }
      }
    }
  }
]
