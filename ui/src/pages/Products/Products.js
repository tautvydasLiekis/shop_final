import {useEffect, useState} from "react";
import {fetchProducts} from "../../api/productsApi";
import ProductsTable from "./ProductsTable";
import {buyProduct} from "../../api/buyApi";

const Products = () => {
    const [products, setProducts] = useState([])

    useEffect(() => {
        loadAllProducts();
    }, [])

    const loadAllProducts = () => {
        fetchProducts()
            .then(response => {
                setProducts(response.data)
            })
    }
    const handleBuyClick = (name) => {
        buyProduct(name)
            .then(() => {
                loadAllProducts();
            })
    }

    return (
        <>
            <ProductsTable
                products={products}
                handleBuyClick={handleBuyClick}
            />

        </>
    )
}

Products.displayName = "Products"

export default Products
