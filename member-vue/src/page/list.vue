<template>
  <div>
    <que />
    <div id="qna">
      <div v-if="items.length">
        <h3>Happy House는 항상 고객님을 우선시 생각합니다.</h3>
        <hr />
        <div class="text-right">
          <button v-if="getAccessToken" class="btn btn-outline-primary" @click="movePage">
            글쓰기
          </button>
        </div>
        <br />
        <table class="table table-bordered table-condensed">
          <colgroup>
            <col :style="{ width: '5%' }" />
            <col :style="{ width: '50%' }" />
            <col :style="{ width: '10%' }" />
            <col :style="{ width: '25%' }" />
          </colgroup>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
          </tr>
          <list-row
            v-for="(item, index) in items"
            :key="`${index}_items`"
            :no="item.no"
            :title="item.title"
            :writer="item.writer"
            :regtime="item.regtime"
          />
        </table>
      </div>
      <div v-else>글이 없습니다.</div>
    </div>
  </div>
</template>

<script>
import http from '@/util/http-common';
import ListRow from '@/components/Row.vue';
import que from '@/components/qna.vue';
import { mapGetters } from 'vuex';
export default {
  name: 'list',
  components: {
    ListRow,
    que,
  },
  data: function() {
    return {
      items: [],
    };
  },
  created() {
    http
      .get('/board')
      .then(({ data }) => {
        this.items = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  methods: {
    movePage() {
      this.$router.push('/create');
    },
  },
  computed: {
    ...mapGetters(['getAccessToken', 'getUserId', 'getUserName']),
  },
};
</script>

<style>
th {
  background-color: mintcream;
}
#qna {
  margin-left: 20%;
  margin-right: 20%;
  margin-top: 3%;
  margin-bottom: 7%;
}
</style>
