import { Card } from "../model/Card"
import LegendCardInPack from "./LegendCardInPack";
import "./LegendCardsInPack.css"

type LegendCardsInPackProps = {
    cards : Card[];
}



export default function LegendCardsInPack(props: LegendCardsInPackProps){
    return (
        <div className={"cards-in-pack"}>
            {props.cards.map(
                (card)=>{
                    return <LegendCardInPack key={card.id} card={card}/>
                })
            }
        </div>


    )
}