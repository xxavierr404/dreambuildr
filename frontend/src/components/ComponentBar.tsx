import * as React from 'react';
import BarTile from "./BarTile";

const ComponentBar = () => {
    return (
        <div className="builder-category-bar">
            <BarTile iconPath={"../res/icons/codesandbox.svg"} title={"Motherboard"}></BarTile>
            <BarTile iconPath={"../res/icons/cpu.svg"} title={"CPU"}></BarTile>
            <BarTile iconPath={"../res/icons/loader.svg"} title={"RAM"}></BarTile>
            <BarTile iconPath={"../res/icons/hard-drive.svg"} title={"HDD/SSD"}></BarTile>
            <BarTile iconPath={"../res/icons/zap.svg"} title={"PU"}></BarTile>
            <BarTile iconPath={"../res/icons/video.svg"} title={"Videocard"}></BarTile>
        </div>
    );
};

export default ComponentBar;