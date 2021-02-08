import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {fetchProducts } from "../../api/productsApi";
import ProductsTable from "./ProductsTable";
import Button from "@material-ui/core/Button";
import Loader from "../common/Loader";
import useUser from "../../hooks/useUser";

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

	return (
		<>
			{
				user?.roles.includes('ADMIN') && (
					<Link to="/products/new">
						<Button type="button" variant="contained" color="primary">New Product</Button>
					</Link>
				)
			}
			{
				isLoading ? (<Loader />) :
					<ProductsTable
						products={products}
					/>

			}
		</>
	)
}

Products.displayName = "Products"

export default Products
