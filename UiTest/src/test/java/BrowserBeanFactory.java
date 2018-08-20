
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("unused")
@Configuration
@Profile("web")
public class BrowserBeanFactory {


    private String deviceReadyTimeout;


    @Bean(destroyMethod = "quit")
    @Scope("cucumber-glue")
    @BeforeTest
    public  WebDriver getDriver() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        return driver;
    }

}
