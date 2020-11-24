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
      <select v-model="selectDong" @change="[getInfo(), getPlace()]">
        <option v-for="(dong, index) in donglist" :value="dong.dong" v-bind:key="index">
          {{ dong.dong }}
        </option>
      </select>
      <br />
      <b-form-checkbox
        id="checkbox-1"
        v-model="status"
        value="clicked"
        unchecked-value="unclicked"
        @change="select"
      >
        상권정보 표시
      </b-form-checkbox>
    </div>
    <br />

    <!-- 구글맵 출력 -->
    <div>
      <gmap-map :center="center" :zoom="14" style="width:100%;  height: 500px;">
        <gmap-marker
          :key="index"
          v-for="(m, index) in markers"
          :position="m.position"
          @click="center = m.position"
          :icon="m.icon"
        ></gmap-marker>
      </gmap-map>
    </div>
    <!-- 아파트 디테일 출력 -->
    <div class="row">
      <div class="col">
        <h1>실거래가 정보</h1>
        <apt-detail />
      </div>
      <div class="col">
        <h1>상권 정보</h1>
        <div>
          <b-table hover sticky-header :items="placelist" head-variant="light"></b-table>
        </div>
        <!-- <place-detail /> -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import AptDetail from './AptDetail.vue';
import { mapGetters } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  components: { AptDetail },
  name: 'GoogleMap',
  data() {
    return {
      status: '',
      selected: '',
      // default to montreal to keep it simple
      // change this to whatever makes sense

      center: { lat: 37.5567056, lng: 127.0196111 },
      markers: [],
      places: [],
      currentPlace: null,
      sidolist: [],
      gugunlist: [],
      donglist: [],
      placelist: [],
      selecSido: '',
      selectGugun: '',
      selectDong: '',
    };
  },
  computed: {
    ...mapGetters(['getAptList']),
  },
  created: function() {
    //초기화하기
    this.$store.commit('APTLIST', []);
    this.$store.commit('APTDETAIL', []);
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
    getInfo: function() {
      axios
        .get(`${SERVER_URL}/map/houseinfo/${this.selectDong}`)
        .then((response) => {
          this.$store.commit('APTLIST', response.data.houseInfo);
          //경도 위도 받아서 마커 설정

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
              icon: 'house.ico',
            });
          }
        })
        .catch(() => {
          alert('아파트 리스트를 받는 중, 에러가 발생했습니다.');
        });
    },
    getPlace: function() {
      axios
        .post(`${SERVER_URL}/map/place`, {
          dongname: this.selectDong,
        })
        .then((response) => {
          console.log(response.data);
          this.placelist = response.data.placeInfo;
        })
        .catch(() => {
          alert('상권정보를 받는 중, 에러가 발생했습니다.');
        });
    },
    select: function() {
      let iconType = ['', 'coffee.ico', 'chicken.ico'];
      if (this.status == 'clicked') {
        for (let i = 0; i < this.placelist.length; i++) {
          console.log(iconType[this.placelist[i].type]);
          this.markers.push({
            position: {
              lat: parseFloat(this.placelist[i].lat),
              lng: parseFloat(this.placelist[i].lng),
            },
            icon: iconType[this.placelist[i].type],
          });
        }
      } else {
        this.markers.splice(0);
        for (let i = 0; i < this.$store.state.aptList.length; i++) {
          this.markers.push({
            position: {
              lat: parseFloat(this.$store.state.aptList[i].lat),
              lng: parseFloat(this.$store.state.aptList[i].lng),
            },
            icon: 'house.ico',
          });
        }
      }
    },
  },
};
</script>
