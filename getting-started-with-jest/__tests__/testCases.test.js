const admissionStatus = require("../src/admissionStatus");

describe("Test function for Strong Normal", () => {
  test("It should return not eligible for TC01", () => {
    const output = "Not Eligible";
    expect(admissionStatus(70, 60, 60)).toEqual(output);
  });
  test("It should return eligible for TC02", () => {
    const output = "Eligible for normal course";
    expect(admissionStatus(70, 80, 60)).toEqual(output);
  });
  test("It should return not eligible for TC03", () => {
    const output = "Eligible for normal course";
    expect(admissionStatus(70, 70, 80)).toEqual(output);
  });
  test("It should return eligible for TC04", () => {
    const output = "Eligible for scholarship";
    expect(admissionStatus(80, 80, 90)).toEqual(output);
  });
  test("It should return eligible for TC05", () => {
    const output = "Eligible for normal course";
    expect(admissionStatus(70, 80, 70)).toEqual(output);
  });
});

describe("Test function for Weak Robust", () => {
  test("It should return Invalid Marks in Java for TC01", () => {
    const output = "Invalid Marks in Java";
    expect(admissionStatus(-1, 70, 70)).toEqual(output);
  });
  test("It should return Invalid Marks in Java for TC02", () => {
    const output = "Invalid Marks in Java";
    expect(admissionStatus(101, 70, 70)).toEqual(output);
  });
  test("It should return Invalid Marks in C++ for TC03", () => {
    const output = "Invalid Marks in C++";
    expect(admissionStatus(70, -1, 70)).toEqual(output);
  });
  test("It should return Invalid Marks in C++ for TC04", () => {
    const output = "Invalid Marks in C++";
    expect(admissionStatus(70, 101, 70)).toEqual(output);
  });
  test("It should return Invalid Marks in OOAD for TC05", () => {
    const output = "Invalid Marks in OOAD";
    expect(admissionStatus(70, 70, -1)).toEqual(output);
  });
  test("It should return Invalid Marks in OOAD for TC06", () => {
    const output = "Invalid Marks in OOAD";
    expect(admissionStatus(70, 70, 101)).toEqual(output);
  });
  test("It should return Not Elgible for TC07", () => {
    const output = "Not Eligible";
    expect(admissionStatus(70, 80, 50)).toEqual(output);
  });
});

describe("Test function for String Robust", () => {
  test("It should return Invalid Marks in Java for TC01", () => {
    const output = "Invalid Marks in Java";
    expect(admissionStatus(-1, 70, 80)).toEqual(output);
  });
  test("It should return Invalid Marks in Java for TC02", () => {
    const output = "Invalid Marks in C++";
    expect(admissionStatus(70, -1, 70)).toEqual(output);
  });
  test("It should return Invalid Marks in OOAD for TC03", () => {
    const output = "Invalid Marks in OOAD";
    expect(admissionStatus(70, 70, 101)).toEqual(output);
  });
  test("It should return Invalid Marks in JAVA & C++ for TC04", () => {
    const output = "Invalid Marks in Java & C++";
    expect(admissionStatus(-1, -1, 80)).toEqual(output);
  });
  test("It should return Invalid Marks in C++ & OOAD for TC05", () => {
    const output = "Invalid Marks in C++ & OOAD";
    expect(admissionStatus(70, -1, 101)).toEqual(output);
  });
  test("It should return Invalid Marks in Java & OOAD for TC06", () => {
    const output = "Invalid Marks in Java & OOAD";
    expect(admissionStatus(-1, 70, 101)).toEqual(output);
  });
});
