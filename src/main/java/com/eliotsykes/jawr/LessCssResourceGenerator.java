package com.eliotsykes.jawr;

import net.jawr.web.resource.bundle.generator.ResourceGenerator;
import net.jawr.web.resource.bundle.generator.GeneratorContext;
import com.asual.lesscss.LessEngine;
import com.asual.lesscss.LessException;
import java.io.Reader;
import java.io.StringReader;
import java.io.File;

/**
 *  WORK IN PROGRESS!
 *  WARNING: Need to find out if generators get run on every request when
 *  jawr debug mode is on. If not then may need to find alternate solution.
 */
public class LessCssResourceGenerator implements ResourceGenerator {
  
  private LessEngine engine = new LessEngine();
  
  public String getMappingPrefix() {
    return "less";
  }
  
  public String getDebugModeRequestPath() {
    return ResourceGenerator.CSS_DEBUGPATH;
  }
  
  public Reader createResource(GeneratorContext context) {
    String pathToLessFile = context.getPath();
    String css = generateCssFromLessFile(pathToLessFile);
    return new StringReader(css);
  }
  
  public String generateCssFromLessFile(String path) {
    File lessFile = new File(path);
    try {
      String css = engine.compile(lessFile);
      return css;
    } catch (LessException e) {
      throw new RuntimeException("Problem compiling Less CSS", e);
    }
  }
}