import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import LegendGallery from './components/LegendGallery';

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
        <img src="https://cdn-icons-png.flaticon.com/128/683/683774.png" className="App-logo" alt="logo" />
          <LegendGallery cards={cards}/>
      </header>
    </div>
  );
}

export default App;
