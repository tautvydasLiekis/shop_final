import {Form, Formik, Field, ErrorMessage} from "formik"
import { useHistory } from "react-router-dom";
import * as Yup from "yup"
import { addProduct } from "../../api/productsApi";

const validationSchema = Yup.object().shape({
    name: Yup.string()
        .max(20, 'Name must be shorter than 25')
        .required(),
    price: Yup.number()
        .positive()
        .required()
        .test("is-price", "Price should be valid", (value) => {
            if (value !== '') {
                return (value + "").match(/^\d+(\.\d{1,2})?$/)
            }
            return true
        })
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

export default () => {
    const history = useHistory();

    const handleOnSubmit = (formValues, formikHelpers) => {
        formikHelpers.setSubmitting(true);
        addProduct(formValues)
            .then(() => {
                history.push("/products");
            })
            .finally(() => {
                formikHelpers.setSubmitting(false);
            })
    }

    return (
        <Formik
            initialValues={{
                name: '',
                price: '',
                description: ''
            }}
            onSubmit={handleOnSubmit}
            validationSchema={validationSchema}>
                <>

                    <Form className="mx-4">
                        <div className="form-group">
                            <label htmlFor="name">Name:</label>
                            <Field name="name" id="name" className="form-control" placeholder="Please enter product name" />
                            <ErrorMessage name="name" component="small" className="form-text text-danger"/>
                        </div>

                        <div className="form-group">
                            <label htmlFor="price">Price:</label>
                            <Field name="price" id="price" className="form-control" placeholder="Please enter product price" />
                            <ErrorMessage name="price" component="small" className="form-text text-danger"/>
                        </div>

                        <div className="form-group">
                            <label htmlFor="description">Description:</label>
                            <Field name="description" id="description" className="form-control"
                                   placeholder="Please enter product description" component="textarea"
                                   rows="10"/>
                            <ErrorMessage name="description" component="small" className="form-text text-danger"/>
                        </div>

                        <button type="submit" style={style}>Submit</button>
                    </Form>
                </>
        </Formik>
    )
}