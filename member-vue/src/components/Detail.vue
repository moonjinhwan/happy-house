<template>
  <div id="qna">
    <h3>
      <strong>{{ writer }}</strong> 님의 "{{ title }}"
    </h3>
    <hr />
    <br />
    <table class="table table-bordered">
      <tr>
        <th>번호</th>
        <td>{{ no }}</td>
      </tr>
      <tr>
        <th>글쓴이</th>
        <td>{{ writer }}</td>
      </tr>
      <tr>
        <th>제목</th>
        <td>{{ title }}</td>
      </tr>
      <tr>
        <th>날짜</th>
        <td>{{ getFormatDate(regtime) }}</td>
      </tr>
      <tr>
        <td colspan="2">
          {{ content }}
        </td>
      </tr>
    </table>

    <br />
    <div class="text-center">
      <router-link to="/list"
        ><button class="btn btn-outline-info" style="margin-left: 15px">
          목록
        </button></router-link
      >
      <span v-if="writer === getUserId">
        <router-link :to="'/modify?no=' + no"
          ><button class="btn btn-outline-primary " style="margin-left: 15px">
            수정
          </button></router-link
        >
        <router-link :to="'/delete?no=' + no"
          ><button class="btn btn-outline-danger" style="margin-left: 15px">
            삭제
          </button></router-link
        >
      </span>
    </div>
    <br />
    <br />
    <h3>
      답변
    </h3>
    <hr />
    <br />
    <div v-if="getRoll == 'admin'">
      <b-form-textarea
        id="textarea-rows"
        placeholder="답변을 입력해주세요."
        rows="8"
        v-model="reply"
      ></b-form-textarea>
      <br />
      <button class="btn btn-outline-primary" style="margin-left: 15px" @click="updateReply">
        답변등록
      </button>
    </div>
    <div v-else>
      <b-form-textarea
        id="textarea-rows"
        placeholder="답변을 입력해주세요."
        rows="8"
        disabled
        v-model="reply"
      ></b-form-textarea>
    </div>
  </div>
</template>

<script>
import moment from 'moment';
import axios from 'axios';
import { mapGetters } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: 'detail',
  props: {
    no: { type: Number },
    writer: { type: String },
    title: { type: String },
    content: { type: String },
    regtime: { type: String },
    reply: { type: String },
  },
  computed: {
    ...mapGetters(['getAccessToken', 'getUserId', 'getUserName', 'getRoll']),
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
    },
    updateReply: function() {
      axios
        .put(`${SERVER_URL}/api/board/${this.no}`, {
          no: this.no,
          writer: this.writer,
          title: this.title,
          content: this.content,
          regtime: this.regtime,
          reply: this.reply,
        })
        .then((response) => {
          console.log(response.data);
          alert('답글이 수정 되었습니다.');
        })
        .catch(() => {
          alert('답글 수정 중, 에러가 발생했습니다.');
        });
    },
  },
};
</script>
