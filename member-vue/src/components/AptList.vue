<template>
  <section>
    <b-table
      sticky-header
      :items="getAptList"
      head-variant="light"
      @row-clicked="aptDetail"
      hover
    ></b-table>
  </section>
</template>

<script>
import axios from 'axios';
import { mapGetters, mapMutations } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  computed: {
    ...mapGetters(['getAptList']),
  },

  methods: {
    ...mapMutations({
      setDetail: 'APTDETAIL',
    }),
    aptDetail: function(obj) {
      axios
        .post(`${SERVER_URL}/map/detail`, {
          dong: obj.dong,
          aptName: obj.aptName,
        })
        .then((response) => {
          console.log(response);
          this.setDetail(response.data.detailInfo);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
