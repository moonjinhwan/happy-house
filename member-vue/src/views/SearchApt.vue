<template>
  <div>
    <b-jumbotron header="Search House"> </b-jumbotron>
    <table class="table">
      <thead>
        <tr>
          <th>법정동</th>
          <th>아파트이름</th>
          <th>지번</th>
        </tr>
      </thead>
      <!-- apt list 출력 -->
      <tbody>
        <apt-list />
      </tbody>
    </table>
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
