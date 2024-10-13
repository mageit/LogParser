import { create } from "zustand";
import { ParserStateType } from "@/types/LogParserTypes";
import { StateVariable } from "@/types/LogParserTypes";
const initialState: StateVariable = {
  topThreeActiveIPs: [],
  topThreeVisitedUrls: [],
  uniqueIpCounter: 0,
  displaySummary: false,
  errorOccurred: false,
};

const parserStateVars = create<ParserStateType>((set) => ({
  ...initialState,
  setTopThreeActiveIPs: (ips: string[]) =>
    set(() => ({ topThreeActiveIPs: ips })),
  setTopThreeVisitedUrls: (urls: string[]) =>
    set(() => ({ topThreeVisitedUrls: urls })),
  setUniqueIpCounter: (count: number) =>
    set(() => ({ uniqueIpCounter: count })),
  setDisplaySummary: (display: boolean) =>
    set(() => ({ displaySummary: display })),
  setErrorOccurred: (error: boolean) => set(() => ({ errorOccurred: error })),
  resetState: () => set(() => ({ ...initialState })),
}));

export { parserStateVars };
