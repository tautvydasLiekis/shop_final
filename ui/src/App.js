import {BrowserRouter as Router} from "react-router-dom";
import React from "react";
import Content from "./components/Content/Content";
import Footer from "./components/Footer/Footer";
import Header from "./components/Header/Header";
import store from './store'
import {Provider} from "react-redux";

function App() {
    return (
        <Provider store={store}>
            <Router>
                <Header/>
                <Content/>
                <Footer/>
            </Router>
        </Provider>
    );
}

export default App;
