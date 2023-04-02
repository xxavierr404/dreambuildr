import * as React from 'react';

const CatalogueItemsGrid = () => {
    return (
        <div className="catalogue-items-grid">
            <div className="flex flex-col items-center bg-gradient-to-br
                    from-blue-600 to-cyan-300 rounded-xl p-3 m-1 gap-3 h-fit">
                <img src="../res/microchip-svgrepo-com.svg" alt="Sample" className="w-1/3"/>
                <div className="text-white font-title text-xl">Gigabyte B450H</div>
                <div className="text-white font-title text-lg">8000 руб.</div>
                <button className="bg-white text-black font-title text-sm font-bold rounded-full ring-2 ring-black
                        px-3 py-1 transition-all hover:scale-110 hover:-rotate-3">Добавить в корзину</button>
            </div>
        </div>
    );
};

export default CatalogueItemsGrid;