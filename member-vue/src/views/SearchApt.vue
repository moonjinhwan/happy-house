<template>
  <div>
    <b-jumbotron header="Search House"> </b-jumbotron>
    <div class="container">
      <h1>아파트 정보</h1>
      <apt-list />
    </div>
    <!-- google map 부분  -->
    <div id="app">
      <google-map />
    </div>
  </div>
</template>

<script>
import GoogleMap from '../components/GoogleMap';
// import AptList from '../components/AptList';
import AptList from '../components/AptList';
export default {
  name: 'App',
  components: {
    GoogleMap,
    // AptList,/////
    AptList,
  },
};
</script>

<style></style>
