import * as React from 'react';
import {useEffect, useState} from "react";
import {useSearchParams} from "react-router-dom";
import GetItem from "../utils/GetItem";
import Motherboard from "../types/pcComponents/Motherboard";
import CPU from "../types/pcComponents/CPU";

const CPUPage = () => {
    let [cpu, setCPU] = useState(null);
    const [searchParams, setSearchParams] = useSearchParams();
    const history = window.history;

    useEffect(() => {
        const id = parseInt(searchParams.get("id"));
        GetItem(id, "cpu").then((value) => {
            setCPU(value as CPU);
        });
    }, []);

    return (
        <div className="flex flex-row h-screen accent-gradient justify-around py-6">
            <div className="w-1/3">
                <img src="../res/microchip-svgrepo-com.svg" alt="AltImage" className="invert"/>
            </div>
            <div className="flex flex-col justify-around h-1/3">
                <h1 className="title-text text-5xl">CPU</h1>
                <h2 className="title-text text-3xl">{cpu?.name}</h2>
                <h3 className="title-text text-xl">Socket: {cpu?.socketType}</h3>
                <h3 className="title-text text-xl">Frequency: {cpu?.frequency} GHz</h3>
                {
                    cpu?.price === 0
                        ? <h2 className="title-text text-4xl">Unavailable now at Dreambuildr</h2>
                        : <h2 className="title-text text-4xl">Estimated cost: {cpu?.price} RUB</h2>
                }
                <button className="store-button button" onClick={() => history.back()}>Back to catalogue</button>
            </div>
        </div>
    );
};

export default CPUPage;