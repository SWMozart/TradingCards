import LegendGallery from "../components/LegendGallery";
import React, {useEffect, useState} from "react";
import axios from "axios";

export default function CardPage(){

    const [cards, setCards] = useState([]);
    const getAllCards = () => {
        axios.get("/api/cards")
            .then((response)=>{return response.data})
            .then((data)=>setCards(data)
            )
            .catch((error)=> console.error(error))
    }

    useEffect(()=>{
        getAllCards()
    },[])

    return (
        <>
            <LegendGallery cards={cards}/>
        </>

    )
}