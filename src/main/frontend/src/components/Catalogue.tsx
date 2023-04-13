import * as React from 'react';
import CatalogueItemsGrid from "./CatalogueItemsGrid";
import CatalogueSidebar from "./CatalogueSidebar";
import {useEffect, useState} from "react";
import LoadCatalogue from "../utils/LoadCatalogue";

const Catalogue = () => {
    const [items, setItems] = useState([]);
    const [pageNumber, setPage] = useState(0);
    const [type, setType] = useState("motherboard");
    const pageSize: number = 9;

    useEffect(() => {
        LoadCatalogue(type, 1 + pageNumber * pageSize, (pageNumber + 1) * pageSize)
            .then((value) => setItems(value))
    }, [pageNumber, type]);

    useEffect(() => {
        setPage(0);
    }, [type])

    return (
        <div className="catalogue-body">
            <div className="centered-flex">
                <h3 className="styled-text text-white">Catalogue</h3>
            </div>
            <div className="catalogue-grid">
                <CatalogueSidebar type={type} setType={setType}></CatalogueSidebar>
                <CatalogueItemsGrid items={items} type={type}></CatalogueItemsGrid>
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