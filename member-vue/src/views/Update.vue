<template>
  <b-container class="mt-4" v-if="user">
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-jumbotron>
          <h1>Update Page</h1>
          <br />
          <h4>정보수정 페이지입니다</h4>

          <hr class="my-4" />

          <b-container class="mt-4">
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">아이디</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="user.userid" readonly></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="user.username"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이메일</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="user.email"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">주소</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="user.address"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">가입일</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="user.joindate"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
          </b-container>
          <hr class="my-4" />

          <b-button variant="btn btn-outline-primary" href="#" class="mr-1" @click="update"
            >정보수정</b-button
          >
          <b-button variant="btn btn-outline-danger" href="#" @click="del">회원탈퇴</b-button>
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import axios from 'axios';

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      user: null,
    };
  },
  created() {
    axios
      .get(`${SERVER_URL}/user/info`)
      .then((response) => {
        this.user = response.data.info;
      })
      .catch(() => {
        this.$store.dispatch('LOGOUT').then(() => this.moveMain());
      });
  },
  methods: {
    update: function() {
      axios
        .put(`${SERVER_URL}/user/update`, {
          userid: this.user.userid,
          username: this.user.username,
          email: this.user.email,
          address: this.user.address,
          joindate: this.user.joindate,
        })
        .then(() => {
          alert('수정 완료');
          //정보변환
          this.moveMain();
        })
        .catch(() => {
          alert('수정 처리시 에러가 발생했습니다.');
        });
    },
    del: function() {
      axios
        .delete(`${SERVER_URL}/user/${this.user.userid}`)
        .then(() => {
          alert('삭제 완료');
          this.moveMain();
        })
        .catch(() => {
          alert('삭제 시 에러가 발생했습니다.');
        });
    },
    moveMain() {
      this.$router.replace('/');
    },
  },
};
</script>
