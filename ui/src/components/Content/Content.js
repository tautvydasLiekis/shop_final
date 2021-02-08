import {Switch, Route} from "react-router-dom"
import Login from "../../pages/Login/Login"
import Register from "../../pages/Registration/Registration"
import PrivateRoute from "../PrivateRoute/PrivateRoute"
import About from "../../pages/About/About"
import Products from "../../pages/Products/Products";
import ProductForm from "../../pages/ProductForm/ProductForm";

export default () => (
	<main className="container">
		<Switch>
			<PrivateRoute exact path="/">
				<About/>
			</PrivateRoute>
			<PrivateRoute path="/products/new" roles={['ADMIN']}>
				<ProductForm/>
			</PrivateRoute>
			<PrivateRoute path="/products">
				<Products/>
			</PrivateRoute>
			<PrivateRoute path="/about">
				<About/>
			</PrivateRoute>
			<Route path="/login">
				<Login/>
			</Route>
			<Route path="/register">
				<Register/>
			</Route>
		</Switch>
	</main>
)
