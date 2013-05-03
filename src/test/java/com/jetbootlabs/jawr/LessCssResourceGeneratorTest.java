package com.jetbootlabs.jawr;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LessCssResourceGeneratorTest {

    private LessCssResourceGenerator generator = new LessCssResourceGenerator();

    @Test
    public void testLessCssUrlProcessedIntoCss() throws MalformedURLException {
        String lineSep = System.getProperty("line.separator");
        String expectedCss =
                ".style1 {" + lineSep +
                        "  height: 10px;" + lineSep +
                        "}" + lineSep;
        String pathToLessFile = "src/test/resources/test.less";
        URL urlToLessFile = new File(pathToLessFile).toURI().toURL();
        String css = generator.generateCssFromLessFile(urlToLessFile);
        assertEquals(expectedCss.replaceAll("\r", ""), css.replaceAll("\r", ""));
    }

    @Test
    public void testNonStyleFileExtensionsThrowSecurityException() throws MalformedURLException {
        String[] nonStylePaths = {"WEB-INF/web.xml", "/some/path/secret.less.txt", "/tmp/moresecrets.css.yml"};
        for (int i = 0; i < nonStylePaths.length; i++) {
            String path = nonStylePaths[i];
            try {
                URL url = new File(path).toURI().toURL();
                generator.generateCssFromLessFile(url);
                fail("Exception should have been thrown for non-style path '" + path + "'");
            } catch (SecurityException e) {
            }
        }
    }


}