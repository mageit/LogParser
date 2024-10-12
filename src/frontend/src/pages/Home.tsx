import React from "react";
import LogParserUploader from "@/components/LogParserUploader";
import LogParserSummary from "@/components/LogParserSummary";

const Home: React.FC = (): React.ReactElement => {
  return (
    <section>
      <h1>Welcome to Log Parser!</h1>
      <p>
        To begin the analysis, please upload a log file in a{" "}
        <strong>.log</strong> format
      </p>
      <p>
        Once you&apos;ve uploaded a compatible log file, the analysis process will
        commence automatically.
      </p>
      <hr />
      <br />
      <LogParserUploader />
      <LogParserSummary />
    </section>
  );
};

export default Home;
