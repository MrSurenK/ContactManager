<script setup lang="ts">
import { RouterLink } from 'vue-router'
import { ref } from 'vue'
const username = ref('')
const password = ref('')

const handleSubmit = () => {
  console.log('Form submitted with: ', { username: username.value, password: password.value })
}
</script>
<template>
  <div class="form-container">
    <div class="nav-link>
      <p>Not a member yet?</p>
      <nav>
        <RouterLink to="/register">Sign Up Here</RouterLink>
      </nav>
    </div>
    <form @submit.prevent="handleSubmit">
      <div class="form-elements">
        <label>Username</label>
        <input v-model="username" />
      </div>
      <div class="form-elements">
        <label>Password</label>
        <input type="password" v-model="password" />
      </div>
      <div class="submit-btn">
        <button type="submit">Sign In</button>
      </div>
    </form>
  </div>
</template>

<style>
.nav-link {
  display: flex;
  flex-direction: row;
  gap: 0.5em;
}

.form-elements {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  gap: 0.5em;
}

.submit-btn {
  display: flex;
  justify-content: center;
}

form {
  display: flex;
  flex-direction: column;
  gap: 2em;
}

.form-container {
  display: flex;
  flex-direction: column;
  gap: 2em;
}
</style>
