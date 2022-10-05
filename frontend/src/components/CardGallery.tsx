import { Card } from "../model/Card"

type CardGalleryProps = {
    cards : Card[]
}



export default function CardGallery(props: CardGalleryProps){
    return (
        <div>

            {props.cards.map(
                (card)=> {
                    return <img src={card.poster} />


                }
            )}

        </div>


    )
}