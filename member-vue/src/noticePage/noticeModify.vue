<template>
  <div>
    <que />
    <div id="qna">
      <h3>이곳은 수정하는 곳입니다</h3>
      <hr />
      <br />
      <update-form type="update" />
    </div>
  </div>
</template>

<script>
import UpdateForm from "@/components/noticeForm.vue";
import que from "@/components/qna.vue";

export default {
  name: "Modify",
  components: {
    UpdateForm,
    que,
  },
};
</script>

<style></style>
