import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import CardGallery from './components/CardGallery';

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
        <img src={logo} className="App-logo" alt="logo" />
          <CardGallery cards={cards}/>




      </header>
    </div>
  );
}

export default App;
