<template>
  <div id="ccc">
    <div class="form-group">
      <label class="label" for="writer" style="color: black">작성자 :</label>
      <input type="text" class="form-control" id="writer" ref="writer" v-model="writer" disabled />
    </div>
    <div class="form-group">
      <label class="label" for="title" style="color: black">제목 :</label>
      <input
        type="text"
        class="form-control"
        id="title"
        ref="title"
        placeholder="제목을 입력하세요"
        v-model="title"
      />
    </div>
    <div class="form-group">
      <label class="label" for="content" style="color: black">내용 :</label>
      <textarea
        type="text"
        class="form-control"
        id="contnet"
        ref="content"
        placeholder="내용을 입력하세요"
        v-model="content"
      ></textarea>
    </div>
    <div class="text-right">
      <button
        class="btn btn-outline-primary"
        v-if="type == 'create'"
        @click="checkHandler"
        style="margin-right: 30px"
      >
        등록
      </button>
      <button
        class="btn btn-outline-primary"
        v-else
        @click="checkHandler"
        style="margin-right: 30px"
      >
        수정
      </button>
      <button class="btn btn-outline-info" @click="moveList">목록</button>
    </div>
  </div>
</template>

<script>
import http from '@/util/http-common';
import { mapGetters } from 'vuex';
export default {
  name: 'board-Form',
  props: {
    type: { type: String },
  },
  data: function() {
    return {
      no: '',
      regtime: '',
      writer: this.$store.state.userId,
      title: '',
      content: '',
    };
  },
  computed: {
    ...mapGetters(['getAccessToken', 'getUserId', 'getUserName']),
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.writer && ((msg = '작성자를 입력해주세요'), (err = false), this.$refs.writer.focus());
      err && !this.title && ((msg = '제목 입력해주세요'), (err = false), this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = '내용 입력해주세요'), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else this.type == 'create' ? this.createHandler() : this.updateHandler();
    },
    createHandler() {
      http
        .post('/board', {
          writer: this.writer,
          title: this.title,
          content: this.content,
        })
        .then(({ data }) => {
          let msg = '등록 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '등록이 완료되었습니다.';
          }
          alert(msg);
          this.moveList();
        })
        .catch(() => {
          alert('등록 처리시 에러가 발생했습니다.');
        });
    },
    updateHandler() {
      http
        .put(`/board/${this.no}`, {
          no: this.no,
          regtime: this.regtime,
          writer: this.writer,
          title: this.title,
          content: this.content,
        })
        .then(({ data }) => {
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '수정이 완료되었습니다.';
          }
          alert(msg);
          this.moveList();
        })
        .catch(() => {
          alert('수정 처리시 에러가 발생했습니다.');
        });
    },
    moveList() {
      this.$router.push('/list');
    },
  },
  created() {
    if (this.type === 'update') {
      http
        .get(`/board/${this.$route.query.no}`)
        .then(({ data }) => {
          this.no = data.no;
          this.regtime = data.regtime;
          this.writer = data.writer;
          this.title = data.title;
          this.content = data.content;
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    }
  },
};
</script>

<style scoped>
#ccc {
  color: black;
}
.label {
  font-weight: bold;
  float: left;
  font-size: 20px;
}
</style>
