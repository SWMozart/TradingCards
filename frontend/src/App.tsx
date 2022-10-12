import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import LegendGallery from './components/LegendGallery';
import logostartcard from './images/logostartcard.png';
import {HashRouter, Route, Routes} from "react-router-dom";
import PackPage from "./pages/PackPage";

function App() {

    const [cards, setCards] = useState([]);
    const getAllCards = () => {
        axios.get("/api/cards")
            .then((response)=>{
                return response.data
            })
            .then((cards)=>setCards(cards)
            )
            .catch((error)=> console.error(error))
    }

    useEffect(()=>{
        getAllCards()
    },[])


    return (
    <div className="App">
      <header className="App-header">
          <h1> Trading Legends Cards </h1>
        <img src={logostartcard} className="App-logo" />
          <HashRouter>
              <Routes>
                  <Route path = "/" element = {<LegendGallery cards={cards}/>}/>
                  <Route path ="/packs" element={<PackPage/>}/>
              </Routes>
          </HashRouter>
      </header>
    </div>
  );
}

export default App;
