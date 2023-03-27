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
import getItem from "./utils/GetItem";
import {Dispatch, useEffect, useState} from "react";
import {Configuration} from "./types/Configuration";

async function loadConfiguration(configDTO: ConfigurationDTO, dispatchers: ConfigDispatchers) {
    await getItem(configDTO.cpuId, 'cpu')
        .then((value) => dispatchers.setCpu(value as CPU));
    await getItem(configDTO.motherboardId, 'motherboard')
        .then((value) => dispatchers.setMotherboard(value as Motherboard));
    await getItem(configDTO.driveId, 'drive')
        .then((value) => dispatchers.setDrive(value as Drive));
    await getItem(configDTO.ramId, 'ram')
        .then((value) => dispatchers.setRam(value as RAM));
    await getItem(configDTO.powerUnitId, 'powerunit')
        .then((value) => dispatchers.setPowerUnit(value as PowerUnit));
    await getItem(configDTO.videocardId, 'videocard')
        .then((value) => dispatchers.setVideocard(value as Videocard));
}

type ConfigDispatchers = {
    setCpu: Dispatch<any>,
    setRam: Dispatch<any>,
    setMotherboard: Dispatch<any>,
    setDrive: Dispatch<any>,
    setPowerUnit: Dispatch<any>,
    setVideocard: Dispatch<any>,
}

function App() {
    let [cpu, setCpu] = useState(null);
    let [ram, setRam] = useState(null);
    let [motherboard, setMotherboard] = useState(null);
    let [drive, setDrive] = useState(null);
    let [powerUnit, setPowerUnit] = useState(null);
    let [videocard, setVideocard] = useState(null);


    let configDTO: ConfigurationDTO = {
        motherboardId: 2,
        driveId: 1,
        cpuId: 1,
        ramId: 1,
        powerUnitId: 1,
        videocardId: 1,
    }

    useEffect(() => {
        loadConfiguration(configDTO, {
            setCpu: setCpu,
            setRam: setRam,
            setDrive: setDrive,
            setVideocard: setVideocard,
            setPowerUnit: setPowerUnit,
            setMotherboard: setMotherboard
        });
    }, []);

    let config: Configuration = {
        cpu: cpu,
        ram: ram,
        drive: drive,
        motherboard: motherboard,
        powerUnit: powerUnit,
        videocard: videocard
    }

  return (
    <div className="App">
        <header className="header-flex accent-gradient title-text">dreambuildr</header>
        <ComponentBar config={configDTO}></ComponentBar>
        <ConfigurerGrid config={config}></ConfigurerGrid>
        <ConfigAnalysisResultBlock></ConfigAnalysisResultBlock>
    </div>
  );
}

export default App;
