<template>
  <div>
    <que />
    <div id="qna">
      <div v-if="items.length">
        <h3>새로운 공지사항을 꼭 열람하시고 숙지 바랍니다.</h3>
        <hr />
        <div class="text-right">
          <button class="btn btn-outline-primary" @click="movePage">
            공지사항 추가
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
      <div v-else>공지사항이 없습니다.</div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import ListRow from "@/components/noticeRow.vue";
import que from '@/components/noticeboard.vue';

export default {
  name: "list",
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
      .get("/notice")
      .then(({ data }) => {
        this.items = data;
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
  },
  methods: {
    movePage() {
      this.$router.push("/noticeCreate");
    },
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
