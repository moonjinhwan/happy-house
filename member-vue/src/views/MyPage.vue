<template>
  <div>
    <b-table striped hover :items="mypage"></b-table>
  </div>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      mypage: [],
    };
  },
  created() {
    axios
      .get(`${SERVER_URL}/user/mypage/${this.$store.state.userId}`)
      .then((response) => {
        console.log(response.data);
        this.mypage = response.data.myPageInfo;
      })
      .catch(() => {
        alert('찜목록 불러오는 중, 에러가 발생했습니다.');
      });
  },
};
</script>

<style></style>
