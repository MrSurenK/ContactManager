<script setup lang="ts">
import { RouterLink } from 'vue-router'
import { ref } from 'vue'

const name = ref('')
const email = ref('')
const password = ref('')
const contact = ref('')
</script>

<template>
  <div class="form-container">
    <div class="nav-link">
      <p>Already have an account?</p>
      <nav>
        <RouterLink to="/">Sign in</RouterLink>
      </nav>
    </div>
    <form @submit.prevent>
      <div class="form-elements">
        <label>Name</label>
        <input v-model="name" />
      </div>
      <div class="form-elements">
        <label>Email</label>
        <input v-model="email" />
      </div>
      <div class="form-elements">
        <label>Password</label>
        <input v-model="password" type="password" />
      </div>
      <div class="form-elements">
        <label>Contact No</label>
        <input v-model="contact" type="tel" placeholder="+65 88612345" />
      </div>
      <div class="submit-btn">
        <button type="submit">Register</button>
      </div>
    </form>
  </div>
</template>

<style scoped></style>
