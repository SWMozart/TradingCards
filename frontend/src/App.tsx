import React from 'react';
import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import PackPage from "./pages/PackPage";
import CardPage from "./pages/CardPage";
import NavBar from "./components/NavBar";
import HomePage from "./pages/HomePage";

function App() {

    return (
    <div className="App">
      <header className="App-header">
          <h1 className={"App-title"}> Trading Legends Cards </h1>

          <HashRouter>
              <NavBar/>
              <Routes>
                  <Route path = {"/"} element = {<HomePage/>}/>
                  <Route path ={"/cards"} element = {<CardPage/>}/>
                  <Route path ={"/packs"} element={<PackPage/>}/>
              </Routes>
          </HashRouter>
      </header>
    </div>
  );
}

export default App;
