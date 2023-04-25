import * as React from 'react';
import {Configuration} from "../types/Configuration";
import {ConfigurationDTO} from "../types/ConfigurationDTO";
import getItem from "../utils/GetItem";
import CPU from "../types/pcComponents/CPU";
import Motherboard from "../types/pcComponents/Motherboard";
import Drive from "../types/pcComponents/Drive";
import RAM from "../types/pcComponents/RAM";
import PowerUnit from "../types/pcComponents/PowerUnit";
import Videocard from "../types/pcComponents/Videocard";
import {Dispatch, useEffect, useState} from "react";

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

const ConfigurerGrid = (props: {configDTO: ConfigurationDTO}) => {
    let [cpu, setCpu] = useState(null);
    let [ram, setRam] = useState(null);
    let [motherboard, setMotherboard] = useState(null);
    let [drive, setDrive] = useState(null);
    let [powerUnit, setPowerUnit] = useState(null);
    let [videocard, setVideocard] = useState(null);

    let config: Configuration = {
        cpu: cpu,
        ram: ram,
        drive: drive,
        motherboard: motherboard,
        powerUnit: powerUnit,
        videocard: videocard
    }

    useEffect(() => {
        loadConfiguration(props.configDTO, {
            setCpu: setCpu,
            setRam: setRam,
            setDrive: setDrive,
            setVideocard: setVideocard,
            setPowerUnit: setPowerUnit,
            setMotherboard: setMotherboard
        });
    }, []);

    return (
        <div className="config-grid">
            <div className="config-grid-column">
                <div className="config-grid-component-text">
                    <p>Your CPU is:</p>
                    <b>{config.cpu?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your motherboard is:</p>
                    <b>{config.motherboard?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your PU is:</p>
                    <b>{config.powerUnit?.name}</b>
                </div>
            </div>
            <div className="flex items-center justify-center config-grid-md-dummy-flex">
                <img className="invert select-none w-2/3" src="../res/microchip-svgrepo-com.svg"
                     alt="Configuration icon"></img>
            </div>
            <div className="config-grid-column">
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your RAM is:</p>
                    <b>{config.ram?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your HDD/SSD is:</p>
                    <b>{config.drive?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your videocard is:</p>
                    <b>{config.videocard?.name}</b>
                </div>
            </div>
        </div>
    );
};

export default ConfigurerGrid;