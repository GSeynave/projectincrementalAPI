import { createApp } from 'vue'
import App from './App.vue'
import HomePageVue from './components/HomePage.vue';
import CombatPage from './components/CombatPage.vue';

const app = createApp(App);
app.component('HomePage', HomePageVue)
app.component('CombatPage', CombatPage)
app.mount('#app')
