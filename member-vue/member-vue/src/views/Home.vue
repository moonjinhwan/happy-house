<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <Main msg="Welcome to SSAFY App" />
  </div>
</template>

<script>
import Main from "@/components/Main.vue";

export default {
  name: "Home",
  components: {
    Main
  }
};
</script>
