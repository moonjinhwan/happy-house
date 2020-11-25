<template>
  <a
    class="list-group-item list-group-item-action"
    data-toggle="tooltip"
    :title="title"
  >
    <router-link :to="`/noticeRead?no=${no}`" style=" color: grey ;"
      >[공지] {{ title }}</router-link
    ></a
  >
</template>

<script>
export default {
  name: "row",
  props: {
    no: { type: Number },
    title: { type: String },
  },
};
</script>
