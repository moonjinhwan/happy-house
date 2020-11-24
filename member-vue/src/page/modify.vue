<template>
  <div id="qna">
    <h3>이곳은 수정하는 곳입니다</h3>
    <hr />
    <br />
    <update-form type="update" />
  </div>
</template>

<script>
import UpdateForm from "@/components/Form.vue";
export default {
  name: "Modify",
  components: {
    UpdateForm,
  },
};
</script>

<style></style>
