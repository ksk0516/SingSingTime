<template>
  <v-card>
    <!-- <v-system-bar color="deep-purple darken-3"></v-system-bar> -->
    <v-bar class="header_bar" color="primary">
      <img class="logo" src="../../../assets/images/logo.png" />
      <!-- 
          <v-app-bar-nav-icon
          variant="text"
          @click.stop="drawer = !drawer"
        ></v-app-bar-nav-icon> 
      -->
      <v-spacer></v-spacer>

      <v-text-field
        hide-details
        placeholder="검색"
        single-line
        style="margin: 20px"
        v-show="state.search"
        @keydown.enter="search_thing"
      ></v-text-field>

      <v-btn
        @click="search_hover"
        class="inline"
        variant="text"
        icon="mdi-magnify"
        style="margin-top: 25px"
      ></v-btn>

      <v-btn variant="text" class="inline">회원가입</v-btn>

      <v-btn variant="text" class="inline">로그인</v-btn>
      <!--
        <v-btn variant="text" icon="mdi-dots-vertical"></v-btn>
    -->
    </v-bar>

    <v-navigation-drawer v-model="drawer" location="bottom" temporary>
      <v-list :items="items"></v-list>
    </v-navigation-drawer>
    <v-main></v-main>
  </v-card>
</template>

<script>
import { reactive } from "vue";
export default {
  name: "HeaderBar",
  data: () => ({
    drawer: false,
    group: null,
    items: [
      {
        title: "Foo",
        value: "foo",
      },
      {
        title: "Bar",
        value: "bar",
      },
      {
        title: "Fizz",
        value: "fizz",
      },
      {
        title: "Buzz",
        value: "buzz",
      },
    ],
  }),

  watch: {
    group() {
      this.drawer = false;
    },
  },
  setup() {
    const state = reactive({
      search: false,
    });
    const search_hover = () => {
      state.search = !state.search;
      console.log(state.search);
    };
    const search_thing = () => {
      state.search = false;
    };
    return {
      search_hover,
      state,
      search_thing,
    };
  },
};
</script>

<style>
.inline {
  margin: 10px;
  margin-top: 30px;
}
.header_bar {
  display: flex;
  background-color: rgb(244, 247, 255);
}
.logo {
  height: 70px;
  width: 140px;
  margin: 10px;
  margin-bottom: 16px;
}
.inputdata {
  margin-top: 20px;
  margin-left: 50px;
  margin-right: 150px;
  height: 50px;
  width: 50%;
}
.btnlogin {
  margin: auto;
}
</style>
