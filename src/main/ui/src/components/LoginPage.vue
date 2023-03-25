<template>

    <h1> Login page</h1>



    <form method="post" @submit.prevent="onRegister">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="username">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="password">
        <label>Email</label>
        <input type="email" id="email" v-model="email">
        <input class="button" type="submit" value="Register">
    </form>

</template>

<script>

    import LoginService from "../services/loginService"

    export default {
        data() {
            return {
                username: "",
                password: "",
                email: ""
            }
        },
        methods: {
            onRegister() {
                
                let registerForm = {username: this.username, password: this.password, email: this.email};
                console.log(registerForm);
                LoginService.register(registerForm).then((response) => {
                    console.log(response);
                    localStorage.authToken = response;
                    localStorage.username = this.username;
                    window.location.reload();
                });
            }
        }
    }
</script>

<style></style>
