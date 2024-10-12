import React from "react";
import { parserStateVars } from "@/hooks/ParserState";

const LogParserSummary = () => {
  const {
    topThreeActiveIPs,
    uniqueIpCounter,
    topThreeVisitedUrls,
    displaySummary,
  } = parserStateVars();

  if (!displaySummary) {
    return null;
  }

  return (
    <>
      <h2>Summary</h2>
      <hr />
      <br />
      <div>
        <p>
          <b>Unique IP Addresses Count: </b> {uniqueIpCounter}
        </p>
        <p>
          <b>Top 3 visited URL: </b>
          <ul>
            {topThreeVisitedUrls.map((url: string, index: number) => (
              <li key={index}>{url}</li>
            ))}
          </ul>
        </p>
        <p>
          <b>Top 3 most active IP Addresses: </b>
          <ul>
            {topThreeActiveIPs.map((ip: string, index: number) => (
              <li key={index}>{ip}</li>
            ))}
          </ul>
        </p>
      </div>
    </>
  );
};

export default LogParserSummary;
