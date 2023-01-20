<template>
  <v-card class="sidebar">
    <v-layout>
      <v-navigation-drawer permanent>
        <v-list color="transparent">
          <router-link to="/">
            <v-list-item title="Home"></v-list-item>
          </router-link>

          <router-link to="/rank">
            <v-list-item title="rank"></v-list-item>
          </router-link>

          <router-link to="/community">
            <v-list-item title="community"></v-list-item>
          </router-link>

          <router-link to="/conferences">
            <v-list-item title="conferences"></v-list-item>
          </router-link>

          <router-link to="/mypage">
            <v-list-item title="mypage"></v-list-item>
          </router-link>
        </v-list>

        <template v-slot:append>
          <div class="pa-2">
            <v-btn block> Logout </v-btn>
          </div>
        </template>
      </v-navigation-drawer>
      <v-main style="height: 80vh">
         <router-view /> <!--메인 화면 왜인지는 모름 -->
      </v-main>
    </v-layout>
  </v-card>
</template>

<script>
export default {
  name: "SideBar",
};
</script>

<style>
.sidebar{
  height: 80vh;
}
</style>
