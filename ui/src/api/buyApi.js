import HTTP from './'

export const buyProduct = (prodName,user) => HTTP.post(`/buy/${prodName}${user}`)