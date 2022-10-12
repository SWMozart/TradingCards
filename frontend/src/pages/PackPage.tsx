import {useEffect, useState} from "react";
import axios from "axios";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;
import PacksOverview from "../components/PacksOverview";


export default function PackPage() {

    const [packs, setPacks] = useState([]);

    useEffect(()=> {
        getAllPacks()
    },[])

    const getAllPacks = () => {
        axios.get("/api/packs")
            .then((response)=> {
                return response.data
            })
            .then((packs)=> setPacks(packs))
            .catch((error) => console.error(error))
    }



    return(
        <div>
            <PacksOverview packs={packs}/>
        </div>
    )
}
