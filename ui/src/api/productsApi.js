import HTTP from './'

export const fetchProducts = () => HTTP.get('/products');

export const addProduct = (product) => HTTP.post('/products', product);
