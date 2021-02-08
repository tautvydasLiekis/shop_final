import {AppBar, Badge, CssBaseline, IconButton, Link, makeStyles, Toolbar, Typography, Button} from "@material-ui/core";
import {NavLink, Link as RouterLink} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import LangSwitcher from "./LangSwitcher";
import {removeJwt, removeUserData} from "../../store/slices/userSlice";
import useUser from "../../hooks/useUser";

const useStyles = makeStyles((theme) => ({
    '@global': {
        ul: {
            margin: 0,
            padding: 0,
            listStyle: 'none',
        },
    },
    appBar: {
        borderBottom: `1px solid ${theme.palette.divider}`,
        background: 'linear-gradient(45deg, #484848 30%, #FF8E53 90%)',
        color: 'white',
        textTransform: 'capitalize',
    },
    toolbar: {
        flexWrap: 'wrap',
    },
    toolbarTitle: {
        flexGrow: 1,
    },
    link: {
        margin: theme.spacing(1, 1.5),
        color: 'white',
        textTransform: 'capitalize',
    },
}));

const Header = () => {
    const classes = useStyles()
    const user = useUser()
    const dispatch = useDispatch()

    const logout = () => {
        dispatch(removeJwt())
        dispatch(removeUserData())
    }

    return (
        <>
            <CssBaseline/>
            <AppBar position="static" color="default" elevation={0} className={classes.appBar}>
                <Toolbar className={classes.toolbar}>
                    <Typography variant="h6" color="inherit" noWrap className={classes.toolbarTitle}>
                        MyShop
                    </Typography>
                    <nav>
                        {
                            !!user?.roles.includes('ADMIN') && (
                                    <Link className={classes.link} component={NavLink}to="/products/new">New Product</Link>
                            )
                        }
                        {
                            !!user?.roles.includes('USER') && (
                                <>
                                    <>
                                        <Link className={classes.link} component={NavLink}to="/dashboard">Dashboard</Link>
                                        <Link className={classes.link} component={NavLink} to="/products">Products</Link>
                                        <Link className={classes.link} component={NavLink} to="/keys">My Keys</Link>
                                        <Link className={classes.link} component={NavLink} to="/about">About</Link>
                                        <Link className={classes.link} component={NavLink}
                                              to="/account"><span>{`${user.name} ${user.lastname}`}</span></Link>
                                        <Link className={classes.link} component={Button} onClick={logout} href="/">Log
                                            out</Link>
                                        <LangSwitcher/>
                                    </>
                                </>
                            )
                        }
                    </nav>
                </Toolbar>
            </AppBar>
        </>
    )
}

export default Header