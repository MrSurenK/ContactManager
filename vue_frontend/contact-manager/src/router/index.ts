import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/Login.vue'
import RegisterView from '../views/Register.vue'
import DashboardView from '../views/Dashboard.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginView
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterView
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: DashboardView
    }
  ]
})

export default router

// toDo: Set up homepage route and component
// Return to sign in Route
