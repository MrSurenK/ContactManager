import { describe, expect, test, vi } from 'vitest'
import { mount } from '@vue/test-utils'
import LoginForm from '@/components/LoginForm.vue'

// Mock vue-router
vi.mock('vue-router', () => ({
  useRouter: () => ({
    push: vi.fn()
  }),
  RouterLink: {
    name: 'RouterLink',
    props: ['to'],
    setup(props, { slots }) {
      return () => (slots.default ? slots.default() : null)
    }
  }
}))

describe('Login Form Component', () => {
  test('form fields render on mount', async () => {
    const wrapper = mount(LoginForm)

    const signUpLink = wrapper.findComponent({ name: 'RouterLink' })
    expect(signUpLink.exists()).toBe(true)
    expect(signUpLink.props('to')).toBe('/register')
    expect(signUpLink.text()).toBe('Sign Up Here')

    const userNameInput = wrapper.find('input[type="text"]')
    expect(userNameInput.exists()).toBe(true)

    const passwordInput = wrapper.find('input[type="password"]')
    expect(passwordInput.exists()).toBe(true)

    const submitButton = wrapper.find('button[type="submit"]')
    expect(submitButton.exists()).toBe(true)
  })
})
