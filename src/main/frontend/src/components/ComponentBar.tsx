import * as React from 'react';
import BarTile from "./BarTile";
import {Dispatch, useEffect, useState} from "react";
import {ConfigurationDTO} from "../types/ConfigurationDTO";
import validatePCConfiguration from "../utils/ValidatePCConfiguration";

function setAll(dispatchers: ValidatorDispatchers, value: boolean) {
    dispatchers.setCpuValid(value);
    dispatchers.setDriveValid(value);
    dispatchers.setVideocardValid(value);
    dispatchers.setRamValid(value);
    dispatchers.setMotherboardValid(value);
    dispatchers.setPowerUnitValid(value);
}

async function validate(config: ConfigurationDTO, dispatchers: ValidatorDispatchers) {
    validatePCConfiguration(config).then((value) => {
       switch (value.data) {
           case ("OK"):
               setAll(dispatchers, true);
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
               for (let item in config) {
                    if (config[item as keyof ConfigurationDTO] === -1) {
                        setAll(dispatchers, false);
                        break;
                    }
               }
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

const ComponentBar = (props: {config: ConfigurationDTO, setValid: Dispatch<any>}) => {
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
        setAll(dispatchers, true);
        validate(props.config, dispatchers);
    }, []);

    useEffect(() => {
        for (let valid of [cpuValid, ramValid, driveValid, motherboardValid, powerUnitValid, videocardValid]) {
            if (!valid) {
                props.setValid(false);
                break;
            }
        }
    }, [cpuValid, ramValid, driveValid, motherboardValid, powerUnitValid, videocardValid]);

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