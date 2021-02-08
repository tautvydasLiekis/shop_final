import React from 'react';
import {ErrorMessage, Field, Form, Formik} from "formik";
import {register} from "../../api/usersApi";
import {useHistory, useLocation} from "react-router-dom";
import * as Yup from "yup";

const validationSchema = Yup.object().shape({
    username: Yup.string()
        .min(3, 'Username must be longer than 3 symbols')
        .required('Username is required'),
    name: Yup.string()
        .required('Name is required'),
    lastname: Yup.string()
        .required('Lastname is required'),
    password: Yup.string()
        .min(3, "password must be longer than 8 symbols")
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

const Registration = () => {
    const location = useLocation()
    const history = useHistory()

    const postRegistration = (registrationData, {setSubmitting}) => {
        setSubmitting(true)

        const {from} = location.state || {
            from: {
                pathname: '/login'
            }
        }

        register(registrationData)
        history.push(from)
    }

    return (
        <Formik
            initialValues={{
                username: '',
                name: '',
                lastname: '',
                password: ''
            }}
            onSubmit={postRegistration}
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
                        <label htmlFor="name">Name:</label>
                        <Field name="name" id="name" className="form-control"
                               placeholder="Please enter your name"/>
                        <ErrorMessage name="name" component="small" className="form-text text-danger"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="lastname">Last Name:</label>
                        <Field name="lastname" id="lastname" className="form-control"
                               placeholder="Please enter your lastname"/>
                        <ErrorMessage name="lastname" component="small" className="form-text text-danger"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password:</label>
                        <Field name="password" id="password" type="password" className="form-control"
                               placeholder="Please enter your password"/>
                        <ErrorMessage name="password" component="small" className="form-text text-danger"/>
                    </div>
                    <div>
                        <a href="/login">Already have an account? Sign in</a>
                    </div>
                        <button style={style} type="submit">Register</button>
                </Form>
            </>
        </Formik>
    )
}
export default Registration