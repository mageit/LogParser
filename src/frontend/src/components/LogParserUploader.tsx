import React from "react";
import { analyseLogfile } from "@/services/api";
import { AnalyseResult } from "@/types/LogParserTypes";
import { parserStateVars } from "@/hooks/ParserState";

const LogParserUploader = () => {
  const [file, setFile] = React.useState<File | null>(null);
  const [isBusy, setIsBusy] = React.useState(false);
  const {
    setTopThreeActiveIPs,
    setTopThreeVisitedUrls,
    setUniqueIpCounter,
    setDisplaySummary,
    setErrorOccurred,
    resetState,
  } = parserStateVars();

  const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    if (event.target.files) {
      setFile(event.target.files[0]);
    }
  };

  const handleReset = () => {
    resetState();
    setFile(null);
    setIsBusy(false);
  };

  const handleUpload = async () => {
    try {
      resetState();
      setIsBusy(true);
      const result: AnalyseResult | undefined = await analyseLogfile(
        file as File,
      );
      if (result) {
        setTopThreeActiveIPs(result.topThreeActiveIPs);
        setTopThreeVisitedUrls(result.topThreeVisitedUrls);
        setUniqueIpCounter(result.uniqueIpCounter);
      }
      setIsBusy(false);
      setDisplaySummary(true);
    } catch (error) {
      console.log("error:", error);
      setErrorOccurred(true);
    } finally {
      setIsBusy(false);
    }
  };

  return (
    <>
      <div className="uploader">
        <input
          type="file"
          accept=".log"
          onChange={handleFileChange}
          data-testid="log-file-upload-button"
        />
        <button onClick={handleReset}>Reset</button>
      </div>
      {file && (
        <section>
          <br />
          Selected log file details:
          <ul>
            <li>Name: {file.name}</li>
            <li>Size: {file.size} bytes</li>
          </ul>
        </section>
      )}

      {file && !isBusy && (
        <button onClick={handleUpload} disabled={isBusy}>
          Start Analyse
        </button>
      )}

      {isBusy && <p>Processing...</p>}
    </>
  );
};

export default LogParserUploader;
