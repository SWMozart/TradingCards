import logostartcard from "../images/logostartcard.png";
import React from "react";
import "../App.css"

export default function HomePage(){
    return (
        <div className={"homePage"}>
            <img src={logostartcard} className="App-logo" />
            <h2> Collect the Legends in your Deck </h2>
        </div>
    )
}