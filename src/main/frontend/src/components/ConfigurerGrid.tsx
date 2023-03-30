import * as React from 'react';
import {Configuration} from "../types/Configuration";

const ConfigurerGrid = (props: {config: Configuration}) => {
    return (
        <div className="config-grid">
            <div className="config-grid-column">
                <div className="config-grid-component-text">
                    <p>Your CPU is:</p>
                    <b>{props.config.cpu?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your motherboard is:</p>
                    <b>{props.config.motherboard?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your PU is:</p>
                    <b>{props.config.powerUnit?.name}</b>
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
                    <b>{props.config.ram?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your HDD/SSD is:</p>
                    <b>{props.config.drive?.name}</b>
                </div>
                <div className="config-grid-md-dummy"></div>
                <div className="config-grid-component-text">
                    <p>Your videocard is:</p>
                    <b>{props.config.videocard?.name}</b>
                </div>
            </div>
        </div>
    );
};

export default ConfigurerGrid;