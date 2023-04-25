import * as React from 'react';
import {useEffect, useState} from "react";
import {useSearchParams} from "react-router-dom";
import GetItem from "../utils/GetItem";
import Motherboard from "../types/pcComponents/Motherboard";
import CPU from "../types/pcComponents/CPU";
import RAM from "../types/pcComponents/RAM";
import Drive from "../types/pcComponents/Drive";

const DrivePage = () => {
    let [drive, setDrive] = useState(null);
    const [searchParams, setSearchParams] = useSearchParams();
    const history = window.history;

    useEffect(() => {
        const id = parseInt(searchParams.get("id"));
        GetItem(id, "drive").then((value) => {
            setDrive(value as Drive);
        });
    }, []);

    return (
        <div className="flex flex-row h-screen accent-gradient justify-around py-6">
            <div className="w-1/3">
                <img src="../res/microchip-svgrepo-com.svg" alt="AltImage" className="invert"/>
            </div>
            <div className="flex flex-col justify-around h-1/3">
                <h1 className="title-text text-5xl">Drive</h1>
                <h2 className="title-text text-3xl">{drive?.name}</h2>
                <h3 className="title-text text-xl">Type: {drive?.type}</h3>
                <h3 className="title-text text-xl">Size: {drive?.gigabytes} GB</h3>
                {
                    drive?.price === 0
                        ? <h2 className="title-text text-4xl">Unavailable now at Dreambuildr</h2>
                        : <h2 className="title-text text-4xl">Estimated cost: {drive?.price} RUB</h2>
                }
                <button className="store-button button" onClick={() => history.back()}>Back to catalogue</button>
            </div>
        </div>
    );
};

export default DrivePage;