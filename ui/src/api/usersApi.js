import HTTP from './'

export const login = (userLogin) => HTTP.post('/login', userLogin)
export const register = (userRegister) => HTTP.post('/register', userRegister)
