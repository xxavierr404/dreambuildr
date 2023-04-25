import * as React from 'react';
import {useEffect, useState} from "react";
import {useSearchParams} from "react-router-dom";
import GetItem from "../utils/GetItem";
import Motherboard from "../types/pcComponents/Motherboard";
import CPU from "../types/pcComponents/CPU";
import RAM from "../types/pcComponents/RAM";

const RAMPage = () => {
    let [ram, setRam] = useState(null);
    const [searchParams, setSearchParams] = useSearchParams();
    const history = window.history;

    useEffect(() => {
        const id = parseInt(searchParams.get("id"));
        GetItem(id, "ram").then((value) => {
            setRam(value as RAM);
        });
    }, []);

    return (
        <div className="flex flex-row h-screen accent-gradient justify-around py-6">
            <div className="w-1/3">
                <img src="../res/microchip-svgrepo-com.svg" alt="AltImage" className="invert"/>
            </div>
            <div className="flex flex-col justify-around h-1/3">
                <h1 className="title-text text-5xl">RAM</h1>
                <h2 className="title-text text-3xl">{ram?.name}</h2>
                <h3 className="title-text text-xl">Type: {ram?.type}</h3>
                <h3 className="title-text text-xl">Frequency: {ram?.frequency} GHz</h3>
                <h3 className="title-text text-xl">Size: {ram?.gigabytes} GB</h3>
                {
                    ram?.price === 0
                        ? <h2 className="title-text text-4xl">Unavailable now at Dreambuildr</h2>
                        : <h2 className="title-text text-4xl">Estimated cost: {ram?.price} RUB</h2>
                }
                <button className="store-button button" onClick={() => history.back()}>Back to catalogue</button>
            </div>
        </div>
    );
};

export default RAMPage;