import * as React from 'react';

const ConfigAnalysisResultBlock = (props: {compatible: boolean}) => {
    // TODO: Doesn't work properly - always says incompatible
    return (
        <div className="config-analysis-result-block">
            <h3 className="config-analysis-result-title">Result</h3>
            <p className="config-analysis-result-text">Your configuration is {
                props.compatible
                ? "compatible! :3"
                    : "not yet compatible..."
            }</p>
            <p className="config-analysis-result-subtext">{
                props.compatible
                ? "You're all set! Happy gaming!!"
                    : "The cause of the incompatibility is listed above."
            }</p>
            <a href="/catalogue" className="store-button button">Catalogue &gt;</a>
        </div>
    );
};

export default ConfigAnalysisResultBlock;