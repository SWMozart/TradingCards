import {useEffect, useState} from "react";
import axios from "axios";
import PacksOverview from "../components/PacksOverview";
import {Pack} from "../model/Pack";
import AddPack from "../components/AddPack";


export default function PackPage() {

    const [packs, setPacks] = useState([]);

    useEffect(()=> {
        getAllPacks()
    },[])

    const getAllPacks = () =>{
        axios.get("/api/packs")
            .then((response)=> {
                return response.data
            })
            .then((data)=>setPacks(data))
            .catch((error)=>console.error(error));
    }

    const addPack=(newPack:Pack)=> {

        axios.post("/api/packs", newPack)
            .then(getAllPacks)
            .catch((error)=>console.error(error));
    }

    const deletePack = (id:string) =>{
        axios.delete("/api/packs/"+id)
            .then(getAllPacks)
    }


    return(
        <div>
            <>{console.log(packs)}</>
            <PacksOverview packs={packs} deletePack={deletePack}/>
            <AddPack addPack={addPack}/>
        </div>
    )
}
