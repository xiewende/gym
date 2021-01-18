import { login } from '@/api/user/user'
import { resetRouter } from '@/router'

const getDefaultState = () => {
  return {
    name: '',
    avatar: '',
    userId: '',
    cardNo: '',
    role: ''
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_USERID: (state, userId) => {
    state.userId = userId
  },
  SET_CARDNO: (state, cardNo) => {
    state.cardNo = cardNo
  },
  SET_ROLE: (state, role) => {
    state.role = role
  }
}

const actions = {
  // user login
  login({ commit }, userInfo) {
    const { username, password } = userInfo
    const loginParams = { cardNo: username, password: password }
    return new Promise((resolve, reject) => {
      login(loginParams).then(response => {
        if (response.status === 200) {
          commit('SET_USERID', response.data.id)
          commit('SET_NAME', response.data.name)
          commit('SET_CARDNO', response.data.cardNo)
          commit('SET_ROLE', response.data.role + '')
          sessionStorage.setItem('isLogin', 'true')
          resolve()
        } else {
          reject(response.msg)
        }
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit, state }) {
    sessionStorage.removeItem('isLogin')
    return new Promise((resolve, reject) => {
      resetRouter()
      commit('RESET_STATE')
      commit('SET_USERID', '')
      commit('SET_NAME', '')
      commit('SET_CARDNO', '')
      commit('SET_ROLE', '')
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

