<template>
  <div>
    <b-jumbotron header="Search House"> </b-jumbotron>
    <table class="table mt-2">
      <thead>
        <tr>
          <th>번호</th>
          <th>법정동</th>
          <th>아파트이름</th>
          <th>지번</th>
          <th>지역코드</th>
          <th>위도</th>
          <th>경도</th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    <div id="app">
      <google-map />
    </div>
  </div>
</template>

<script>
import GoogleMap from '../components/GoogleMap';

export default {
  name: 'App',
  components: {
    GoogleMap,
  },
};
</script>

<style></style>
