<template>
  <div>
    <que />
    <div id="qna"></div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import que from '@/components/noticeboard.vue';

export default {
  name: "delete",
  components: {
    que,
  },
  created() {
    http
      .delete(`/notice/${this.$route.query.no}`)
      .then(({ data }) => {
        let msg = "삭제 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "삭제가 완료되었습니다.";
        }
        alert(msg);
        this.$router.push("/noticeList");
      })
      .catch(() => {
        alert("삭제 처리시 에러가 발생했습니다.");
      });
  },
};
</script>

<style></style>
