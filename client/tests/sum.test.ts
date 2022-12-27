import {describe, expect, test} from "@jest/globals";
import {sum} from "./sum";

describe("sum module", (): void => {
  test("adds 1 + 2 to equal 3", (): void => {
    expect(sum(1, 2)).toBe(3);
  });
});