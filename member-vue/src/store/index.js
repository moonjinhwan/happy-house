import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default new Vuex.Store({
  state: {
    accessToken: null,
    userId: "",
    userName: "",
    roll:"",
    aptList: [],
    dongCode: "",
    aptDetail: "",
  },
  getters: {
    getAccessToken(state) {
      return state.accessToken;
    },
    getUserId(state) {
      return state.userId;
    },
    getUserName(state) {
      return state.userName;
    },
    getAptList(state) {
      return state.aptList;
    },
    getAptDetail(state) {
      return state.aptDetail;
    },
    getRoll(state) {
      return state.roll;
    }
  },
  mutations: {
    LOGIN(state, payload) {
      console.log('페이로드');
      console.log(payload);
      state.accessToken = payload["auth-token"];
      state.userId = payload["user-id"];
      state.userName = payload["user-name"];
      state.roll = payload["user-roll"];
    },
    LOGOUT(state) {
      state.accessToken = null;
      state.userId = "";
      state.userName = "";
      state.roll = "";
    },
    APTLIST: function(state, payload) {
      state.aptList = payload;
    },
    DONGCODE: function(state, payload) {
      state.dongCode = payload;
    },
    APTDETAIL: function(state, payload) {
      state.aptDetail = payload;
    },
  },
  actions: {
    LOGIN(context, user) {
      return axios
        .post(`${SERVER_URL}/user/confirm/login`, user)
        .then((response) => {
          context.commit("LOGIN", response.data); //데이터를 받고 초기화과정
          axios.defaults.headers.common[
            "auth-token"
          ] = `${response.data["auth-token"]}`;
        });
    },
    LOGOUT(context) {
      context.commit("LOGOUT");
      axios.defaults.headers.common["auth-token"] = undefined;
    },
  },
  modules: {},
});
