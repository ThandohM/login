import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            username.sendKeys("tomsmith");
            password.sendKeys("SecretPassword!");

            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
            if (successMessage.getText().contains("You logged into a secure area!")) {
                System.out.println("Login successful!");
            }

            WebElement logoutButton = driver.findElement(By.cssSelector("a.button.secondary.radius"));
            logoutButton.click();

            WebElement header = driver.findElement(By.tagName("h2"));
            if (header.getText().equals("Login Page")) {
                System.out.println("Logout successful!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
