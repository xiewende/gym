import request from '@/utils/request_yusen'

// 获取所有用户
export function getAllUser(params) {
  return request({
    url: '/user/',
    method: 'get',
    params
  })
}
// 添加用户
export function addUser(params) {
  return request({
    url: '/user/',
    method: 'post',
    params
  })
}
// 查询用户
// 参数card_no
export function queryUser(params) {
  return request({
    url: '/user/searchByCardNo',
    method: 'get',
    params
  })
}
// 删除用户
export function deleteUser(id) {
  return request({
    url: '/user/' + id,
    method: 'delete'
  })
}
// 修改用户信息
export function updateUser(params) {
  return request({
    url: '/user/' + params['id'],
    method: 'put',
    params
  })
}

// 用户登录
export function login(params) {
  return request({
    url: '/user/login',
    method: 'post',
    params
  })
}
