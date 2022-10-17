import {Pack} from "../model/Pack";
import LegendPack from "./LegendPack";
import "./LegendGallery.css"


type PacksOverviewProps= {
    packs: Pack[];
    deletePack:(id:string)=>void
}

    export default function PacksOverview(props:PacksOverviewProps) {

    return (
        <div className={"card-overview"}>
            {props.packs.map(
                (pack)=>{
                    return <LegendPack key={pack.id} cards={pack.cardsInAPack} pack={pack} deletePack={props.deletePack}/>
                }
            )}
        </div>
    )

}
