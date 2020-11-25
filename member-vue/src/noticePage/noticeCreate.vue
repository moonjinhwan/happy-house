<template>
  <div>
    <que />
    <div id="qna">
      <h3>이곳은 "관리자 계정"만 입장가능합니다.</h3>
      <hr />
      <br />
      <create-form type="create" />
    </div>
  </div>
</template>

<script>
import CreateForm from '@/components/noticeForm.vue';
import que from '@/components/noticeboard.vue';

export default {
  name: 'create',
  components: {
    CreateForm,
    que,
  },
};
</script>

<style></style>
