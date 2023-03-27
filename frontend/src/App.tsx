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
import {ConfigurationDTO} from "./types/ConfigurationDTO";
import {Configuration} from "./types/Configuration";
import getItem from "./utils/GetItem";
import {Dispatch, useEffect, useState} from "react";

function loadConfiguration(configDTO: ConfigurationDTO, config: Configuration, setConfig: Dispatch<any>) {
    getItem(configDTO.cpuId, 'cpu')
        .then((value) => setConfig({...config, cpu: value as CPU}));
    getItem(configDTO.motherboardId, 'motherboard')
        .then((value) => setConfig({...config, motherboard: value as Motherboard}));
    getItem(configDTO.driveId, 'drive')
        .then((value) => setConfig({...config, drive: value as Drive}));
    getItem(configDTO.ramId, 'ram')
        .then((value) => setConfig({...config, ram: value as RAM}));
    getItem(configDTO.powerUnitId, 'powerunit')
        .then((value) => setConfig({...config, powerUnit: value as PowerUnit}));
    getItem(configDTO.videocardId, 'videocard')
        .then((value) => setConfig({...config, videocard: value as Videocard}));
}

function App() {
    let [config, setConfig] = useState({
        cpu: null,
        motherboard: null,
        drive: null,
        ram: null,
        powerUnit: null,
        videocard: null,
    });

    let configDTO: ConfigurationDTO = {
        motherboardId: BigInt(2),
        driveId: BigInt(1),
        cpuId: BigInt(1),
        ramId: BigInt(1),
        powerUnitId: BigInt(1),
        videocardId: BigInt(1),
    }

    useEffect(() => {
        loadConfiguration(configDTO, config, setConfig);
    }, []);

  return (
    <div className="App">
        <header className="header-flex accent-gradient title-text">dreambuildr</header>
        <ComponentBar></ComponentBar>
        <ConfigurerGrid cpu={config.cpu}
                        motherboard={config.motherboard}
                        ram={config.ram}
                        drive={config.drive}
                        powerUnit={config.powerUnit}
                        videocard={config.videocard}></ConfigurerGrid>
        <ConfigAnalysisResultBlock></ConfigAnalysisResultBlock>
    </div>
  );
}

export default App;
