<template>
  <div>
    <b-jumbotron header="Search House"> </b-jumbotron>
    <div class="container">
      <table class="table d-flex justify-content-center">
        <tbody>
          <apt-list />
        </tbody>
      </table>
    </div>
    <!-- google map 부분  -->
    <div id="app">
      <google-map />
    </div>
  </div>
</template>

<script>
import GoogleMap from '../components/GoogleMap';
import AptList from '../components/AptList';

export default {
  name: 'App',
  components: {
    GoogleMap,
    AptList,
  },
};
</script>

<style></style>
