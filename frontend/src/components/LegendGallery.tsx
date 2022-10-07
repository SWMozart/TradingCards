import { Card } from "../model/Card"
import LegendCard from "./LegendCard";
import "./LegendGallery.css"

type CardGalleryProps = {
    cards : Card[]
}



export default function LegendGallery(props: CardGalleryProps){
    return (
        <div className={"card-overview"}>
            {props.cards.map(
                (card)=> {
                    return <LegendCard card={card}/>
                }
            )}
        </div>


    )
}