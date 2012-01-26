# Less CSS for JAWR

Project home: https://github.com/eliotsykes/less-css-jawr

Gives the joy of Less CSS (http://lesscss.org) to JAWR (http://jawr.java.net).

Works in both JAWR's debug and production modes. In JAWR's debug mode, changes to your .css and .less files are picked up
with no need to restart your app.

At time of writing, Less CSS for JAWR has been tested with JAWR 3.3.3. Also known to work
with the Grails JAWR plugin (v3.3.3) and Grails 1.3.7. May work with other versions of all of those too.

If you'd like to see Less CSS support built-in to JAWR, please take a moment to vote for issue #199 on the JAWR
Jira: http://java.net/jira/browse/JAWR-199

## How to use
Include the `less-css-jawr-[VERSION].jar` (find it in the same directory as this README) and the Less CSS Engine jar
(com.asual.lesscss.lesscss-engine, v1.1.4) on your webapp's classpath.

Add the `com.jetbootlabs.jawr.LessCssResourceGenerator` to your custom generators, e.g.

    jawr.custom.generators=com.jetbootlabs.jawr.LessCssResourceGenerator,com.something.something.DarkSideGenerator

Use the `less:` prefix with paths to your less files when defining JAWR bundles, e.g.

    jawr.css.bundle.global.id=/bundles/global.css
    jawr.css.bundle.global.mappings=less:path/to/style.less


## Developing

* Checkout less-css-jawr from git
* `cd less-css-jawr/`
* `gradle idea` to set up IntelliJ IDE config
* `gradle build` to build project
* `gradle tasks` to list available gradle tasks

## Contributors

* Eliot Sykes
* Zsolt Varszegi

Contributions welcome
