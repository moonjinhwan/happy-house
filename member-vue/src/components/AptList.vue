<template>
  <span>
    <apt-list-item v-for="(apt, index) in getAptList" :key="index" :aptInfo="apt"> </apt-list-item>
  </span>
</template>

<script>
import AptListItem from '@/components/AptListItem';

import { mapGetters } from 'vuex';
export default {
  components: { AptListItem },
  comments: {
    AptListItem,
  },
  computed: {
    ...mapGetters(['getAptList']),
  },
};
</script>
