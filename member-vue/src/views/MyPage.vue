<template>
  <div>
    <b-table sticky-header head-variant="light" striped hover :items="mypage" :fields="fields">
      <template #cell(userid)="data">
        {{ data.item.userId }}
      </template>
      <template #cell(aptName)="data">
        {{ data.item.aptName }}
      </template>
      <template #cell(dealAmount)="data">
        {{ data.item.dealAmount }}
      </template>
      <template #cell(dealYear)="data">
        {{ data.item.dealYear }}
      </template>
      <template #cell(dong)="data">
        {{ data.item.dong }}
      </template>
      <template #cell(area)="data">
        {{ data.item.area }}
      </template>
      <template #cell(del)="data">
        <b-button size="sm" @click="delMyPage(data.item.no)" class="mr-2">삭제 </b-button>
      </template>
    </b-table>
  </div>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      fields: [
        { key: 'userid', label: '아이디' },
        { key: 'aptName', label: '아파트 이름' },
        { key: 'dealAmount', label: '거래가' },
        { key: 'dealYear', label: '거래년도' },
        { key: 'dong', label: '동이름' },
        { key: 'area', label: '면적' },
        { key: 'del', label: '삭제' },
      ],
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
  methods: {
    delMyPage: function(no) {
      axios
        .delete(`${SERVER_URL}/user/mypage/${no}`)
        .then(() => {
          alert('삭제 되었습니다.');
          this.getList();
        })
        .catch(() => {
          alert('삭제 중, 에러가 발생했습니다.');
        });
    },
    getList: function() {
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
  },
};
</script>

<style></style>
