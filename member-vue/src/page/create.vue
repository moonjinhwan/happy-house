<template>
  <div>
    <h5> 질문 작성시 명확히.</h5> 
    <create-form type="create" />
  </div>
</template>

<script>
import CreateForm from '@/components/Form.vue';
export default {
  name: 'create',
  components: {
    CreateForm,
  },
};
</script>

<style></style>
