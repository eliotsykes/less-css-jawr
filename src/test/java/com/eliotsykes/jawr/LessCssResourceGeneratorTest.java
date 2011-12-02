package com.eliotsykes.jawr;

import static org.junit.Assert.*;

import org.junit.Test;

public class LessCssResourceGeneratorTest {

    private LessCssResourceGenerator generator = new LessCssResourceGenerator();

    @Test
    public void testLessCssProcessedIntoCss() {
        String lineSep = System.getProperty("line.separator");
        String expectedCss =
                ".style1 {" + lineSep +
                        "  height: 10px;" + lineSep +
                        "}" + lineSep;
        String pathToLessFile = "src/test/resources/test.less";
        String css = generator.generateCssFromLessFile(pathToLessFile);
        assertEquals(expectedCss, css);
    }

    @Test
    public void testNonStyleFileExtensionsThrowSecurityException() {
        String[] nonStylePaths = {"WEB-INF/web.xml", "/some/path/secret.less.txt", "/tmp/moresecrets.css.yml"};
        for (int i = 0; i < nonStylePaths.length; i++) {
            String path = nonStylePaths[i];
            try {
                generator.generateCssFromLessFile(path);
                fail("Exception should have been thrown for non-style path '" + path + "'");
            } catch (SecurityException e) {
            }
        }
    }


}