<template>
  <div>
    <b-table
      sticky-header
      :items="getAptDetail"
      head-variant="light"
      @row-clicked="mypage"
      hover
    ></b-table>
  </div>
</template>

<script>
import axios from 'axios';
import { mapGetters } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
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
