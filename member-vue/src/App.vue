<template>
  <div id="app">
    <div>
      <b-navbar toggleable="lg" variant="faded" type="light">
        <b-navbar-brand tag="h1" class="mb-0"
          ><router-link to="/"
            ><img
              src="@/assets/nav_logo.png"
              class="d-inline-block align-middle"
              width="200px"
            /> </router-link
        ></b-navbar-brand>
        <!-- <b-navbar-brand href="/">SSAFY</b-navbar-brand> -->

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav class="ml-auto" v-if="getAccessToken">
            <b-nav-item
              ><b-avatar
                variant="primary"
                v-text="getUserId.charAt(0).toUpperCase()"
              ></b-avatar
              >{{ getUserName }}({{ getUserId }})님 환영합니다.
            </b-nav-item>
            <b-nav-item
              ><router-link to="/me">내정보보기</router-link></b-nav-item
            >
            <b-nav-item @click.prevent="onClickLogout" class="loginout"
              >로그아웃</b-nav-item
            >
            <!-- <b-nav-item href="/me">내정보보기</b-nav-item>
            <b-nav-item href="/logout">로그아웃</b-nav-item> -->
          </b-navbar-nav>
          <b-navbar-nav class="ml-auto" v-else>
            <b-nav-item>
              <router-link to="/login" class="loginout"
                >로그인</router-link
              ></b-nav-item
            >
            <b-nav-item
              ><router-link to="/join" class="loginout">
                회원가입</router-link
              ></b-nav-item
            >
            <!-- <b-nav-item href="/login">로그인</b-nav-item>
            <b-nav-item href="/join">회원가입</b-nav-item> -->
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <router-view />
<hr>
 <footer class="bg-white">
    <div class="container py-5">
      <div class="row py-4">
        <div class="col-lg-4 col-md-6 mb-4 mb-lg-0"><img src="img/logo.png" alt="" width="180" class="mb-3">
          <p class="font-italic text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
        </div>
        <div class="col-lg-4 col-md-6 mb-lg-0">
          <h6 class="text-uppercase font-weight-bold mb-4">Newsletter</h6>
          <p class="text-muted mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit. At itaque temporibus.</p>
          <div class="p-1 rounded border">
            <div class="input-group">
              <input type="email" placeholder="Enter your email address" aria-describedby="button-addon1" class="form-control border-0 shadow-0">
              <div class="input-group-append">
                <button id="button-addon1" type="submit" class="btn btn-link"><i class="fa fa-paper-plane"></i></button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Copyrights -->
    <div class="bg-light py-4">
      <div class="container text-center">
        <p class="text-muted mb-0 py-2">© 2020 SSAFY M&K All right reserved</p>
      </div>
    </div>
  </footer>
  <!-- End -->


    
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
      isLogin: false,
    };
  },
  computed: {
    ...mapGetters(["getAccessToken", "getUserId", "getUserName"]),
  },
  methods: {
    onClickLogout() {
      this.$store
        .dispatch("LOGOUT")
        .then(() => this.$router.replace("/").catch(() => {}));
    },
    join: function() {
      this.$$router.replace("/");
    },
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: black;
}

.loginout {
  color: black;
}

a:hover {
  color: skyblue;
  font-weight: bold;
  text-decoration: none;
}





#button-addon1 {
  color: #ffc371;
}

i {
  color: #ffc371;
}

.form-control::placeholder {
  font-size: 0.95rem;
  color: #aaa;
  font-style: italic;
}

.form-control.shadow-0:focus {
  box-shadow: none;
}
</style>
