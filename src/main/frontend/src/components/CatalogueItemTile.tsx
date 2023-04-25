import * as React from 'react';
import { setCookie } from 'typescript-cookie';

const CatalogueItemTile = (props: {id: number, name: string, price: number, type: string}) => {
    return (
        <button className="catalogue-item-tile"
                onClick={() => window.location.href=`/catalogue/${props.type}?id=${props.id}`}>
            <img src="../res/microchip-svgrepo-com.svg" alt="Sample" className="w-1/3"/>
            <div className="text-white font-title text-xl">{
                props.name.length < 20
                    ? props.name
                    : props.name.slice(0, 20) + '...'
            }</div>
            <div className="text-white font-title text-lg">
                {
                    props.price === 0
                    ? 'Out of stock'
                        : props.price.toString() + ' RUB'
                }
            </div>
            {/*{*/}
            {/*    props.price !== 0*/}
            {/*        ? <button className="catalogue-item-button">*/}
            {/*            Add to cart*/}
            {/*        </button>*/}
            {/*        : <button className="catalogue-item-button-disabled" disabled={true}>*/}
            {/*            Unavailable :(*/}
            {/*        </button>*/}
            {/*}*/}

            <button className="catalogue-item-button" onClick={(e) => {
                setCookie(props.type, props.id);
                e.stopPropagation();
            }}>
                Add to configurer
            </button>
        </button>
    );
}

export default CatalogueItemTile;