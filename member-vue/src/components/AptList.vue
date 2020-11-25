<template>
  <section>
    <b-table
      sticky-header
      :items="getAptList"
      head-variant="light"
      @row-clicked="aptDetail"
      :fields="fields"
      hover
    >
    </b-table>
  </section>
</template>

<script>
import axios from 'axios';
import { mapGetters, mapMutations } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      fields: [
        { key: 'aptName', label: '아파트명' },
        { key: 'buildYear', label: '설립 년도' },
        { key: 'dong', label: '법정동' },
        { key: 'jibun', label: '지번' },
      ],
    };
  },
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
          console.log('디테일 인포');
          console.log(response.data.detailInfo);
          this.setDetail(response.data.detailInfo);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
