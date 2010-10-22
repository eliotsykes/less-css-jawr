package com.eliotsykes.jawr;

import net.jawr.web.resource.bundle.postprocess.BundleProcessingStatus;
import net.jawr.web.resource.bundle.postprocess.ResourceBundlePostProcessor;
import com.asual.lesscss.LessEngine;
import com.asual.lesscss.LessException;

/**
 *  WARNING: Less CSS processing should probably not happen here as post
 *  processors do not get run when jawr debug mode is on. Consider deleting this
 *  class.
 */
public class LessCssPostProcessor implements ResourceBundlePostProcessor {
  
  private LessEngine engine = new LessEngine();
  
  public LessCssPostProcessor() {
  }
  
  public StringBuffer postProcessBundle(BundleProcessingStatus status, StringBuffer bundleString) {
    try {
      String output = engine.compile(bundleString.toString());
      return new StringBuffer(output.trim());
    } catch (LessException e) {
      throw new RuntimeException("Problem compiling Less CSS", e);
    }
  }
}