
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class Driver {

    @Bean(destroyMethod = "quit")
    @Scope("cucumber-glue")

    public WebDriver getDriver() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        return driver;
    }
}






