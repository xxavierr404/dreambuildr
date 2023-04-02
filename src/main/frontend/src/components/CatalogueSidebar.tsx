import * as React from 'react';

const CatalogueSidebar = () => {
    return (
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
    );
};

export default CatalogueSidebar;