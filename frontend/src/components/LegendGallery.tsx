import { Card } from "../model/Card"
import LegendCard from "./LegendCard";

type CardGalleryProps = {
    cards : Card[]
}



export default function LegendGallery(props: CardGalleryProps){
    return (
        <div>

            {props.cards.map(
                (card)=> {
                    return <LegendCard card={card}/>


                }
            )}

        </div>


    )
}