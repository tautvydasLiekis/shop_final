import {Switch, Route} from "react-router-dom"
import Login from "../../pages/Login/Login"
import Register from "../../pages/Registration/Registration"
import PrivateRoute from "../PrivateRoute/PrivateRoute"
import About from "../../pages/About/About"

export default () => (
	<main className="container">
		<Switch>
			<PrivateRoute exact path="/">
				<About/>
			</PrivateRoute>
			<PrivateRoute path="/products">

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
