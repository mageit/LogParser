import { render } from "@/utils/rtl-wrapper";
import React from "react";
import { expect, it } from "vitest";

import App from "@/components/App";

it("check if upload button is exist", () => {
  const { getByTestId } = render(<App />);
  expect(getByTestId("log-file-upload-button")).toBeTruthy();
});
