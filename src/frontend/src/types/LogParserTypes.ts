interface AnalyseResult {
    topThreeActiveIPs: String[];
    topThreeVisitedUrls: String[];
    uniqueIpCounter: number;
}

interface AnalyseLogfileResponse {
    data: {
        result: AnalyseResult;
    }
}

interface ParserStateType {
    topThreeActiveIPs: String[];
    setTopThreeActiveIPs: (ips: String[]) => void;
    topThreeVisitedUrls: String[];
    setTopThreeVisitedUrls: (urls: String[]) => void;
    uniqueIpCounter: number;
    setUniqueIpCounter: (count: number) => void;
}

export type {
    AnalyseLogfileResponse,
    AnalyseResult,
    ParserStateType,
};