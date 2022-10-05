import {Card} from "../model/Card";
import "./LegendCard.css";

type LegendCardProps = {
    card : Card
}

export default function LegendCard(props: LegendCardProps){
    return (
        <div>
            Name:
            <p> {props.card.name}</p>
            Position:
            <p> {props.card.position}</p>
            Category:
            <p> {props.card.category}</p>

            <img className="CardForm" src={props.card.poster}/>

        </div>
    )
}