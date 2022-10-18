import {Card} from "../model/Card";
import "./LegendCardInPack.css";
import {useState} from "react";
import UserCards from "./UserCards";

type LegendCardInPackProps = {
    card : Card
}

export default function LegendCardInPack(props: LegendCardInPackProps){
    const [isSelected, setIsSelected] = useState(true);

    function handleOnClick() {

        setIsSelected(!isSelected);
        console.log(props.card)
        if(isSelected){
            <UserCards cards={props.card}/>
        }
    }

    return (
        <div className="form" onClick={handleOnClick}>

            <p className={"legend-property"}> Name: {props.card.name}</p>
            <p className={"legend-property"}> Position: {props.card.position}</p>
            <p className={"legend-property"}> Category: {props.card.category}</p>
            <div>
                <img className="CardPoster" src={props.card.poster}/>
            </div>


        </div>
    )
}