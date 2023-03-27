import * as React from 'react';

type Props = {
    iconPath: string,
    title: string,
}

const BarTile = (props: Props) => {
    return (
        <div className="builder-bar-tile">
            <div className="builder-bar-tile-title">
                <img className="h-5 filter invert" src={props.iconPath} alt={props.title[0]}></img>
                <p className="builder-bar-tile-title-text">{props.title}</p>
            </div>
        </div>
    );
};

export default BarTile;