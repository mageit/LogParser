import React from "react";
import {parserStateVars} from "@/hooks/ParserState";

const LogParserSummary = () => {
    const {topThreeActiveIPs, uniqueIpCounter, topThreeVisitedUrls} = parserStateVars();
    return (
        <>
            <h2>Summary</h2>
            <hr /><br />
            <div>
                <p><b>Unique IP Addresses Count: </b> {uniqueIpCounter}</p>
                <p><b>Top 3 visited URL: </b>{topThreeVisitedUrls}</p>
                <p><b>Top 3 most active IP Addresses: </b>{topThreeActiveIPs}</p>
            </div>
        </>
    );
}

export default LogParserSummary;
