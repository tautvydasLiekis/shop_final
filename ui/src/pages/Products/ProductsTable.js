import PropTypes from 'prop-types';
import Table from "@material-ui/core/Table";
import React from "react";
import TableCell from "@material-ui/core/TableCell";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import TableContainer from "@material-ui/core/TableContainer";
import {connect} from "react-redux";
import {Link} from "react-router-dom";
import Button from "@material-ui/core/Button";


function ProductTable({products, buyProduct}) {

    const style_1 = {
        background: 'linear-gradient(45deg, #484848 30%, #FF8E53 90%)',
        color: 'white'
    }
    const style_2 = {
        background: 'linear-gradient(45deg, #FF8E53 30%, #484848 90%)'
    }
    const button_style = {
        background: 'linear-gradient(45deg, #484848 30%, #FF8E53 90%)',
        borderRadius: 3,
        border: 0,
        color: 'white',
        height: 48,
        padding: '0 30px',
        boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
    };

    return (
        <TableContainer>
            <Table>
                <TableBody>
                    {
                        products.map(p => (
                                <TableRow key={p.id} className={p.flag ? style_1.background : style_2.background}>
                                    <TableCell>{p.id}</TableCell>
                                    <TableCell>{p.name}</TableCell>
                                    <TableCell>{p.description}</TableCell>
                                    <TableCell>{p.price}&euro;</TableCell>
                                    <TableCell>{p.flag ? "ACTIVE" : "INACTIVE"}</TableCell>
                                    <TableCell>
                                        <Button
                                            variant="contained"
                                            style={button_style}
                                            color="primary"
                                            size="small"
                                            onClick={() => buyProduct({
                                                id: p.id,
                                                name: p.name,
                                                price: p.price
                                            })}
                                        >BUY</Button>
                                    </TableCell>
                                </TableRow>

                        ))
                    }
                </TableBody>
            </Table>
        </TableContainer>
    )
}

ProductTable.propTypes = {
    products: PropTypes.arrayOf(
        PropTypes.shape({
            id: PropTypes.number.isRequired,
            name: PropTypes.string.isRequired,
            description: PropTypes.string.isRequired,
            price: PropTypes.number.isRequired,
            flag: PropTypes.bool.isRequired,
            users: PropTypes.array.isRequired
        })
    ).isRequired
}

const mapDispatchToProps = {}

export default connect(null, mapDispatchToProps)(ProductTable);