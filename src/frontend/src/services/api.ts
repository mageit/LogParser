import axios from "axios";
import { AnalyseLogfileResponse } from "@/types/LogParserTypes";

export const analyseLogfile = async (file: File) => {
  const formData = new FormData();
  formData.append("logFile", file);

  try {
    const response: AnalyseLogfileResponse = await axios.post(
      "http://localhost:8080/api/v1/parse",
      formData,
      {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      },
    );
    return response.data.result;
  } catch (error) {
    throw new Error(error);
  }
};
