<template>
  <div>
    <h5> 이곳에서 수정해주세요.</h5>
    <update-form type="update" />
  </div>
</template>

<script>
import UpdateForm from '@/components/Form.vue';
export default {
  name: 'Modify',
  components: {
    UpdateForm,
  },
};
</script>

<style></style>
