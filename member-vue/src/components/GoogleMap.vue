<template>
  <div>
    <div class="row">
      <div class="col-sm-4 littleNav">
        <div style=" display: inline-block;">
          <h3>위치기반 검색 시스템</h3>
          <hr />

          <h5 style="float: left; padding-top:2%">시/도 :</h5>
          <b-form-select v-model="selecSido" @change="getgugun" title="시/도를 골라주세요!!">
            <template #first>
              <b-form-select-option :value="null" disabled
                >시/도 를 선택해주세요</b-form-select-option
              >
            </template>
            <option v-for="(sido, index) in sidolist" :value="sido.sido_code" v-bind:key="index">
              {{ sido.sido_name }}
            </option>
          </b-form-select>
          <h5 style="float: left; padding-top:2%">구/군 :</h5>
          <b-form-select v-model="selectGugun" @change="getdong" title="구/군을 골라주세요!!">
            <template #first>
              <b-form-select-option :value="null" disabled
                >구/군 을 선택해주세요</b-form-select-option
              >
            </template>
            <b-form-select-option
              v-for="(gugun, index) in gugunlist"
              :value="gugun.gugun_code"
              v-bind:key="index"
            >
              {{ gugun.gugun_name }}
            </b-form-select-option>
          </b-form-select>

          <h5 style="float: left; padding-top:2%">읍/면/동 :</h5>
          <b-form-select
            v-model="selectDong"
            @change="[getInfo(), getPlace()]"
            title="읍/면/동을 골라주세요!!"
          >
            <template #first>
              <b-form-select-option :value="null" disabled
                >읍/면/동 을 선택해주세요</b-form-select-option
              >
            </template>
            <option v-for="(dong, index) in donglist" :value="dong.dong" v-bind:key="index">
              {{ dong.dong }}
            </option>
          </b-form-select>

          <b-form-checkbox
            id="checkbox-1"
            size="lg"
            style="float: left; padding-top:2%"
            v-model="status"
            value="clicked"
            unchecked-value="unclicked"
            @change="select"
          >
            <strong>상권정보 표시</strong>
          </b-form-checkbox>
        </div>
      </div>
      <div class="col-sm-8"><apt-list /></div>
    </div>

    <!-- 구글맵 출력 -->
    <div style="padding-left: 2%; padding-right: 2%">
      <gmap-map :center="center" :zoom="14" style="width:100%;  height: 700px;">
        <gmap-marker
          :key="index"
          v-for="(m, index) in markers"
          :position="m.position"
          @click="openWindow(m)"
          :icon="m.icon"
        ></gmap-marker>
        <gmap-info-window
          @closeclick="window_open = false"
          :opened="window_open"
          :position="infowindow"
          :options="{
            pixelOffset: {
              width: 0,
              height: -35,
            },
          }"
        >
          {{ selectMsg }}
        </gmap-info-window>
      </gmap-map>
    </div>
    <!-- 아파트 디테일 출력 -->
    <div class="row">
      <div class="col apttable">
        <h2>실거래가 정보</h2>
        <hr />
        <apt-detail />
      </div>
      <div class="col apttable">
        <h2>상권 정보</h2>
        <hr />
        <div>
          <b-table
            hover
            sticky-header
            :items="placelist"
            head-variant="light"
            :fields="fields"
          ></b-table>
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
import AptList from '../components/AptList';

const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  components: { AptDetail, AptList },
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
      selecSido: null,
      selectGugun: null,
      selectDong: null,
      fields: [
        { key: 'placeName', label: '음식점명' },
        { key: 'dongname', label: '법정동' },
        { key: 'address', label: '주소' },
      ],
      info_marker: null,
      infowindow: { lat: '', lng: '' },
      window_open: false,
      selectMsg: '',
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
    //작은 윈도우 오픈
    openWindow(m) {
      //alert('눌렀다');
      console.log(m);
      this.infowindow.lat = m.position.lat;
      this.infowindow.lng = m.position.lng;
      this.window_open = true;
      this.selectMsg = m.msg;
    },
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
          console.log('하우스인포');
          console.log(response.data.houseInfo);
          this.$store.commit('APTLIST', response.data.houseInfo);
          //경도 위도 받아서 마커 설정
          this.markers.splice(0);
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
              msg: response.data.houseInfo[i].aptName,
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
          console.log('상권정보');
          console.log(this.placelist);
          this.markers.push({
            position: {
              lat: parseFloat(this.placelist[i].lat),
              lng: parseFloat(this.placelist[i].lng),
            },
            icon: iconType[this.placelist[i].type],
            msg: this.placelist[i].placeName,
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
            msg: this.$store.state.aptList[i].aptName,
          });
        }
      }
    },
  },
};
</script>

<style>
.apttable {
  padding-top: 3%;
  padding-right: 5%;
  padding-left: 5%;
  padding-bottom: 5%;
}
.littleNav {
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 1%;
  padding-bottom: 2%;
}
</style>
