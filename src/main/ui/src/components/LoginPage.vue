<template>
  <h1>Login page</h1>
  <div v-if="hasAccount">
    <form method="post" @submit.prevent="onLogin">
      <label for="username">username</label>
      <input type="text" id="username" v-model="username" />
      <label for="password">Password</label>
      <input type="password" id="password" v-model="password" />
      <input class="button" type="submit" value="Logging in" />
    </form>
    <input
      class="button"
      type="button"
      @click="isRegistered()"
      value="Create an account"
    />
  </div>
  <div v-else>
    <form method="post" @submit.prevent="onRegister">
      <label for="username">Username</label>
      <input type="text" id="username" v-model="username" />
      <label for="password">Password</label>
      <input type="password" id="password" v-model="password" />
      <label>Email</label>
      <input type="email" id="email" v-model="email" />
      <input class="button" type="submit" value="Register" />
    </form>
    <input
      class="button"
      type="button"
      @click="isRegistered()"
      value="Log in"
    />
  </div>

  <div v-if="this.error" class="error">{{ this.error.message }}</div>
</template>

<script>
import LoginService from "../services/loginService";

export default {
  data() {
    return {
      hasAccount: true,
      username: "",
      password: "",
      email: "",
      error: {},
    };
  },
  props: ["isLogged"],
  emits: ["update:isLogged"],
  methods: {
    onRegister() {
      let registerForm = {
        username: this.username,
        password: this.password,
        email: this.email,
      };
      LoginService.register(registerForm)
        .then((res) => {
          console.log(res);
          localStorage.authToken = res.token;
          localStorage.username = this.username;
          location.reload();
        })
        .catch((err) => {
          this.error = err.data;
        });
    },
    onLogin() {
      LoginService.authenticate(this.username, this.password)
        .then((response) => {
          localStorage.authToken = response.token;
          localStorage.username = this.username;
          location.reload();
        })
        .catch((err) => {
          this.error = err.data;
        });
    },
    isRegistered() {
      this.hasAccount = !this.hasAccount;
    },
  },
};
</script>

<style>
.error {
  color: red;
}
</style>
