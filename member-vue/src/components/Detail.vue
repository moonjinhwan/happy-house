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
    </div>
  </div>
</template>

<script>
import moment from "moment";
export default {
  name: "detail",
  props: {
    no: { type: Number },
    writer: { type: String },
    title: { type: String },
    content: { type: String },
    regtime: { type: String },
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format("YYYY.MM.DD HH:mm:ss");
    },
  },
};
</script>
