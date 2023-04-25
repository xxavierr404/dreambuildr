import * as React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Main from "./components/Main";
import Catalogue from "./components/Catalogue";
import MotherboardPage from "./components/MotherboardPage";
import CPUPage from "./components/CPUPage";
import RAMPage from "./components/RAMPage";
import PUPage from "./components/PUPage";
import DrivePage from "./components/DrivePage";
import VideocardPage from "./components/VideocardPage";

function App() {
  return (
    <div className="App">
        <BrowserRouter >
            <Routes>
                <Route path="/" element={<Main/>} />
                <Route path="/catalogue" element={<Catalogue/>}/>
                <Route path="/catalogue/motherboard" element={<MotherboardPage/>}/>
                <Route path="/catalogue/cpu" element={<CPUPage/>}/>
                <Route path="/catalogue/ram" element={<RAMPage/>}/>
                <Route path="/catalogue/powerunit" element={<PUPage/>}/>
                <Route path="/catalogue/drive" element={<DrivePage/>}/>
                <Route path="/catalogue/videocard" element={<VideocardPage/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
