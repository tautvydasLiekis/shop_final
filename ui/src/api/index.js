import axios from "axios"

const HTTP = axios.create({
    baseURL: '/api'
})

HTTP.interceptors.response.use(response => response, ({response: {status}}) => {
    if (status === 401 || status === 403) {
        window.location.href = "/login"
    }
})

export { HTTP as default }
