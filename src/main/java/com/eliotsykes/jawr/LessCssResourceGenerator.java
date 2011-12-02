package com.eliotsykes.jawr;

import net.jawr.web.exception.ResourceNotFoundException;
import net.jawr.web.resource.bundle.generator.ResourceGenerator;
import net.jawr.web.resource.bundle.generator.GeneratorContext;
import com.asual.lesscss.LessEngine;
import com.asual.lesscss.LessException;
import net.jawr.web.resource.handler.reader.ServletContextResourceReaderHandler;

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
        File lessFile = new File(path);
        try {
            String css = engine.compile(lessFile);
            return css;
        } catch (LessException e) {
            throw new RuntimeException("Problem compiling Less CSS", e);
        }
    }
}