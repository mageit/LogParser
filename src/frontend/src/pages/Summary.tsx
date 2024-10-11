import React from "react";
import LogParserUploader from "@/components/LogParserUploader";

const Home: React.FC = (): React.ReactElement => {
  return (
    <section>
        <h1>Log Parser Summaruy</h1>
        <p>To begin the analysis, please upload a log file in a <strong>.log</strong> format</p>
        <p>Once you've uploaded a compatible log file, the analysis process will commence automatically.</p>
        <hr /><br />
        <LogParserUploader />
    </section>
  );
};

export default Home;
