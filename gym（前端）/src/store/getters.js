const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  cardNo: state => state.user.cardNo,
  userId: state => state.user.userId,
  role: state => state.user.role,
  addRouters: state => state.permission.addRouters,
  routers: state => state.permission.routers
}
export default getters
