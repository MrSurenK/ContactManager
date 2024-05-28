<script setup lang="ts">
import LoginForm from '../components/LoginForm.vue'
</script>
<template>
  <div class="login-page">
    <h1>Login Page</h1>
    <LoginForm />
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
  gap: 2em;
}
</style>
