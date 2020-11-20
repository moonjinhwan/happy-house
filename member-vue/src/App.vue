<template>
  <div id="app">
    <div>
      <b-navbar toggleable="lg" type="dark" variant="dark">
        <b-navbar-brand
          ><router-link to="/"
            ><img
              src="@/assets/nav_logo.png"
              class="d-inline-block align-middle"
              width="60px"
              alt="Kitten"
            />
            SSAFY</router-link
          ></b-navbar-brand
        >
        <!-- <b-navbar-brand href="/">SSAFY</b-navbar-brand> -->

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav class="ml-auto" v-if="getAccessToken">
            <b-nav-item
              ><b-avatar
                variant="primary"
                v-text="getUserId.charAt(0).toUpperCase()"
              ></b-avatar
              >{{ getUserName }}({{ getUserId }})님 환영합니다.</b-nav-item
            >
            <b-nav-item
              ><router-link to="/me">내정보보기</router-link></b-nav-item
            >
            <b-nav-item @click.prevent="onClickLogout">로그아웃</b-nav-item>
            <!-- <b-nav-item href="/me">내정보보기</b-nav-item>
            <b-nav-item href="/logout">로그아웃</b-nav-item> -->
          </b-navbar-nav>
          <b-navbar-nav class="ml-auto" v-else>
            <b-nav-item>
              <router-link to="/login">로그인</router-link></b-nav-item
            >
            <b-nav-item
              ><router-link to="/join">회원가입</router-link></b-nav-item
            >
            <!-- <b-nav-item href="/login">로그인</b-nav-item>
            <b-nav-item href="/join">회원가입</b-nav-item> -->
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <router-view />
  </div>
</template>

<script>
import Vue from "vue";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

//mapGetters 등록
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      isLogin: false
    };
  },
  computed: {
    ...mapGetters(["getAccessToken", "getUserId", "getUserName"])
  },
  methods: {
    onClickLogout() {
      this.$store
        .dispatch("LOGOUT")
        .then(() => this.$router.replace("/").catch(() => {}));
    }
  }
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

a {
  color: rgb(219, 250, 250);
}

a:hover {
  color: rgb(219, 250, 250);
  text-decoration: none;
}
</style>
