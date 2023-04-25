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

function getId(type: string): number {
    if (!getCookie(type)) {
        return -1;
    }
    return parseInt(getCookie(type));
}

const Main = () => {
    let [valid, setValid] = useState(true);

    let configDTO: ConfigurationDTO = {
        motherboardId: getId('motherboard'),
        driveId: getId('drive'),
        cpuId: getId('cpu'),
        ramId: getId('ram'),
        powerUnitId: getId('powerunit'),
        videocardId: getId('videocard'),
    }

    return (
        <div>
            <ComponentBar config={configDTO} setValid={setValid}></ComponentBar>
            <ConfigurerGrid configDTO={configDTO}></ConfigurerGrid>
            <ConfigAnalysisResultBlock compatible={valid}></ConfigAnalysisResultBlock>
        </div>
    );
};

export default Main;