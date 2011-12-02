# Less CSS for JAWR

Gives the joy of Less CSS (http://lesscss.org) to JAWR (http://jawr.java.net).

Works in both JAWR's debug and production modes. In JAWR's debug mode, changes to your .css and .less files are picked up
with no need to restart your app.

At time of writing, Less CSS for JAWR has been tested with JAWR 3.3.3. Also known to work
with the Grails JAWR plugin (v3.3.3) and Grails 1.3.7. May work with other versions of all of those too.

## How to use
Include the less-css-jawr jar and the Less CSS Engine jar (com.asual.lesscss.lesscss-engine, v1.1.4) on your webapp's classpath.

Add the com.jetbootlabs.jawr.LessCssResourceGenerator to your custom generators, e.g.

    jawr.custom.generators=com.jetbootlabs.jawr.LessCssResourceGenerator,com.something.something.DarkSideGenerator

Use the `less:` prefix with paths to your less files when defining JAWR bundles, e.g.

    jawr.js.bundle.global.id=/bundles/global.js
    jawr.js.bundle.global.mappings=less:path/to/style.less


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
