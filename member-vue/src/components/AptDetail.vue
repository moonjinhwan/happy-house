<template>
  <div>
    <!-- <table class="table">
      <thead>
        <tr>
          <th scope="col">번호</th>
          <th scope="col">동</th>
          <th scope="col">아파트</th>
          <th scope="col">거래금액</th>
          <th scope="col">면적</th>
          <th scope="col">거래년도</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(info, index) in getAptDetail" :key="index">
          <th scope="row">{{ index + 1 }}</th>
          <td>{{ info.dong }}</td>
          <td>{{ info.AptName }}</td>
          <td>{{ info.dealAmount }}</td>
          <td>{{ info.area }}</td>
          <td>{{ info.dealYear }}</td>
        </tr>
      </tbody>
    </table> -->
    <b-table
      sticky-header
      :items="getAptDetail"
      head-variant="light"
      @row-clicked="handler"
    ></b-table>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getAptDetail']),
  },
  methods: {
    handler(a, b) {
      alert(a);
      alert(b);
    },
  },
};
</script>
<style></style>
