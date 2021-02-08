import {allKeys} from "../../api/licenseApi";
import {useEffect, useState} from "react";
import Loader from "../common/Loader";
import AllKeyTable from "./AllKeyTable";


const Keys = () =>{
    const [keys, setKeys] = useState([])
    const [isLoading, setIsLoading] = useState(true)

    useEffect(() => {
        loadAllKeys();
    }, [])

    const loadAllKeys = () => {
        allKeys()
            .then(response => {
                setKeys(response.data)
            })
            .finally(() => {
                setIsLoading(false);
            })
    }
    return (
        <>
            {
                isLoading ? (<Loader />) :
                    <AllKeyTable
                        keys={keys}
                    />
            }
        </>
    )
}
Keys.displayName = "Keys"

export default Keys