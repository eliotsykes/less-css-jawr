package com.eliotsykes.jawr;

import net.jawr.web.resource.bundle.generator.ResourceGenerator;
import net.jawr.web.resource.bundle.generator.GeneratorContext;
import com.asual.lesscss.LessEngine;
import com.asual.lesscss.LessException;

import java.io.Reader;
import java.io.StringReader;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

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
        URL resource = null;
        try {
            resource = context.getServletContext().getResource(pathToLessFile);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Less file invalid path '" + pathToLessFile + "'", e);
        }
        if (null == resource) {
            throw new IllegalArgumentException("Less file not found at '" + pathToLessFile + "'");
        }
        String css = generateCssFromLessFile(resource.getPath());
        return new StringReader(css);
    }

    public String generateCssFromLessFile(String path) {
        if (!path.toLowerCase().endsWith(".less") && !path.toLowerCase().endsWith(".css")) {
            throw new SecurityException("Attempt to read non-style file '" + path + "' was made in an odd place, mmm...");
        }
        File lessFile = new File(path);
        try {
            String css = engine.compile(lessFile);
            return css;
        } catch (LessException e) {
            throw new RuntimeException("Problem compiling Less CSS from file '" + path + "'", e);
        }
    }
}