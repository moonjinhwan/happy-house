<template>
  <section>
    <tr>
      <th>법정동</th>
      <th>아파트 이름</th>
      <th>지번</th>
    </tr>
    <apt-list-item v-for="(apt, index) in getAptList" :key="index" :aptInfo="apt"> </apt-list-item>
  </section>
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
