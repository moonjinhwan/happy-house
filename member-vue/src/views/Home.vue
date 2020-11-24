<template>
  <div class="home">
    <div id="main jumbo">
      <b-jumbotron id="hi">
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <h1 style=" color: black">
          당신의 꿈꾸던 새로운 보금자리 Happy House에서 찾아보세요
        </h1>
        <br />
        <br />
        <br />
        <b-button pill variant="info btn-lg"
          ><router-link to="/searchApt" id="mainbutton">
            지금 검색할래요
          </router-link></b-button
        >
      </b-jumbotron>
    </div>
    <Main msg="" />
  </div>
</template>

<script>
import Main from "@/components/Main.vue";

export default {
  name: "Home",
  components: {
    Main,
  },
};
</script>

<style>
#hi {
  background: url("../assets/cozy2.jpg") no-repeat center center;
  -webkit-background-size: 100% 100%;
  -moz-background-size: 100% 100%;
  -o-background-size: 100% 100%;
  background-size: 100% 100%;
  height: 700px;
}
h1 {
  font-weight: bold;
}
#mainbutton {
  color: white;
}
</style>
