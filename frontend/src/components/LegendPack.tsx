import {Pack} from "../model/Pack";
import React, {useState} from "react";
import "./LegendPack.css"
import logostartcard from "../images/logostartcard.png";
import LegendCardsInPack from "./LegendCardsInPack";
import {Card} from "../model/Card";
import CardsInPackModal from "./CardsInPackModal";


type LegendPackProps = {
    cards: Card[]
    pack: Pack
    deletePack: (id: string) => void
}

export default function LegendPack(props: LegendPackProps) {
    const [isDisplay, setIsDisplay] = useState(true);
    const [cardsInPackModalOn, setCardsInPackModalOn] = useState(false);

    const onClick = () => {
        setIsDisplay(!isDisplay);
        setCardsInPackModalOn(true);
    };
    const resetOnHide = () =>{
        setCardsInPackModalOn(false);
        setIsDisplay(!isDisplay);
    }
    const Pack = () => {
        return (
            <div className={"pack"}>

                <div onClick={onClick}>
                    <img src={logostartcard} className="pack-img" />
                </div>
            </div>
        )
    }
    return (
        <div>
            {
                isDisplay ? <Pack/>
                    :
                    <div>
                        <CardsInPackModal show={cardsInPackModalOn}
                                          onHide={resetOnHide}
                                          cards={props.pack.cardsInAPack}/>
                    </div>
            }

        </div>
    )
}
/* for 31  <button className={"btn-delete-pack"} onClick={() => props.deletePack(props.pack.id)}>Delete</button>*/
