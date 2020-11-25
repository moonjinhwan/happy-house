<template>
  <div>
    <que />
    <div id="qna">
      <h3>공지사항 수정</h3>
      <hr />
      <br />
      <update-form type="update" />
    </div>
  </div>
</template>

<script>
import UpdateForm from "@/components/noticeForm.vue";
import que from '@/components/noticeboard.vue';

export default {
  name: "Modify",
  components: {
    UpdateForm,
    que,
  },
};
</script>

<style></style>
