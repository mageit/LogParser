import { create } from "zustand";
import { ParserStateType } from "@/types/LogParserTypes";

const parserStateVars = create<ParserStateType>((set) => ({
  topThreeActiveIPs: [],
  setTopThreeActiveIPs: (ips: string[]) =>
    set(() => ({ topThreeActiveIPs: ips })),
  topThreeVisitedUrls: [],
  setTopThreeVisitedUrls: (urls: string[]) =>
    set(() => ({ topThreeVisitedUrls: urls })),
  uniqueIpCounter: 0,
  setUniqueIpCounter: (count: number) =>
    set(() => ({ uniqueIpCounter: count })),
  displaySummary: false,
  setDisplaySummary: (display: boolean) =>
    set(() => ({ displaySummary: display })),
}));

export { parserStateVars };
