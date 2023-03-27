import * as React from 'react';
import './App.css';
import ComponentBar from "./components/ComponentBar";
import ConfigurerGrid from "./components/ConfigurerGrid";
import CPU from "./types/pcComponents/CPU";
import Drive from "./types/pcComponents/Drive";
import Motherboard from "./types/pcComponents/Motherboard";
import PowerUnit from "./types/pcComponents/PowerUnit";
import RAM from "./types/pcComponents/RAM";
import Videocard from "./types/pcComponents/Videocard";
import ConfigAnalysisResultBlock from "./components/ConfigAnalysisResultBlock";

function App() {
    let cpu: CPU = new CPU("AMD Ryzen 5 3600", 6000);
    let drive: Drive = new Drive("WD Blue 500 GB", 2000);
    let motherboard: Motherboard = new Motherboard("Gigabyte B450H", 8000);
    let powerUnit: PowerUnit = new PowerUnit("Aerocool VX Ace 550", 3000);
    let ram: RAM = new RAM("Kingston Fury Beast 16GB", 5000);
    let videocard: Videocard = new Videocard("Palit Geforce GTX 1060", 10000);

  return (
    <div className="App">
        <header className="header-flex accent-gradient title-text">dreambuildr</header>
        <ComponentBar></ComponentBar>
        <ConfigurerGrid cpu={cpu}
                        motherboard={motherboard}
                        ram={ram}
                        drive={drive}
                        powerUnit={powerUnit}
                        videocard={videocard}></ConfigurerGrid>
        <ConfigAnalysisResultBlock></ConfigAnalysisResultBlock>
    </div>
  );
}

export default App;
