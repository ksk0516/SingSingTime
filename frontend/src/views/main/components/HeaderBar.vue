<template>
  <v-row style="margin-top: 10px; padding: 10px">
    <img class="logo" src="../../../assets/images/logo.png" />
    <input class="inputdata" placeholder="입력하세요" />
    <v-btn class="btnlogin">회원가입</v-btn>
    <v-btn class="btnlogin">로그인</v-btn>
  </v-row>
</template>

<script>
export default {
  name: "HeaderBar",
};
</script>

<style>
.logo {
  height: 100px;
  margin-left: 55px;
}
.inputdata {
  margin-top: 20px;
  margin-left: 50px;
  margin-right: 150px;
  height: 50px;
  width: 50%;
}
.btnlogin{
  margin:auto
}
</style>
