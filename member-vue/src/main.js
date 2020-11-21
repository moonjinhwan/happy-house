import Vue from "vue";
import "./plugins/axios";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import * as VueGoogleMaps from "vue2-google-maps";
Vue.config.productionTip = false;

Vue.use(VueGoogleMaps, {
  load: {
    // key: "AIzaSyCI4R7hPcX-S1EqfalizYdxuDlQEUkTcTs",
    libraries: "places" // necessary for places input
  }
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
