import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'
const RememberToken = 'Remember-Token'

export function getToken (): string {
  return Cookies.get(TokenKey)
}

export function setToken (token): void {
  return Cookies.set(TokenKey, token, { expires: 7 })
}

export function removeToken (): void {
  return Cookies.remove(TokenKey)
}

export function isRememberToken (): string {
  return Cookies.get(RememberToken)
}

export function rememberToken (): void {
  return Cookies.set(RememberToken, 'true', { expires: 7 })
}

export function forgotToken (): void {
  return Cookies.remove('Remember-Token')
}

/**
 * clear cookies
 */
export function clearCookies (): void {
  let cookies = Cookies.get()
  for (let key in cookies) {
    if (cookies.hasOwnProperty(key)) {
      Cookies.remove(key)
    }
  }
}
