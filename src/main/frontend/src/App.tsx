import * as React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Main from "./components/Main";
import Catalogue from "./components/Catalogue";

function App() {
  return (
    <div className="App">
        <BrowserRouter >
            <Routes>
                <Route path="/" element={<Main/>} />
                <Route path="/catalogue" element={<Catalogue/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
