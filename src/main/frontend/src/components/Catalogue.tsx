import * as React from 'react';

const Catalogue = () => {
    return (
        <div className="catalogue-body">
            <div className="centered-flex">
                <h3 className="styled-text text-white">Catalogue</h3>
            </div>
            <div className="catalogue-grid">
                <div className="bg-white rounded-xl flex flex-col items-center gap-2">
                    <h2 className="styled-text pt-3 font-extrabold">Filters</h2>
                    <h3 className="font-title text-2xl font-bold tracking-widest italic">Categories</h3>
                    <button className="category-button">Motherboards</button>
                    <button className="category-button">CPUs</button>
                    <button className="category-button">RAM</button>
                    <button className="category-button">Power units</button>
                    <button className="category-button">HDDs/SSDs</button>
                    <button className="category-button">Video cards</button>
                    <h3 className="font-title text-2xl font-bold tracking-widest italic">Sorting by</h3>
                    <select name="sort-parameter" id="sort-parameter" className="sort-dropdown">
                        <option value="name">Name</option>
                        <option value="price">Price</option>
                    </select>
                    <select name="sort-order" id="sort-order" className="sort-dropdown">
                        <option value="asc">Ascending</option>
                        <option value="desc">Descending</option>
                    </select>
                    <h3 className="font-title text-2xl font-bold tracking-widest italic">Filter properties</h3>
                </div>
                <div className="col-span-3 bg-white rounded-xl grid grid-cols-4 grid-rows-5 gap-5">
                    <div className="flex flex-col items-center bg-gradient-to-br
                    from-blue-600 to-cyan-300 rounded-xl m-3 gap-3 flex-shrink">
                        <img src="../res/microchip-svgrepo-com.svg" alt="Sample" className="h-1/3 m-3"/>
                        <div className="text-white font-title text-xl">Gigabyte B450H</div>
                        <div className="text-white font-title text-lg">8000 руб.</div>
                        <button className="bg-white text-black font-title font-bold rounded-full ring-2 ring-black
                        px-3 py-1 transition-all hover:scale-110 hover:-rotate-3">Добавить в корзину</button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Catalogue;