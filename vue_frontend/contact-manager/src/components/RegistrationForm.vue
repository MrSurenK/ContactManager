<script setup lang="ts">
import { RouterLink } from 'vue-router'
import { ref } from 'vue'

const name = ref('')
const email = ref('')
const password = ref('')
const contact = ref('')

const fileInput = ref<HTMLInputElement | null>(null)
const imageFile = ref<File | null>(null)

//Formdata object to pass to API

//Handle file upload
const handleFileUpload = () => {
  const files = fileInput.value?.files
  if (files && files.length > 0) {
    imageFile.value = files[0]
    console.log(imageFile.value)
  }
}

//Registration API call
const handleSubmit = async () => {
  let formData = new FormData()
  formData.append('email', email.value)
  formData.append('password', password.value)
  formData.append('userName', name.value)
  formData.append('contact', contact.value)
  if (imageFile.value != null) {
    formData.append('imgFile', imageFile.value) //image uploads dont work on backend
  }
  // for (let [key, value] of formData.entries()) {
  //   console.log(`${key}: ${value}`)
  // }
  try {
    const response = await fetch(import.meta.env.VITE_API_URL + '/auth/signup', {
      method: 'POST',
      body: formData
    })
    if (response.ok) {
      const account = await response.json()
      return account
    } else {
      console.error(await response.json())
    }
  } catch (err: any) {
    console.error(`error: ${err.message}`)
  }
}
</script>

<template v-slot="file">
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
        <input v-model="contact" placeholder="+6588612345" />
      </div>
      <div class="form-elements" v-bind:style="{ width: 'inherit' }">
        <label>Display Picture</label>
        <input
          id="upload-btn"
          type="file"
          ref="fileInput"
          @change="handleFileUpload"
          accept=".png, .jpg, .jpeg"
        />
      </div>
      <div class="submit-btn">
        <button @click="handleSubmit" type="submit">Register</button>
      </div>
    </form>
  </div>
</template>

<style scoped>
#upload-btn {
  width: 190px;
}
</style>
