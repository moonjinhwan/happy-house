<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">번호</th>
          <th scope="col">아파트</th>
          <th scope="col">거래금액</th>
          <th scope="col">건축년도</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(info, index) in getAptDetail" :key="index">
          <th scope="row">{{ index }}</th>
          <td>{{ info.아파트 }}</td>
          <td>{{ info.거래금액 }}</td>
          <td>{{ info.건축년도 }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  computed: {
    ...mapGetters(['getAptDetail']),
  },
};
</script>
<style></style>
