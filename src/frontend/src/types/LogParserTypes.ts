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

interface ParserStateType {
  topThreeActiveIPs: string[];
  setTopThreeActiveIPs: (ips: string[]) => void;
  topThreeVisitedUrls: string[];
  setTopThreeVisitedUrls: (urls: string[]) => void;
  uniqueIpCounter: number;
  setUniqueIpCounter: (count: number) => void;
  displaySummary: boolean;
  setDisplaySummary: (display: boolean) => void;
}

export type { AnalyseLogfileResponse, AnalyseResult, ParserStateType };
