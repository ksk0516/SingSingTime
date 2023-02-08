<template>
  <v-row justify="space-between" style="background-color: black">
    <v-col>{{ song.title }}</v-col>
    <v-col>{{ song.singer }}</v-col>
  </v-row>
</template>

<script>
export default {
  name: "songInfo",
  props: {
    song: Object,
  },
};
</script>

<style>
</style>