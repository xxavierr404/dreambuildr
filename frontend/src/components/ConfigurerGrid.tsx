import * as React from 'react';
import {Configuration} from "../types/Configuration";

const ConfigurerGrid = (props: Configuration) => {
    return (
        <div className="config-grid">
            <div className="config-grid-column">
                <div className="config-grid-component-text">
                    <p>Your CPU is:</p>
                    <b>{props.cpu?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your motherboard is:</p>
                    <b>{props.motherboard?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your PU is:</p>
                    <b>{props.powerUnit?.name}</b>
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
                    <b>{props.ram?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your HDD/SSD is:</p>
                    <b>{props.drive?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your videocard is:</p>
                    <b>{props.videocard?.name}</b>
                </div>
            </div>
        </div>
    );
};

export default ConfigurerGrid;