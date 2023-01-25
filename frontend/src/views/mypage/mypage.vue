<template>
  <v-template>
    <v-row class="outbox">
      <v-col col="6" class="mypage_box">
        <h2 style="text-align:left;"><b>My Page</b></h2>
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
                <p class="item_value">광주김범수</p>
                <p class="item_value">8회</p>
                <p class="item_value">12등</p>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
      <v-col col="6" class="myplaylist_box">
        <v-row>
          <h2 style="text-align:left;"><b>My Playlist</b><v-icon>mdi-music</v-icon></h2>
          <v-dialog
            v-model="add_dialog"
            persistent
            max-width="600px"
          >
            <template v-slot:activator="{ on}">
              <v-btn
                color="aliceblue"
                v-on="on"
                class="plus"
                @click="add_dialog=true"
              >
                +
              </v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="text-h5">User Profile</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        label="Legal first name*"
                        required
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        label="Legal middle name"
                        hint="example of helper text only on focus"
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                      md="4"
                    >
                      <v-text-field
                        label="Legal last name*"
                        hint="example of persistent helper text"
                        persistent-hint
                        required
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12">
                      <v-text-field
                        label="Email*"
                        required
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12">
                      <v-text-field
                        label="Password*"
                        type="password"
                        required
                      ></v-text-field>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                    >
                      <v-select
                        :items="['0-17', '18-29', '30-54', '54+']"
                        label="Age*"
                        required
                      ></v-select>
                    </v-col>
                    <v-col
                      cols="12"
                      sm="6"
                    >
                      <v-autocomplete
                        :items="['Skiing', 'Ice hockey', 'Soccer', 'Basketball', 'Hockey', 'Reading', 'Writing', 'Coding', 'Basejump']"
                        label="Interests"
                        multiple
                      ></v-autocomplete>
                    </v-col>
                  </v-row>
                </v-container>
                <small>*indicates required field</small>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="blue darken-1"
                  text
                  @click="add_dialog = false"
                >
                  Close
                </v-btn>
                <v-btn
                  color="blue darken-1"
                  text
                  @click="add_dialog = false"
                >
                  Save
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-row>
      </v-col>
    </v-row>
    <br>
    <hr>
    <br>
    <h2 style="text-align:left;"><b>My Highlight</b></h2>
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

.user_image{
  margin-top: 10px;
  padding-right: 0px;
  padding-top: 15px;
}

.user_ex{
  height: 170px;
  background-color:aliceblue
}

.user_info{
  margin-top: 20px;
  /* line-height: 50px; */
}

.item_name{
  margin:20px;
  /* font-size: 1rem; */
}

.item_value{
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

.plus{
  background-color: aliceblue;
  border-radius: 50px;;
  height: 30px;
  margin-top: 3px;
  margin-left: 15px;
}
</style>
