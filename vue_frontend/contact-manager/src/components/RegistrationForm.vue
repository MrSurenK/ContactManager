<script setup lang="ts">
import { RouterLink } from 'vue-router'
import { ref } from 'vue'

const name = ref('')
const email = ref('')
const password = ref('')
const contact = ref('')
</script>

<template>
  <p>Already have an account?</p>
  <nav>
    <RouterLink to="/">Sign in</RouterLink>
  </nav>
  <form @submit.prevent>
    <label>Name</label>
    <input v-model="name" />
    <label>Email</label>
    <input v-model="email" />
    <label>Password</label>
    <input v-model="password" type="password" />
    <label>Contact No</label>
    <input v-model="contact" type="tel" placeholder="+65 88612345" />
    <button type="submit">Register</button>
  </form>
</template>

<style scoped></style>
