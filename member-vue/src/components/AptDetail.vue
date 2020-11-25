<template>
  <div>
    <b-table
      sticky-header
      :items="getAptDetail"
      head-variant="light"
      @row-clicked="mypage"
      hover
      :fields="fields"
    ></b-table>
  </div>
</template>

<script>
import axios from 'axios';
import { mapGetters } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      fields: [
        { key: 'AptName', label: '아파트명' },
        { key: 'area', label: '면적' },
        { key: 'dealAmount', label: '거래가' },
        { key: 'dealYear', label: '거래년도' },
        { key: 'dong', label: '법정동' },
      ],
    };
  },
  computed: {
    ...mapGetters(['getAptDetail']),
  },
  methods: {
    mypage(obj) {
      console.log(obj);
      if (this.$store.state.userId == '') {
        alert('로그인을 해주세요');
      } else {
        axios
          .post(`${SERVER_URL}/user/mypage`, {
            userId: this.$store.state.userId,
            aptName: obj.AptName,
            dealAmount: obj.dealAmount,
            dealYear: obj.dealYear,
            dong: obj.dong,
            area: obj.area,
          })
          .then(() => {
            alert('내 페이지에 저장 되었어요');
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
  },
};
</script>
<style></style>
