import {Pack} from "../model/Pack";


type PacksOverviewProps= {
    packs: Pack[];
}

    export default function PacksOverview(props:PacksOverviewProps)
{

    return (
        <div>
            {props.packs.map(
                (pack)=>{
                return pack.name

                }
            )}
        </div>
    )

}
