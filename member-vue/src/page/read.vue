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
        :reply="item.reply"
      />
    </div>
  </div>
</template>

<script>
import http from '@/util/http-common';
import Detail from '@/components/Detail.vue';
import que from '@/components/qna.vue';

export default {
  name: 'read',
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
    http.get(`/board/${this.$route.query.no}`).then(({ data }) => {
      this.item = data;
      console.log('>>>글 상세 정보 받아왔습니다');
      console.dir(data);
    });
  },
};
</script>

<style></style>
