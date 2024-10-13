interface AnalyseResult {
  topThreeActiveIPs: string[];
  topThreeVisitedUrls: string[];
  uniqueIpCounter: number;
}

interface AnalyseLogfileResponse {
  data: {
    result: AnalyseResult;
  };
}

interface StateVariable {
  topThreeActiveIPs: string[];
  topThreeVisitedUrls: string[];
  uniqueIpCounter: number;
  displaySummary: boolean;
  errorOccurred: boolean;
}

interface ParserStateType extends StateVariable {
  setTopThreeActiveIPs: (ips: string[]) => void;
  setTopThreeVisitedUrls: (urls: string[]) => void;
  setUniqueIpCounter: (count: number) => void;
  setDisplaySummary: (display: boolean) => void;
  setErrorOccurred: (error: boolean) => void;
  resetState: () => void;
}

export type {
  StateVariable,
  AnalyseLogfileResponse,
  AnalyseResult,
  ParserStateType,
};
