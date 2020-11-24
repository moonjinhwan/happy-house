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
    mypage(object) {
      if (this.$store.state.userId == '') {
        alert('로그인을 해주세요');
      } else {
        axios
          .post(`${SERVER_URL}/user/mypage`, {
            object,
          })
          .then((response) => {
            console.log(response.data);
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
