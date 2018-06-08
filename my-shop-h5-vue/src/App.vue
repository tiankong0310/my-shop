<template>
  <div id="app">
    <router-view/>
    <roll-notice></roll-notice>
    <goods-list></goods-list>
    <br/><br/><br/>
    <tabbar></tabbar>
  </div>
</template>

<script>
import Tabbar from "./components/Tabbar.vue";
import RollNotice from "./components/RollNotice.vue";
import GoodsList from "./components/GoodsList.vue";

export default {
  components: {
    GoodsList,
    RollNotice,
    Tabbar},
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
