// import { create } from "zustand";
// import dotenv from 'dotenv';

// interface EnvVarsState {
//   baseAPIUrl: string
// }

// dotenv.config();

const testEnvVars = () => {
  // console.log(process)
  console.log(import.meta);
}
// const useEnvVars = create<EnvVarsState>(() => ({
//   baseAPIUrl: process.env.REACT_APP_BASE_API_URL || 'http://localhost:5173',
// }));

export { testEnvVars };
