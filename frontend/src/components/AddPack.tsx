import {ChangeEvent, FormEvent, useState} from "react";
import "./AddPack.css"
import {Pack} from "../model/Pack";

type AddPackProps = {
    addPack:(pack:Pack)=>void
}

export default function AddPack(props:AddPackProps){
    const emptyPackPlaceholder: Pack = {
        id:"",
        name: "",
        category: "",
        cardsInAPack: []
    }

    const [pack, setPack] = useState(emptyPackPlaceholder)

    const handleChange=(event:ChangeEvent<HTMLInputElement>)=> {
        const inputFieldValue = event.target.value;
        const inputFieldName = event.target.name;
        setPack( oldPack =>(
                { ...oldPack,
                    [inputFieldName]:inputFieldValue
                }
            )
        )
    }

    const handleSubmit=(event:FormEvent<HTMLFormElement>)=> {
        event.preventDefault();
        if(pack.name!=="" && pack.category){
            props.addPack(pack)
            console.log(pack.category+"wird hinzugefügt!!!!!")
        }else {
            alert("Bitte füllen Sie alle Angaben aus")
        }
    }

    return(
        <div className={"add-pack"}>
            <section>
                <label>
                    <input type="text" name={"name"} placeholder="Name" value={pack.name} onChange={handleChange}/>
                </label>
            </section>
            <section>
                <label>
                    <input type="text"  name ={"category"}placeholder="Category" value={pack.category} onChange={handleChange}/>
                </label>
            </section>
            <form onSubmit={handleSubmit}>
                <button className={"form-btn-submit"} type={"submit"}>Add</button>
            </form>

        </div>
    )
}