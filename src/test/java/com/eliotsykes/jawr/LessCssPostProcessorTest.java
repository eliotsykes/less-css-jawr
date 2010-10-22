package com.eliotsykes.jawr;

import net.jawr.web.resource.bundle.postprocess.BundleProcessingStatus;
import static org.junit.Assert.*;
import org.junit.Test;

public class LessCssPostProcessorTest {

  private LessCssPostProcessor processor = new LessCssPostProcessor();
  
  private BundleProcessingStatus status = null;
  
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
    StringBuffer output = processor.postProcessBundle(status, new StringBuffer(lessCss));
    assertEquals(expectedCss, output.toString());
  }
}