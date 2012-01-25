package net.hashcode.langmacher;

import org.apache.tika.Tika;
import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import java.io.File;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static java.lang.String.*;
/*
 * @autor shairon toledo
 */
public class LangMatcherTest {

  private static final Logger log = Logger.getLogger(LangMatcherTest.class);
  private static final Tika tika = new Tika();

  @BeforeClass
  public void setupNode() throws Exception {
    log.info("Setup log");
    File langProfiles = getFile("profiles");
    assertThat(langProfiles.exists(), is(true));
    DetectorFactory.loadProfile(langProfiles);

    log.info("Loading lang detector");
    assertThat(detect("Cachorro? Sou cachorro não"), equalTo("pt"));

    log.info("Loading tika");
    String text = getText("pt", "goiania.pdf");
    assertThat(text, notNullValue());
    assertThat(detect(text), equalTo("pt"));
  }

  public void genericTest(String name, String langName) throws Exception{
    String langMsg = format("Language %s(%s): ",name,langName);
    
    log.info(langMsg+"loading");
    String dir = String.format("docs/%s/", langName);
    
    File fs[] = getFile(dir).listFiles();
    log.info(langMsg+fs.length+" files");
    for (File file : fs) {

      log.info(langMsg + dir + file.getName());
      String text = extract(file);
      assertThat(text, notNullValue());
      assertThat(detect(text), equalTo(langName));
    }

  }

  @Test
  public void Portuguese() throws Exception {
    genericTest("Portuguese", "pt");
  }
  
  @Test
  public void English() throws Exception {
    genericTest("English", "en");
  }
  @Test
  public void French() throws Exception {
    genericTest("French", "fr");
  }
  @Test
  public void German() throws Exception {
    genericTest("German", "de");
  }
  @Test
  public void Dutch() throws Exception {
    genericTest("Dutch", "nl");
  }
  @Test
  public void Italian() throws Exception {
    genericTest("Italian", "it");
  }
  
  @Test
  public void Spanish() throws Exception {
    genericTest("Spanish", "en");
  }
  
  @Test
  public void Korean() throws Exception {
    genericTest("Korean", "ko");
  }
 
  @Test
  public void SimplifiedChinese() throws Exception {
    genericTest("Simplified Chinese", "zh-cn");
  }
  
  @Test
  public void TraditionalChinese() throws Exception {
    genericTest("Traditional Chinese", "zh-tw");
  }
  
  @Test
  public void Japanese() throws Exception {
    genericTest("Japanese", "ja");
  }

  public static String detect(String text) throws Exception {
    Detector detector = DetectorFactory.create();
    detector.append(text);
    return detector.detect();
  }

  private String getPath(String resourceName) {
    return ClassLoader.getSystemResource(resourceName).getPath();
  }

  private File getFile(String resourceName) {
    return new File(getPath(resourceName));
  }

  private String getText(String langDir, String resourceName) throws Exception {
    return extract(new File(getPath("docs/" + langDir), resourceName));
  }

  private String extract(File file) throws Exception {
    return tika.parseToString(file);
  }
}
