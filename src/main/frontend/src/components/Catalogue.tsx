import * as React from 'react';
import CatalogueItemsGrid from "./CatalogueItemsGrid";
import CatalogueSidebar from "./CatalogueSidebar";

const Catalogue = () => {
    return (
        <div className="catalogue-body">
            <div className="centered-flex">
                <h3 className="styled-text text-white">Catalogue</h3>
            </div>
            <div className="catalogue-grid">
                <CatalogueSidebar></CatalogueSidebar>
                <CatalogueItemsGrid></CatalogueItemsGrid>
            </div>
        </div>
    );
};

export default Catalogue;