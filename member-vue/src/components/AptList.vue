<template>
  <div style="padding-left: 2%; padding-right: 2%">
    <h2>아파트 정보</h2>
    <h7 style="float:right;  text-decoration: underline;"
      >* 해당 아파트를 클릭시 실거래가 정보를 확인할수 있습니다.</h7
    >
    <br />
    <hr />
    <section>
      <b-table sticky-header :items="getAptList" head-variant="light" :fields="fields" hover>
        <template #cell(pick)="data">
          <b-button size="sm" class="mr-2" @click="aptDetail(data.item)">자세히 </b-button>
        </template>
      </b-table>
    </section>
  </div>
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
        { key: 'pick', label: '' },
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
