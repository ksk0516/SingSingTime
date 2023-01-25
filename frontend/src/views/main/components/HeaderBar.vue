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
      
      <v-dialog
        v-model="signup_dialog"
        persistent
        max-width="600px"
      >
        <template v-slot:activator="{ on }">
          <v-btn class="inline"
           variant="text"
            @click="signup_dialog=true"
            v-on="on"
          >
            회원가입
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="text-h5" style="margin:10px;"><b>회원가입</b></span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col  
                  cols="6"
                >
                  <v-text-field
                    v-model="user_id"
                    label="아이디"
                    hint="영문과 숫자를 포함하여 5자~10자 이내로 작성해주세요"
                    :rules="id_rule"
                    required
                  ></v-text-field>
                </v-col>
                <v-btn color="primary" style="margin-top:22px;">중복 확인</v-btn>
                <v-col
                  cols="6" 
                >
                  <v-text-field
                    v-model="user_nickname"
                    label="닉네임"
                    hint="2자~10자 이내로 작성해주세요"
                    :rules="nickname_rule"
                    required
                  ></v-text-field>
                </v-col>
                <v-btn color="primary" style="margin-top:22px;">중복 확인</v-btn>
                <v-col cols="12">
                  <v-text-field
                    v-model="user_password"
                    label="비밀번호*"
                    hint="영문자, 숫자, 특수문자를 조합하여 8자~13자 이내로 작성해주세요"
                    persistent-hint
                    :rules="password_rule"
                    type="password"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    v-model="user_password_confirm"
                    label="비밀번호 확인*"
                    hint="비밀번호를 다시 입력해주세요"
                    persistent-hint
                    :rules="password_confirm_rule"
                    type="password"
                    required
                  ></v-text-field>
                </v-col>
                <!-- <v-col
                  cols="12"
                  sm="6"
                >
                  <v-select
                    :items="['0-17', '18-29', '30-54', '54+']"
                    label="Age*"
                    required
                  ></v-select>
                </v-col> -->
                <v-col
                  cols="6"
                >
                  <v-autocomplete
                    v-model="user_genre"
                    :items="['발라드', '힙합', '댄스', '인디', '트로트', '팝송']"
                    label="좋아하는 장르"
                    multiple
                  ></v-autocomplete>
                </v-col>
              </v-row>
            </v-container>
            <small>SingSingTime🎤</small>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue darken-1"
              text
              @click="signup_dialog = false"
            >
              Close
            </v-btn>
            <v-btn
              color="blue darken-1"
              text
              @click="signup_dialog = false"
            >
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>

      <!--로그인-->
      <v-dialog
        v-model="login_dialog"
        persistent
        max-width="600px"
      >
        <template v-slot:activator="{ on }">
          <v-btn class="inline"
           variant="text"
            @click="login_dialog=true"
            v-on="on"
          >
            로그인
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="text-h5"><b>로그인</b></span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col  
                  cols="6"
                >
                  <v-text-field
                    label="아이디"
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="비밀번호"
                    type="password"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
            <small>SingSingTime🎤</small>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue darken-1"
              text
              @click="login_dialog = false"
            >
              Close
            </v-btn>
            <v-btn
              color="blue darken-1"
              text
              @click="login_dialog = false"
            >
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
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
  data() {
    return {
      signup_dialog: false,
      login_dialog: false,
      user_id:'',
      id_rule:[
        v => !!v || '아이디는 필수 입력사항 입니다',
        v => /^[a-zA-Z]+[0-9]+$/.test(v) || '아이디는 영문과 숫자를 포함해야 합니다.',
        v => !( v.length <= 4 | v.length >= 11) || '아이디는 5자 이상  10자 이하로 작성해 주세요.'
      ],
      user_nickname:'',
      nickname_rule: [
        v => !!v || '닉네임은 필수 입력사항 입니다',
        v => /^[a-zA-Z가-힣]*$/.test(v) || '닉네임은 영문 또는 한글로 입력 가능합니다.',
        v => !( v.length <= 1 | v.length >= 11) || '닉네임은 2자 이상  10자 이하로 작성해 주세요.'
      ],
      user_password: '',
      password_rule: [
        v => !!v || '비밀번호는 필수 입력사항 입니다',
      v => /^[a-zA-Z]+[0-9]+[!@#$%^&+=]+$/.test(v) || '비밀번호는 영문, 숫자, 특수문자를 모두 포함해야 합니다.',
      v => !( v.length <= 7 | v.length >= 14) || '비밀번호는 8자 이상 13자 이하로 작성해 주세요.'
    ],
    user_password_confirm: '',
    password_confirm_rule: [
      v => !!v || '비밀번호 확인은 필수 입력사항 입니다',
      v => v === this.user_password || '비밀번호가 일치하지 않습니다.'
    ],
    user_genre: [],
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
  }
  },
  
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
