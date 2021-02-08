import {allKeys} from "../../api/licenseApi";
import {useEffect, useState} from "react";
import AllKeyTable from "./AllKeyTable";


const Keys = () => {
    const [keys, setKeys] = useState([])

    useEffect(() => {
        loadAllKeys();
    }, [])

    const loadAllKeys = () => {
        allKeys()
            .then(response => {
                setKeys(response.data)
            })
    }
    return (
        <>
            <AllKeyTable
                keys={keys}
            />

        </>
    )
}
Keys.displayName = "Keys"

export default Keys