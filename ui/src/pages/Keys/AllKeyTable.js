import TableContainer from "@material-ui/core/TableContainer";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import React from "react";
import PropTypes from 'prop-types';
import {connect} from "react-redux";

function AllKeyTable({keys}) {

    return (
        <TableContainer>
            <Table>
                <TableBody>
                    {
                        keys.map(k => (
                            <TableRow key={k.id}>
                                <TableCell>{k.id}</TableCell>
                                <TableCell>{k.licenseKey}</TableCell>
                                <TableCell>{k.isActivated ? "ACTIVE" : "INACTIVE"}</TableCell>
                            </TableRow>

                        ))
                    }
                </TableBody>
            </Table>
        </TableContainer>
    )
}
AllKeyTable.propTypes = {
    keys: PropTypes.arrayOf(
        PropTypes.shape({
            id: PropTypes.number.isRequired,
            licenseKey: PropTypes.number.isRequired,
            isActivated: PropTypes.string.isRequired
        })
    ).isRequired
}

const mapDispatchToProps = {}

export default connect(null, mapDispatchToProps)(AllKeyTable);