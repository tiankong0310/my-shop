// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import YDUI from 'vue-ydui';
import 'vue-ydui/dist/ydui.px.css';
import {ActionSheet} from 'vue-ydui/dist/lib.px/actionsheet'

Vue.config.productionTip = false

Vue.component(ActionSheet.name, ActionSheet);
Vue.use(YDUI);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
