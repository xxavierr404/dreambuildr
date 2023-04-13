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
import { getCookie } from 'typescript-cookie';

async function loadConfiguration(configDTO: ConfigurationDTO, dispatchers: ConfigDispatchers) {
    if (configDTO.cpuId === -1) {
        dispatchers.setCpu({id: -1, name: 'Not yet selected', price: 0});
    } else {
        await getItem(configDTO.cpuId, 'cpu')
            .then((value) => dispatchers.setCpu(value as CPU));
    }

    if (configDTO.motherboardId === -1) {
        dispatchers.setMotherboard({id: -1, name: 'Not yet selected', price: 0});
    } else {
        await getItem(configDTO.motherboardId, 'motherboard')
            .then((value) => dispatchers.setMotherboard(value as Motherboard));
    }

    if (configDTO.driveId === -1) {
        dispatchers.setDrive({id: -1, name: 'Not yet selected', price: 0});
    } else {
        await getItem(configDTO.driveId, 'drive')
            .then((value) => dispatchers.setDrive(value as Drive));
    }

    if (configDTO.ramId === -1) {
        dispatchers.setRam({id: -1, name: 'Not yet selected', price: 0});
    } else {
        await getItem(configDTO.ramId, 'ram')
            .then((value) => dispatchers.setRam(value as RAM));
    }

    if (configDTO.powerUnitId === -1) {
        dispatchers.setPowerUnit({id: -1, name: 'Not yet selected', price: 0});
    } else {
        await getItem(configDTO.powerUnitId, 'powerunit')
            .then((value) => dispatchers.setPowerUnit(value as PowerUnit));
    }

    if (configDTO.videocardId === -1) {
        dispatchers.setVideocard({id: -1, name: 'Not yet selected', price: 0});
    } else {
        await getItem(configDTO.videocardId, 'videocard')
            .then((value) => dispatchers.setVideocard(value as Videocard));
    }
}

type ConfigDispatchers = {
    setCpu: Dispatch<any>,
    setRam: Dispatch<any>,
    setMotherboard: Dispatch<any>,
    setDrive: Dispatch<any>,
    setPowerUnit: Dispatch<any>,
    setVideocard: Dispatch<any>,
}

function getId(type: string): number {
    if (!getCookie(type)) {
        return -1;
    }
    return parseInt(getCookie(type));
}

const Main = () => {
    let [cpu, setCpu] = useState(null);
    let [ram, setRam] = useState(null);
    let [motherboard, setMotherboard] = useState(null);
    let [drive, setDrive] = useState(null);
    let [powerUnit, setPowerUnit] = useState(null);
    let [videocard, setVideocard] = useState(null);
    let [valid, setValid] = useState(true);


    let configDTO: ConfigurationDTO = {
        motherboardId: getId('motherboard'),
        driveId: getId('drive'),
        cpuId: getId('cpu'),
        ramId: getId('ram'),
        powerUnitId: getId('powerunit'),
        videocardId: getId('videocard'),
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
            <ComponentBar config={configDTO} setValid={setValid}></ComponentBar>
            <ConfigurerGrid config={config}></ConfigurerGrid>
            <ConfigAnalysisResultBlock compatible={valid}></ConfigAnalysisResultBlock>
        </div>
    );
};

export default Main;