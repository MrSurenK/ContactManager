<script setup lang="ts">
import LoginForm from '../components/LoginForm.vue'
</script>
<template>
  <div class="login-page">
    <div id="login-card">
      <h1>Login Page</h1>
      <LoginForm />
    </div>
  </div>
</template>
<style scoped>
.login-page {
  min-height: 100vh;
  background-color: yellowgreen;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

#login-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 2em;
  border: solid 2px black;
  padding: 5em 8em 5em 8em;
  box-shadow:
    8px 8px 8px 0 rgba(0, 0, 0, 0.2),
    10px 10px 20px 0 rgba(0, 0, 0, 0.19);
  background-color: rgba(23, 45, 38, 0.2);
}
</style>
