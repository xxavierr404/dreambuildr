import * as React from 'react';
import BarTile from "./BarTile";
import {Dispatch, useEffect, useState} from "react";
import {ConfigurationDTO} from "../types/ConfigurationDTO";
import validatePCConfiguration from "../utils/ValidatePCConfiguration";

function setValid(dispatchers: ValidatorDispatchers) {
    dispatchers.setCpuValid(true);
    dispatchers.setDriveValid(true);
    dispatchers.setVideocardValid(true);
    dispatchers.setRamValid(true);
    dispatchers.setMotherboardValid(true);
    dispatchers.setPowerUnitValid(true);
}

async function validate(config: ConfigurationDTO, dispatchers: ValidatorDispatchers) {
    validatePCConfiguration(config).then((value) => {
       switch (value.data) {
           case ("OK"):
               setValid(dispatchers);
               break;
           case ("CPU_SOCKET_MISMATCH"):
               dispatchers.setCpuValid(false);
               dispatchers.setMotherboardValid(false);
               break;
           case ("RAM_SOCKET_MISMATCH"):
               dispatchers.setRamValid(false);
               dispatchers.setMotherboardValid(false);
               break;
           default:
               break;
       }
    });
}

type ValidatorDispatchers = {
    setCpuValid: Dispatch<any>,
    setRamValid: Dispatch<any>,
    setDriveValid: Dispatch<any>,
    setMotherboardValid: Dispatch<any>,
    setPowerUnitValid: Dispatch<any>,
    setVideocardValid: Dispatch<any>,
}

const ComponentBar = (props: {config: ConfigurationDTO}) => {
    let [cpuValid, setCpuValid] = useState(false);
    let [ramValid, setRamValid] = useState(false);
    let [driveValid, setDriveValid] = useState(false);
    let [motherboardValid, setMotherboardValid] = useState(false);
    let [powerUnitValid, setPowerUnitValid] = useState(false);
    let [videocardValid, setVideocardValid] = useState(false);

    let dispatchers = {
        setCpuValid: setCpuValid,
        setRamValid: setRamValid,
        setDriveValid: setDriveValid,
        setMotherboardValid: setMotherboardValid,
        setPowerUnitValid: setPowerUnitValid,
        setVideocardValid: setVideocardValid
    }

    useEffect(() => {
        setValid(dispatchers);
        validate(props.config, dispatchers);
    }, []);

    return (
        <div className="builder-category-bar">
            <BarTile iconPath={"../res/icons/codesandbox.svg"} title={"Motherboard"} status={motherboardValid}></BarTile>
            <BarTile iconPath={"../res/icons/cpu.svg"} title={"CPU"} status={cpuValid}></BarTile>
            <BarTile iconPath={"../res/icons/loader.svg"} title={"RAM"} status={ramValid}></BarTile>
            <BarTile iconPath={"../res/icons/hard-drive.svg"} title={"HDD/SSD"} status={driveValid}></BarTile>
            <BarTile iconPath={"../res/icons/zap.svg"} title={"PU"} status={powerUnitValid}></BarTile>
            <BarTile iconPath={"../res/icons/video.svg"} title={"Video card"} status={videocardValid}></BarTile>
        </div>
    );
};

export default ComponentBar;