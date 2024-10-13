import React from "react";
import LogParserUploader from "@/components/LogParserUploader";
import LogParserSummary from "@/components/LogParserSummary";
import { parserStateVars } from "@/hooks/ParserState";

const Home: React.FC = (): React.ReactElement => {
  const { errorOccurred } = parserStateVars();

  return (
    <section>
      <h1>Welcome to Log Parser!</h1>
      <p>
        To begin the analysis, please upload a log file in a{" "}
        <strong>.log</strong> format
      </p>
      <p>
        Once you&apos;ve uploaded a compatible log file, the analysis process
        will commence automatically.
      </p>
      <p>
        <b>Download the sample data: </b>
        <a href="/sample/sample-data.log" download>
          sample-data.log
        </a>
      </p>
      <hr />
      <br />
      <LogParserUploader />
      {errorOccurred ? (
        <div>
          <br />
          Something went wrong, please try again later
        </div>
      ) : (
        <LogParserSummary />
      )}
    </section>
  );
};

export default Home;
