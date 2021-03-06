import PropTypes from 'prop-types';
import Table from "@material-ui/core/Table";
import React from "react";
import TableCell from "@material-ui/core/TableCell";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import TableContainer from "@material-ui/core/TableContainer";
import {connect} from "react-redux";
import Button from "@material-ui/core/Button";


function ProductTable({products, handleBuyClick}) {

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
                                <TableRow key={p.id}>
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
                                            onClick={() => handleBuyClick(p.name)}
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
            flag: PropTypes.bool.isRequired
        })
    ).isRequired,
    handleBuyClick: PropTypes.func.isRequired
}

const mapDispatchToProps = {}

export default connect(null, mapDispatchToProps)(ProductTable);