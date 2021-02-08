import PropTypes from 'prop-types';
import Table from "@material-ui/core/Table";
import React from "react";
import TableCell from "@material-ui/core/TableCell";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import TableContainer from "@material-ui/core/TableContainer";
import {connect} from "react-redux";
import {Link} from "react-router-dom";

function ProductTable({products, buyProduct}) {

    return (
        <TableContainer>
            <Table>
                <TableBody>
                    {
                        products.map(p => (
                            <TableRow key={p.id}>
                                <TableCell>{p.id}</TableCell>
                                <TableCell><Link to={`/products/${p.id}`}>{p.name}</Link></TableCell>
                                <TableCell>{p.description}</TableCell>
                                <TableCell>{p.price}</TableCell>
                                <TableCell>{p.flag ? "ok" : "not ok"}</TableCell>
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