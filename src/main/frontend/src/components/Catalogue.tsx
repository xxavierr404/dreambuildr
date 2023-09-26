import * as React from 'react';
import CatalogueItemsGrid from "./CatalogueItemsGrid";
import CatalogueSidebar from "./CatalogueSidebar";
import {Dispatch, useEffect, useState} from "react";
import LoadCatalogue from "../utils/LoadCatalogue";
import Item from "../types/pcComponents/Item";

export type FilterDispatchers = {
    price: Dispatch<any>,
    socket: Dispatch<any>,
}

const Catalogue = () => {
    const [items, setItems] = useState([]);
    const [pageNumber, setPage] = useState(0);
    const [type, setType] = useState("motherboard");
    const [fullCatalogue, setCatalogue] = useState([]);
    const [currentCatalogue, setCurrent] = useState([]);
    const [sortType, setSortType] = useState("name");
    const [sortOrder, setSordOrder] = useState("asc");
    const [searchText, setSearchText] = useState("");
    const [priceLimit, setPriceLimit] = useState(0);

    const [socketFilter, setSocket] = useState("none");

    const filters: FilterDispatchers = {
        price: setPriceLimit,
        socket: setSocket,

    }

    const pageSize: number = 9;

    useEffect(() => {
        LoadCatalogue(type)
            .then((value) => {
                setCatalogue(value);
            });
        setPage(0);
    }, [type]);

    useEffect(() => {
        setItems(currentCatalogue.slice(pageNumber * pageSize, (pageNumber + 1) * pageSize));
    }, [pageNumber, fullCatalogue, currentCatalogue, sortType, sortOrder]);

    useEffect(() => {
        console.log(fullCatalogue);
        setCurrent(fullCatalogue.sort((o1: Item, o2: Item) => {
            if (sortType === "name") {
                if (sortOrder === "asc") {
                    return o1.name.localeCompare(o2.name);
                } else {
                    return o1.name.localeCompare(o2.name) * -1;
                }
            } else if (sortOrder === "asc") {
                return o1.price > o2.price ? 1 : -1;
            } else {
                return o1.price < o2.price ? 1 : -1;
            }
        }));

        if (searchText.length > 0) {
            setCurrent(currentCatalogue.filter((obj) => {
                return obj.name.toLowerCase().includes(searchText.toLowerCase());
            }));
        }

        // if (priceLimit > 0) {
        //     console.log("filtering by price");
        //     console.log(currentCatalogue);
        //     setCurrent(currentCatalogue.filter((obj) => {
        //         return obj.price <= priceLimit;
        //     }));
        //     console.log(currentCatalogue);
        // }

        setPage(0);
        setItems(currentCatalogue.slice(pageNumber * pageSize, (pageNumber + 1) * pageSize));
    }, [sortType, sortOrder, type, searchText, fullCatalogue, priceLimit]);

    return (
        <div className="catalogue-body">
            <div className="centered-flex">
                <h3 className="styled-text text-white">Catalogue</h3>
            </div>
            <div className="catalogue-grid">
                <CatalogueSidebar type={type}
                                  setType={setType}
                                  setSortType={setSortType}
                                  setSortOrder={setSordOrder}
                                  setSearchText={setSearchText}
                                  filterDispatchers={filters}/>
                <CatalogueItemsGrid items={items}
                                    type={type}></CatalogueItemsGrid>
            </div>
            <div className="flex flex-row justify-around w-full py-3">
                {
                    pageNumber > 0
                    ? <button className="catalogue-page-button" onClick={() => setPage(pageNumber - 1)}>
                            {"< Previous page"}
                    </button>
                        : ""
                }
                {
                    items.length === 9
                    ? <button className="catalogue-page-button" onClick={() => setPage(pageNumber + 1)}>
                            {"Next page >"}
                    </button>
                        : ""
                }
            </div>
        </div>
    );
};

export default Catalogue;