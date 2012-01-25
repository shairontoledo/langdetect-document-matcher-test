##Language detection using pdf documents

This is a set of test for detect tika extracted documents. Add more files to /docs/{lang}, the test will load them automatically.

### Current support

* Portuguese
* English
* French
* German
* Dutch
* Italian 
* Spanish
* Korean 
* Simplified Chinese
* Traditional Chinese
* Japanese

##Install 

Install [langdetect.jar](http://code.google.com/p/language-detection/) manually 

    mvn install:install-file -Dfile=lib/langdetect.jar -DgroupId=com.cybozu.labs.langdetect -DartifactId=langdetect -Dversion=1.0 -Dpackaging=jar

The others dependencies will be installed by Maven.

## Two steps to add your language

Create a directory under `docs/{langX}`, add some document to it and then create a new test method.

    @Test
    public void LanguageX() throws Exception {
      genericTest("Language X", "lang-x");
    }

##Running 

    export JAVA_OPTS=-Djava.awt.headless=true
    mvn test
    
##Log Output



    -------------------------------------------------------
     T E S T S
    -------------------------------------------------------
    Running TestSuite
    [INFO ][LangMatcherTest] Setup
    [INFO ][LangMatcherTest] Loading lang detector
    [INFO ][LangMatcherTest] Loading tika
    [INFO ][LangMatcherTest] Language Dutch(nl): loading
    [INFO ][LangMatcherTest] Language Dutch(nl): 9 files
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/bereikbaarkaart-nl_print.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/de_bodem_onder_amsterdam.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/Economische verkenningen MRA2011_tcm14-228419.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/How To Reach Amsterdam RAI.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/IBM_Amsterdam_HDK.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/kwaliteitswijzer_291111_web_def.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/mas0.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/route-oracle-amsterdam1-157087-nl.pdf
    [INFO ][LangMatcherTest] Language Dutch(nl): docs/nl/{00C1E905-406C-490B-8079-5B9DCA9927BA}_C_NED.pdf
    [INFO ][LangMatcherTest] Language English(en): loading
    [INFO ][LangMatcherTest] Language English(en): 8 files
    [INFO ][LangMatcherTest] Language English(en): docs/en/188741.pdf
    [INFO ][LangMatcherTest] Language English(en): docs/en/Article33.pdf
    [INFO ][LangMatcherTest] Language English(en): docs/en/BOSTmap.pdf
    [INFO ][LangMatcherTest] Language English(en): docs/en/ff-boston_tcm7-4572.pdf
    [INFO ][LangMatcherTest] Language English(en): docs/en/file84471.pdf
    [INFO ][LangMatcherTest] Language English(en): docs/en/InformingTheDebate_Final.pdf
    [INFO ][LangMatcherTest] Language English(en): docs/en/preven_code_tcm3-4039.pdf
    [INFO ][LangMatcherTest] Language English(en): docs/en/STATEOFBLACKBOSTON_000.pdf
    [INFO ][LangMatcherTest] Language French(fr): loading

## Dump files
When the test passes to the language you can get extracted text in `dump` directory in the root of the project.

    dump/nl
    dump/nl/bereikbaarkaart-nl_print.pdf.txt
    dump/nl/de_bodem_onder_amsterdam.pdf.txt
    dump/nl/Economische verkenningen MRA2011_tcm14-228419.pdf.txt
    dump/nl/How To Reach Amsterdam RAI.pdf.txt
    dump/nl/IBM_Amsterdam_HDK.pdf.txt
    dump/nl/kwaliteitswijzer_291111_web_def.pdf.txt
    dump/nl/mas0.pdf.txt
    dump/nl/route-oracle-amsterdam1-157087-nl.pdf.txt
    dump/nl/{00C1E905-406C-490B-8079-5B9DCA9927BA}_C_NED.pdf.txt
    dump/en
    dump/en/188741.pdf.txt
    dump/en/Article33.pdf.txt
    dump/en/BOSTmap.pdf.txt
    dump/en/ff-boston_tcm7-4572.pdf.txt
    dump/en/file84471.pdf.txt
    dump/en/InformingTheDebate_Final.pdf.txt
    dump/en/preven_code_tcm3-4039.pdf.txt
    dump/en/STATEOFBLACKBOSTON_000.pdf.txt



