<template>
  <h2><b>Community</b></h2>
  <v-row justify="end" style="margin-right: 60px">
    <div style="width: 400px">
      <v-text-field
        hide-details
        placeholder="검색"
        single-line
        v-model="state.searchkeyword"
        @keydown.enter="community_search_thing"
        class="commu_search"
      ></v-text-field>
    </div>
    <v-btn
      class="inline"
      variant="text"
      icon="mdi-magnify"
      style="margin-top: 20px"
      @click="searchstart()"
    ></v-btn>

    <v-dialog v-model="content_dialog" max-width="600px">
      <template v-slot:activator="{ on }">
        <v-btn
          class="inline upload"
          variant="text"
          @click="content_dialog = true"
          v-on="on"
          v-show="state.token"
        >
          업로드
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <img
            class="logo"
            src="../../assets/images/login_logo.png"
            style="width: 220px; margin-left: 180px"
          />
          <v-spacer></v-spacer>
          <span class="text-h5" style="margin-left: 22px"
            ><b>게시글 업로드</b></span
          >
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <label for="title">제목</label>
                <textarea
                  name="title"
                  style="width: 100%"
                  v-model="state.form.title"
                ></textarea>
              </v-col>
              <v-col cols="12">
                <label for="context">내용</label>
                <textarea
                  name="context"
                  required
                  style="height: 200px; width: 100%"
                  v-model="state.form.context"
                ></textarea>
              </v-col>
              <div class="custom-file">
                <v-file-input
                  id="customFile"
                  @change="changeFile"
                  label="비디오를 업로드 하세요."
                  style="width: 530px; padding-left: 10px"
                />
                <label class="custom-file-label" for="customFile">{{
                  state.form.video.name
                }}</label>
              </div>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="content_dialog = false">
            Close
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="(content_dialog = false), submit()"
          >
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>

  <v-btn @click="uploadVideo">비디오 ㅁ디테일</v-btn>
  <v-btn @click="procy">비디오 디테일</v-btn>
  <ul class="infinite-list" >
    <li
      v-for="i in state.content_list"
      class="infinite-list-item"
      @click="clickContent(i)"
      :key="i"
    >
      <ContentBox />
    </li>
    <div class="text-center">
      <v-pagination
        v-model="state.page"
        :length="max_page"
        @click="consolemethod(state.page)"
      ></v-pagination>
    </div>
  </ul>
</template>

<script>
import ContentBox from "./component/content.vue";
import { reactive, ref, toRaw } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

export default {
  name: "CommunityBox",
  components: {
    ContentBox,
  },
  data() {
    return {
      page: 1,
      video_list: [],
      content_dialog: false,
      video: null,
      token: null,
    };
  },
  setup() {
    const router = useRouter();
    // const store = createStore();
    const state = reactive({
      count: 54,
      page: 1,
      searchkeyword:"",
      community_search: false,
      token: localStorage.getItem("jwt"),
      form: {
        id: "",
        title: "",
        context: "",
        video: "",
      },
      content_list : [],
      // bundle_content : [],
    });

    const max_page = parseInt(state.count / 12) + 1;

    const video_list = [];
    for (let i = 1 + (state.page - 1) * 12; i <= state.page * 12; i++) {
      video_list.push(i);
    }

    const load = function () {
      state.count += 4;
    };

    const clickContent = function (id) {
      router.push({
        name: "ContentsBox",
        params: { Id: id },
      });
    };

    const community_search_thing = () => {
      state.community_search = false;
    };
    const uploadVideo = function () {
      axios({
        method: "get",
        url: "http://localhost:8080/api/v1/videos",
      })
      .then((res) => {
        alert("비디오 디테일!");
        // console.log(res)
        state.content_list = res.data
        // const count = res.data.length;
        for(let i=0; i<res.data.lenth; i++) {
          const content = reactive({
            title: res.data[i].title,
            id: res.data[i].id,
            description: res.data[i].description,
          })
          state.content_list.push(content)
          // console.log(content)
        }
        console.log(state.content_list);
      })
      .catch((err) => {
        console.log("비디오 디테일 실패");
        console.log(state.form.video);
        // console.log(state.form.video.proxy);
        console.log(err);
      });
    };
    const procy = function(){
      const bundle_content=toRaw(state.content_list)
      console.log(bundle_content)
      // const test = [bundle_content];
      const test2 = [];
      for (let i = 0; i< bundle_content.length; i++) {
        test2.push(bundle_content[i].id);
      }
      console.log(typeof test2)
      return test2;
    };

    const searchfinish = false;
    const searchstart = function () {
      // 검색버튼 눌렀을때 실행
      if (state.searchkeyword == "") {
        alert("키워드가 없습니다!");
      } else {
        console.log(state.searchkeyword)
        axios({
          method: "POST",
          url: `http://localhost:8080/api/v1/videos/search/${state.searchkeyword}`,
        })
          .then((res) => {
            console.log(res);
            contentlist = res.data;
            searchcnt = contentlist[Object.keys(contentlist).length - 1].cnt;
            contentlist.pop();
            alert("검색완료!");
            searchfinish = true;
            state.searchkeyword = "";
          })
          .catch((err) => {
            alert(err);
          });
      }
    };
    return {
      state,
      load,
      clickContent,
      max_page,
      video_list,
      community_search_thing,
      uploadVideo,
      searchstart,
      searchfinish,
      procy,
    };
  },
  methods: {
    consolemethod(value) {
      this.video_list = [];
      for (let i = 1 + (value - 1) * 12; i <= value * 12; i++) {
        if (i > 54) {
          return video_list;
        }
        this.video_list.push(i);
      }
      // this.$router.go()
      return this.video_list;
    },
    async submit() {
      this.token = localStorage.getItem("jwt")
      const formData = new FormData();
      formData.append("video", this.video.target.files[0]);
      formData.append("title", this.state.form.title);
      formData.append("context", this.state.form.context);

      axios({
        method: "post",
        url: "http://localhost:8080/api/v1/videos",
        data: formData,
        headers: {
          "Content-Type": "multipart/form-data",
          Authorization: `Bearer ${this.token}`
        },
      })
        .then((res) => {
          alert("비디오 업로드 성공!");
          console.log(res);
        })
        .catch((err) => {
          console.log("비디오 업로드 실패");
          // console.log(state.form.video);
          console.log(this.video.target.files[0]);
          console.log(err);
        });
    },
    changeFile(file) {
      this.video = file;
    },
  },
};
</script>

<style scoped>
.infinite-list {
  padding-left: 0;
  max-height: calc(100% - 35px);
}

@media (min-width: 701px) and (max-width: 1269px) {
  .infinite-list {
    min-width: 700px;
  }
}

@media (min-width: 1270px) {
  .infinite-list {
    min-width: 1021px;
  }
}

.infinite-list .infinite-list-item {
  min-width: 335px;
  max-width: 25%;
  display: inline-block;
  cursor: pointer;
}

.upload {
  border: 1px solid rgb(186, 205, 255);
  background-color: aliceblue;
  margin-top: 25px;
}

textarea {
  border: 2px solid black;
  outline: 2px solid rgb(219, 228, 230);
  border-radius: 6px;
}

.commu_search {
  margin-top: 15px;
  margin-bottom: 10px;
}
</style>
