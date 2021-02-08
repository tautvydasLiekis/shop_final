import HTTP from './'

export const allKeys = () => HTTP.get(`/licenses`)
export const registerKey = (licenseKey) => HTTP.post(`/licenses/${licenseKey}`)
export const keyStatus = (licenseKey) => HTTP.get(`/licenses/${licenseKey}`)
