import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {fetchProducts } from "../../api/productsApi";
import ProductsTable from "./ProductsTable";
import Button from "@material-ui/core/Button";
import Loader from "../common/Loader";
import useUser from "../../hooks/useUser";

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

	return (
		<>
			{
				isLoading ? (<Loader />) :
					<ProductsTable
						products={products}
					/>

			}
			{
				user?.roles.includes('ADMIN') && (
					<Link to="/products/new">
						<Button type="button" variant="contained" style={style}>New Product</Button>
					</Link>
				)
			}
		</>
	)
}

Products.displayName = "Products"

export default Products
