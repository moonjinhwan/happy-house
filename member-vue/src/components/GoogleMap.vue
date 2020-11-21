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
      <select v-model="selectDong">
        <option v-for="(dong, index) in donglist" :value="dong.dong" v-bind:key="index">
          {{ dong.dong }}
        </option>
      </select>
      <label>
        <gmap-autocomplete @place_changed="setPlace"> </gmap-autocomplete>
        <button @click="addMarker">Add</button>
      </label>
      <br />
    </div>
    <br />
    <gmap-map :center="center" :zoom="12" style="width:100%;  height: 800px;">
      <gmap-marker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center = m.position"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: 'GoogleMap',
  data() {
    return {
      // default to montreal to keep it simple
      // change this to whatever makes sense
      center: { lat: 45.508, lng: -73.587 },
      markers: [],
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
  },
};
</script>
