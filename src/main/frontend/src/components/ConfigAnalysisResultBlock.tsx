import * as React from 'react';

const ConfigAnalysisResultBlock = () => {
    return (
        <div className="config-analysis-result-block">
            <h3 className="config-analysis-result-title">Result</h3>
            <p className="config-analysis-result-text">Your configuration is compatible!</p>
            <p className="config-analysis-result-subtext">Don't forget to get some periphery.</p>
            <a href="/catalogue" className="store-button button">Catalogue &gt;</a>
        </div>
    );
};

export default ConfigAnalysisResultBlock;