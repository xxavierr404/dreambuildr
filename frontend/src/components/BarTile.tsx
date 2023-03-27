import * as React from 'react';

type Props = {
    iconPath: string,
    title: string,
    status: boolean,
}

const BarTile = (props: Props) => {
    return (
        <div className={`builder-bar-tile ${props.status ? 'builder-bar-tile-valid' : 'builder-bar-tile-invalid'}`}>
            <div className="builder-bar-tile-title">
                <img className="h-5 filter invert" src={props.iconPath} alt={props.title[0]}></img>
                <p className="builder-bar-tile-title-text">{props.title}</p>
            </div>
        </div>
    );
};

export default BarTile;