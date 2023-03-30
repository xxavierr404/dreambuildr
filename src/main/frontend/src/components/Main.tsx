import * as React from 'react';
import ComponentBar from "./ComponentBar";
import ConfigurerGrid from "./ConfigurerGrid";
import ConfigAnalysisResultBlock from "./ConfigAnalysisResultBlock";
import {Dispatch, useEffect, useState} from "react";
import {ConfigurationDTO} from "../types/ConfigurationDTO";
import {Configuration} from "../types/Configuration";
import getItem from "../utils/GetItem";
import CPU from "../types/pcComponents/CPU";
import Motherboard from "../types/pcComponents/Motherboard";
import Drive from "../types/pcComponents/Drive";
import RAM from "../types/pcComponents/RAM";
import PowerUnit from "../types/pcComponents/PowerUnit";
import Videocard from "../types/pcComponents/Videocard";

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

const Main = () => {
    let [cpu, setCpu] = useState(null);
    let [ram, setRam] = useState(null);
    let [motherboard, setMotherboard] = useState(null);
    let [drive, setDrive] = useState(null);
    let [powerUnit, setPowerUnit] = useState(null);
    let [videocard, setVideocard] = useState(null);


    let configDTO: ConfigurationDTO = {
        motherboardId: 7,
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
    }, [configDTO]);

    let config: Configuration = {
        cpu: cpu,
        ram: ram,
        drive: drive,
        motherboard: motherboard,
        powerUnit: powerUnit,
        videocard: videocard
    }

    return (
        <div>
            <ComponentBar config={configDTO}></ComponentBar>
            <ConfigurerGrid config={config}></ConfigurerGrid>
            <ConfigAnalysisResultBlock></ConfigAnalysisResultBlock>
        </div>
    );
};

export default Main;