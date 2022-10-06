import {Card} from "../model/Card";
import "./LegendCard.css";

type LegendCardProps = {
    card : Card
}

export default function LegendCard(props: LegendCardProps){
    return (
        <div className="form">

            <p className={"legend-property"}> Name: {props.card.name}</p>
            <p className={"legend-property"}> Position: {props.card.position}</p>
            <p className={"legend-property"}> Category: {props.card.category}</p>
            <div>
                <img className="CardPoster" src={props.card.poster}/>
            </div>


        </div>
    )
}