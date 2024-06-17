<script setup lang="ts">
import { RouterLink, useRouter } from 'vue-router'
import { ref } from 'vue'
const username = ref('')
const password = ref('')
const router = useRouter()

//Call login API and if successful log in else return error
const handleSubmit = async () => {
  try {
    // console.log('Form submitted with: ', { username: username.value, password: password.value })
    const response = await fetch(import.meta.env.VITE_API_URL + '/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        email: username.value,
        password: password.value
      })
    })
    if (response.ok) {
      const data = await response.json()
      localStorage.setItem('accessToken', data.accessToken)
      router.push({ name: 'dashboard' })
      return console.log(data)
    } else {
      console.error(await response.json())
    }
  } catch (error: any) {
    console.error(`Error: ${error.message}`)
  }
}
</script>
<template>
  <div class="form-container">
    <div class="nav-link">
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
