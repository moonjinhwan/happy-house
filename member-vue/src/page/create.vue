<template>
  <div>
    <que />
    <div id="qna">
      <h3>질문은 명확히 해주시기 바랍니다.</h3>
      <hr />
      <br />
      <create-form type="create" />
    </div>
  </div>
</template>

<script>
import CreateForm from "@/components/Form.vue";
import que from "@/components/qna.vue";

export default {
  name: "create",
  components: {
    CreateForm,
    que,
  },
};
</script>

<style></style>
