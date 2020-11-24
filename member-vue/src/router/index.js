import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Update from "../views/Update.vue";
import Me from "../views/Me.vue";
import store from "../store";
import Join from "../views/Join.vue";
import SearchApt from "../views/SearchApt.vue";
import qna from "../views/qna.vue";
// import { join } from "core-js/fn/array";

Vue.use(VueRouter);

// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const requireAuth = () => (to, from, next) => {
  const nextRoute = to.path;

  if (store.getters.getAccessToken) {
    return next();
  } else next("/login" + nextRoute);
};

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/login/:nextRoute",
    name: "LoginNextRoute",
    component: Login
  },
  {
    path: "/update",
    name: "update",
    component: Update,
  },
  {
    path: "/me",
    name: "Me",
    component: Me,
    beforeEnter: requireAuth()
  },
  {
    path: "/join",
    name: "Join",
    component: Join,
  },
  {
    path: "/searchApt",
    name: 'searchApt',
    component: SearchApt,
  },
  {
    path: "/qna",
    name: 'qna',
    component: qna,
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
