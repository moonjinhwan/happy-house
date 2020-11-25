<template>
  <div>
    <que />
    <div id="qna">
      <detail
        :content="item.content"
        :title="item.title"
        :writer="item.writer"
        :regtime="item.regtime"
        :no="item.no"
      />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import Detail from "@/components/noticeDetail.vue";
import que from '@/components/noticeboard.vue';

export default {
  name: "read",
  components: {
    Detail,
    que,
  },
  data: function() {
    return {
      item: {},
    };
  },
  created() {
    http.get(`/notice/${this.$route.query.no}`).then(({ data }) => {
      this.item = data;
      console.dir(data);
    });
  },
};
</script>

<style></style>
