<template>
  <b-table
    sticky-header
    :items="getAptList"
    head-variant="light"
    @row-clicked="aptDetail"
  ></b-table>
</template>

<script>
import { mapGetters } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  computed: {
    ...mapGetters(['getAptDetail']),
  },
  methods: {
    select: function() {
      axios
        .post(`${SERVER_URL}/map/place`, {
          dongname: this.selectDong,
          type: 1,
        })
        .then((response) => {
          console.log(response.data.placeInfo);
          for (var i = 0; i < response.data.placeInfo.length; i++) {
            this.markers.push({
              position: {
                lat: parseFloat(response.data.placeInfo[i].lat),
                lng: parseFloat(response.data.placeInfo[i].lng),
              },
              icon: 'chicken.ico',
            });
          }
        })
        .catch(() => {
          alert('상권정보를 받는 중, 에러가 발생했습니다.');
        });
    },
  },
};
</script>

<style></style>
