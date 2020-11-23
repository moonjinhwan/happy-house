<template>
  <div>
    <div>
      시도 :
      <select v-model="selecSido" @change="getgugun">
        <option v-for="(sido, index) in sidolist" :value="sido.sido_code" v-bind:key="index">
          {{ sido.sido_name }}
        </option>
      </select>
      구군 :
      <select v-model="selectGugun" @change="getdong">
        <option v-for="(gugun, index) in gugunlist" :value="gugun.gugun_code" v-bind:key="index">
          {{ gugun.gugun_name }}
        </option>
      </select>
      읍면동 :
      <select v-model="selectDong" @change="getInfo">
        <option v-for="(dong, index) in donglist" :value="dong.dong" v-bind:key="index">
          {{ dong.dong }}
        </option>
      </select>
      <!-- <label>
        <gmap-autocomplete @place_changed="setPlace"> </gmap-autocomplete>
        <button @click="addMarker">Add</button>
      </label> -->
      <br />
    </div>
    <br />
    <div class="row">
      <div class="col">
        <!-- 구글맵 출력 -->
        <gmap-map :center="center" :zoom="14" style="width:100%;  height: 500px;">
          <gmap-marker
            :key="index"
            v-for="(m, index) in markers"
            :position="m.position"
            @click="center = m.position"
          ></gmap-marker>
        </gmap-map>
      </div>
      <!-- 아파트 디테일 출력 -->
      <div class="col">
        <apt-detail />
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import AptDetail from './AptDetail.vue';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  components: { AptDetail },
  name: 'GoogleMap',
  data() {
    return {
      // default to montreal to keep it simple
      // change this to whatever makes sense
      center: { lat: 37.5567056, lng: 127.0196111 },
      markers: [
        // {
        //   position: { lat: 37.5567056, lng: 127.0196111 },
        // }, 여기서 getPonsition을 해온다.
        //getPosition에서는 경도 위도만 빼와서 푸시한다.
      ],
      places: [],
      currentPlace: null,
      sidolist: [],
      gugunlist: [],
      donglist: [],
      selecSido: '',
      selectGugun: '',
      selectDong: '',
    };
  },

  created: function() {
    axios
      .get(`${SERVER_URL}/map/sido`)
      .then((response) => {
        this.sidolist = response.data.sidoInfo;
        console.log(this.sidolist);
      })
      .catch(() => {
        alert('시도코드 에러가 발생했습니다.');
      });
  },

  mounted() {
    this.geolocate();
  },

  methods: {
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker() {
      if (this.currentPlace) {
        const marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng(),
        };
        this.markers.push({ position: marker });
        this.places.push(this.currentPlace);
        this.center = marker;
        this.currentPlace = null;
      }
    },
    geolocate: function() {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
    getgugun: function() {
      axios
        .get(`${SERVER_URL}/map/gugun/${this.selecSido}`)
        .then((response) => {
          this.gugunlist = response.data.gugunInfo;
          console.log(this.gugunlist);
        })
        .catch(() => {
          alert('구군코드 에러가 발생했습니다.');
        });
    },
    getdong: function() {
      axios
        .get(`${SERVER_URL}/map/dong/${this.selectGugun}`)
        .then((response) => {
          this.donglist = response.data.dongInfo;

          console.log(this.donglist);
        })
        .catch(() => {
          alert('동코드 에러가 발생했습니다.');
        });
    },
    // saveDongCode: function() {
    //   this.$store.commit('DONGCODE', this.selectDong);
    // },
    // sendDongCode: function() {
    //   const API_KEY =
    //     '9Xo0vlglWcOBGUDxH8PPbuKnlBwbWU6aO7%2Bk3FV4baF9GXok1yxIEF%2BIwr2%2B%2F%2F4oVLT8bekKU%2Bk9ztkJO0wsBw%3D%3D';
    //   const API_URL =
    //     'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?LAWD_CD=' +
    //     this.selectDong +
    //     '&DEAL_YMD=202010&serviceKey=' +
    //     API_KEY;

    //   axios
    //     .get(API_URL)
    //     .then((response) => {
    //       console.log(response); //apt list
    //       this.$store.commit('APTLIST', response.data.response.body.items.item);
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //     });
    // },
    getInfo: function() {
      axios
        .get(`${SERVER_URL}/map/houseinfo/${this.selectDong}`)
        .then((response) => {
          this.$store.commit('APTLIST', response.data.houseInfo);
          //경도 위도 받아서 마커 설정
          this.markers = [];
          this.center = {
            lat: parseFloat(response.data.houseInfo[0].lat),
            lng: parseFloat(response.data.houseInfo[0].lng),
          };
          for (var i = 0; i < response.data.houseInfo.length; i++) {
            this.markers.push({
              position: {
                lat: parseFloat(response.data.houseInfo[i].lat),
                lng: parseFloat(response.data.houseInfo[i].lng),
              },
            });
          }
        })
        .catch(() => {
          alert('아파트 리스트를 받는 중, 에러가 발생했습니다.');
        });
    },
  },
};
</script>
