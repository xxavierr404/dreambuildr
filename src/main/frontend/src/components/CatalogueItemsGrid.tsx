import * as React from 'react';
import CatalogueItemTile from "./CatalogueItemTile";
import Item from "../types/pcComponents/Item";

const CatalogueItemsGrid = (props: {items: Item[], type: string}) => {
    return (
        <div className="catalogue-items-grid">
            {
                props.items.map(value => {return <CatalogueItemTile id={value.id}
                                                                    name={value.name}
                                                                    price={value.price}
                                                                    type={props.type}/>})
            }
        </div>
    );
};

export default CatalogueItemsGrid;