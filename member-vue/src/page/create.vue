<template>
  <div id="qna">
    <h3>질문은 명확히 해주시기 바랍니다.</h3>
    <hr />
    <br />
    <create-form type="create" />
  </div>
</template>

<script>
import CreateForm from "@/components/Form.vue";
export default {
  name: "create",
  components: {
    CreateForm,
  },
};
</script>

<style></style>
