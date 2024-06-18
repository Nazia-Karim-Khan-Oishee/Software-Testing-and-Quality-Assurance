function admissionStatus(javaMarks, cppMarks, ooadMarks) {
  if (
    (javaMarks <= -1 || javaMarks >= 100) &&
    (cppMarks <= -1 || cppMarks >= 100)
  ) {
    return "Invalid Marks in Java & C++";
  }
  if (
    (ooadMarks <= -1 || ooadMarks >= 100) &&
    (cppMarks <= -1 || cppMarks >= 100)
  ) {
    return "Invalid Marks in C++ & OOAD";
  }
  if (
    (javaMarks <= -1 || javaMarks >= 100) &&
    (ooadMarks <= -1 || ooadMarks >= 100)
  ) {
    return "Invalid Marks in Java & OOAD";
  }
  if (javaMarks <= -1 || javaMarks >= 100) {
    return "Invalid Marks in Java";
  }
  if (cppMarks <= -1 || cppMarks >= 100) {
    return "Invalid Marks in C++";
  }
  if (ooadMarks <= -1 || ooadMarks >= 100) {
    return "Invalid Marks in OOAD";
  }
  if (javaMarks < 70 || cppMarks < 60 || ooadMarks < 60) {
    return "Not Eligible";
  }

  var totalMarks = javaMarks + cppMarks + ooadMarks;

  if (totalMarks >= 220 || javaMarks + cppMarks >= 150) {
    if (totalMarks > 240) {
      return "Eligible for scholarship";
    } else {
      return "Eligible for normal course";
    }
  } else {
    return "Not Eligible";
  }
}

module.exports = admissionStatus;
