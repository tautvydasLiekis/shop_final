import {useEffect, useState} from "react";
import {fetchProducts } from "../../api/productsApi";
import ProductsTable from "./ProductsTable";
import Loader from "../common/Loader";
import {buyProduct} from "../../api/buyApi";

const Products = () => {
	const [products, setProducts] = useState([])
	const [isLoading, setIsLoading] = useState(true)

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
