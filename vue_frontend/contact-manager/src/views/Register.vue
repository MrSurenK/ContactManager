<script setup lang="ts">
import RegistrationForm from '../components/RegistrationForm.vue'
</script>

<template>
  <div class="register-page">
    <div id="register-card">
      <h1>Registration Page</h1>
      <RegistrationForm />
    </div>
  </div>
</template>

<style scoped>
.register-page {
  min-height: 100vh;
  background-color: #89cff0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

#register-card {
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
