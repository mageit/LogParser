import { create } from "zustand";
import {ParserStateType} from "@/types/LogParserTypes";

const parserStateVars = create<ParserStateType>((set) => ({
    topThreeActiveIPs: [],
    setTopThreeActiveIPs: (ips: String[]) => set(() => ({ topThreeActiveIPs: ips })),
    topThreeVisitedUrls: [],
    setTopThreeVisitedUrls: (urls: String[]) => set(() => ({ topThreeVisitedUrls: urls })),
    uniqueIpCounter: 0,
    setUniqueIpCounter: (count: number) => set(() => ({ uniqueIpCounter: count })),
}));

export { parserStateVars };
