import {useEffect, useState} from "react";
import {fetchProducts } from "../../api/productsApi";
import ProductsTable from "./ProductsTable";
import Loader from "../common/Loader";
import useUser from "../../hooks/useUser";
import {buyProduct} from "../../api/buyApi";

const style = {
	background: 'linear-gradient(45deg, #484848 30%, #FF8E53 90%)',
	borderRadius: 3,
	border: 0,
	color: 'white',
	height: 48,
	padding: '0 30px',
	boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
};

const Products = () => {
	const [products, setProducts] = useState([])
	const [isLoading, setIsLoading] = useState(true)
	const user = useUser()

	useEffect(() => {
		loadAllProducts();
	}, [])

	const loadAllProducts = () => {
		setIsLoading(true);
		fetchProducts()
			.then(response => {
				setProducts(response.data)
			})
			.finally(() => {
				setIsLoading(false);
			})
	}
	const handleBuyClick = (name) => {
		setIsLoading(true);
		buyProduct(name)
			.then(() => {
				loadAllProducts();
			})
			.finally(() => {
				setIsLoading(false);
			})
	}

	return (
		<>
			{
				isLoading ? (<Loader />) :
					<ProductsTable
						products={products}
						handleBuyClick={handleBuyClick}
					/>
			}
		</>
	)
}

Products.displayName = "Products"

export default Products
