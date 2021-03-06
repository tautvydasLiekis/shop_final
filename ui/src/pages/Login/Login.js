import React from 'react';
import {useHistory, useLocation} from "react-router-dom";
import {useDispatch} from "react-redux";
import {setJwt, setUserData} from "../../store/slices/userSlice";
import {login} from "../../api/usersApi";
import {Form, Formik, Field, ErrorMessage} from "formik"
import * as Yup from "yup";

const validationSchema = Yup.object().shape({
    username: Yup.string()
        .required('Username is required'),
    password: Yup.string()
        .required('Lastname is required'),
})

const style = {
    background: 'linear-gradient(45deg, #484848 30%, #FF8E53 90%)',
    borderRadius: 3,
    border: 0,
    color: 'white',
    height: 48,
    padding: '0 30px',
    boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
};


const Login = () => {
    const history = useHistory()
    const location = useLocation()
    const dispatch = useDispatch()

    const postLogin = (loginData, {setSubmitting}) => {
        setSubmitting(true)

        login(loginData)
            .then(({data, headers: {authorization}}) => {
                dispatch(setUserData(data))
                dispatch(setJwt(authorization))

                const {from} = location.state || {
                    from: {
                        pathname: '/'
                    }
                }

                history.push(from)
            })
            .finally(() => setSubmitting(false))
    }

    return (
        <Formik
            initialValues={{
                username: '',
                password: ''
            }}
            onSubmit={postLogin}
            validationSchema={validationSchema}
        >
            <>
                <Form>
                    <div className="form-group">
                        <label htmlFor="username">Username:</label>
                        <Field name="username" id="username" className="form-control"
                               placeholder="Please enter your username"/>
                        <ErrorMessage name="username" component="small" className="form-text text-danger"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password:</label>
                        <Field name="password" id="password" type="password" className="form-control"
                               placeholder="Please enter your password"/>
                        <ErrorMessage name="password" component="small" className="form-text text-danger"/>
                    </div>
                    <div>
                        <a href="/register">Don't have an account? Sign up</a>
                    </div>
                        <button style={style} type="submit" >Login</button>
                </Form>
            </>
        </Formik>
    )
}
export default Login