

import {Card} from "../model/Card";
import "./LegendCard.css";
import {
    useState
} from "react";
import ReactCardFlip from "react-card-flip";

type LegendCardProps = {
    card : Card
}
export default function LegendCard(props: LegendCardProps){

    const [isFlipped, setIsFlipped] = useState(false);

    const onRotate = () => {
        setIsFlipped((flipped) => !flipped);
    }




    return (
        <ReactCardFlip isFlipped={isFlipped} flipDirection={"horizontal"}>
            <div className={"front"} onClick={onRotate}>
        <div className="front-form">

            <h1 className={"legend-property"}> Name: {props.card.name}</h1>
            <h1 className={"legend-property"}> Position: {props.card.position}</h1>
            <h1 className={"legend-property"}> Category: {props.card.category}</h1>
            <div>
                <img className="CardPoster" src={props.card.poster}/>
            </div>

        </div>
        </div>
            <div className={"back"} onClick={onRotate}>
                <div className="back-form">

                    <h1 className={"legend-property"}> {props.card.year}</h1>
                    <h1 className={"legend-property"}> {props.card.name}</h1>
                    <h1 className={"legend-property"}> {props.card.height} cm</h1>
                    <h1 className={"legend-property"}> {props.card.weight} kg</h1>

                    <div>
                        <img className="CardPosterBack" src={props.card.poster}/>
                    </div>

                </div>
            </div>
        </ReactCardFlip>
        )
}