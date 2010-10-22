package com.eliotsykes.jawr;

import static org.junit.Assert.*;
import org.junit.Test;

public class LessCssResourceGeneratorTest {

  private LessCssResourceGenerator generator = new LessCssResourceGenerator();
  
  @Test public void testLessCssProcessedIntoCss() {
    String lineSep = System.getProperty("line.separator");
    String lessCss =
      "@the-height: 10px;" + lineSep +
      ".style1 {" + lineSep +
      "  height: @the-height;" + lineSep + 
      "}";
    String expectedCss =
      ".style1 {" + lineSep +
      "  height: 10px;" + lineSep + 
      "}";
    fail("Work in progress");
    String pathToLessFile = "/todo/create/file.less";
    String css = generator.generateCssFromLessFile(pathToLessFile);
    assertEquals(expectedCss, css);
  }
}