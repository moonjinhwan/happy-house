<template>
  <div>
    <b-table
      sticky-header
      :items="getAptDetail"
      head-variant="light"
      @row-clicked="handler"
      hover
    ></b-table>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getAptDetail']),
  },
  methods: {
    handler(object, index) {
      console.log(object + ' ' + index);
      alert(this.$store.state.userId);
    },
  },
};
</script>
<style></style>
