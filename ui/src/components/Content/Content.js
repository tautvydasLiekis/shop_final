import {Switch, Route} from "react-router-dom"
import Login from "../../pages/Login/Login";
import Download from "../../pages/Download/Download";
import About from "../../pages/About/About";
import PrivateRoute from "../PrivateRoute/PrivateRoute";

export default () => (
    <main className="container">
        <Switch>
            <Route exact path="/">
                <About/>
            </Route>
            <PrivateRoute path="/download">
                <Download/>
            </PrivateRoute>
            <PrivateRoute path="/about">
                <About/>
            </PrivateRoute>
            <Route>
                <Login/>
            </Route>
        </Switch>
    </main>
)