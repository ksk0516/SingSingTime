<template>
  <v-template>
    <v-row class="outbox">
      <v-col col="6" md="3" lg="6" class="mypage_box">
        <h2 style="text-align: left"><b>My Page</b></h2>
        <v-row>
          <v-col col="3" class="user_image">
            <img class="user_ex" src="../../assets/images/user_ex.png" />
          </v-col>
          <v-col col="3" class="user_info">
            <v-row>
              <v-col col="1" class="info_category">
                <p class="item_name"><b>닉네임</b></p>
                <p class="item_name"><b>우승횟수</b></p>
                <p class="item_name"><b>랭킹</b></p>
              </v-col>
              <v-col col="2">
                <p class="item_value">장덕김범수</p>
                <p class="item_value">8회</p>
                <p class="item_value">12등</p>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
      <v-col col="6" md="3" lg="6" class="myplaylist_box">
        <v-row>
          <h2 style="text-align: left">
            <b>My Playlist</b><v-icon>mdi-music</v-icon>
          </h2>
          <v-dialog v-model="add_dialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
              <v-btn
                color="aliceblue"
                v-on="on"
                class="plus"
                @click="add_dialog = true"
              >
                +
              </v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="text-h5" style="margin:20px;">Search</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                    <v-card-text>
                      <v-autocomplete
                        placeholder="노래 혹은 가수를 검색해주세요"
                        prepend-icon="mdi-magnify"
                        return-object
                      ></v-autocomplete>
                    </v-card-text>
                    <!-- <v-divider></v-divider> -->
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="add_dialog = false">
                  Close
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-row>
      </v-col>
    </v-row>
    <br />
    <v-divider></v-divider>
    <br />
    <h2 style="text-align: left"><b>My Highlight</b></h2>
  </v-template>
</template>

<script>
export default {
  name: "MypageBox",
  data: () => ({
    add_dialog: false,
  }),
};
</script>

<style>
.outbox {
  margin-top: 20px;
}

.user_image {
  margin-top: 10px;
  padding-right: 0px;
  padding-top: 15px;
}

.user_ex {
  height: 170px;
  background-color: aliceblue;
}

.user_info {
  margin-top: 20px;
  /* line-height: 50px; */
}

.item_name {
  margin: 20px;
  /* font-size: 1rem; */
}

.item_value {
  background-color: aliceblue;
  margin: 20px;
  width: 130px;
  /* border: 10px; */
  border-radius: 30px;
  /* font-size: 0.9rem; */
}
/* .info_category{
  text-align: left;
} */

.plus {
  background-color: aliceblue;
  border-radius: 50px;
  height: 30px;
  margin-top: 3px;
  margin-left: 15px;
}
</style>
