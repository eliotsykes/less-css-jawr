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


}