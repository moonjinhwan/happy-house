<template>
  <b-container class="mt-4">
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-jumbotron>
          <h1>Join Page</h1>
          <br />
          <h4>회원가입 페이지입니다</h4>

          <hr class="my-4" />

          <b-container class="mt-4">
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">아이디</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="userid"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">비밀번호</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="userpwd"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="username"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이메일</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="email"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">주소</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input v-model="address"></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
          </b-container>
          <hr class="my-4" />
          <b-button variant="btn btn-outline-info" href="#" class="mr-1" @click="join"
            >회원가입</b-button
          >
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
      userid: '',
      userpwd: '',
      username: '',
      email: '',
      address: '',
    };
  },
  methods: {
    join: function() {
      axios
        .post(`${SERVER_URL}/user/confirm/join`, {
          userid: this.userid,
          userpwd: this.userpwd,
          username: this.username,
          email: this.email,
          address: this.address,
        })
        .then(() => {
          alert('회원가입 완료');
          //정보변환
          this.moveMain();
        })
        .catch(() => {
          alert('회원가입 처리시 에러가 발생했습니다.');
        });
    },
    moveMain() {
      this.$router.replace('/');
    },
  },
};
</script>
