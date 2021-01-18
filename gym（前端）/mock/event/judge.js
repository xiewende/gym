import Mock from 'mockjs'

const list = Mock.mock({
  'list|8': [{
    judgeId: '@id',
    judgeName: '@cname',
    judgePhoto: `@image('100x135', '@color', '#FFFFFF', '@judgeName')`,
    'judgeSpecialities|1': ['篮球', '足球', '羽毛球', '乒乒球', '田径'],
    judgeProfile: '@cparagraph(10)'
  }]
})
export default [
  {
    url: '/event/judge/list',
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
