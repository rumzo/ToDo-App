package pages;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToDoListPage extends BasePage {

    private static final String pageTitle = "ToDo List";
    private static final String pageDescription = "This is your personal todo list";

    private static final By SUMMARY_FIELD = By.id("summary");
    private static final By ADD_BUTTON = By.xpath("//button[text()='Add']");
    private static final By DELETE_BUTTON = By.xpath("//li/span[@class='btn btn-danger pull-right']");
    private static final By ASCENDING_BUTTON = By.id("sort-asc");
    private static final By DESCENDING_BUTTON = By.id("sort-desc");
    private static final By PAGE_TITLE = By.xpath("//h1");
    private static final By PAGE_DESCRIPTION = By.xpath("//p");

    public static final List<String> expectedTasksAscOrder = Arrays.asList(new String[]{"1aitem 4", "item 1", "item 2", "item 3"});


    public static void goTo() {
        Browser.driver.get("http://localhost:8000");
    }


    public static void addItem(String newItem, String messageOnFailure) {
        type(SUMMARY_FIELD, newItem);
        click(ADD_BUTTON);

        List<WebElement> tasks = Browser.driver.findElements(By.xpath("//li[@class='item']"));

        int actualNumberOfTasks = tasks.size();
        int expectedNumberOfTasks = 4;

        Assert.assertEquals(actualNumberOfTasks, expectedNumberOfTasks, messageOnFailure);
    }

    public static void deleteItem(String messageOnFailure) {
        click(DELETE_BUTTON);

        List<WebElement> tasks = Browser.driver.findElements(By.xpath("//li[@class='item']"));

        int actualNumberOfTasks = tasks.size();
        int expectedNumberOfTasks = 2;

        Assert.assertEquals(actualNumberOfTasks, expectedNumberOfTasks, messageOnFailure);
    }

    public static void verifySorting(String messageOnFailure, boolean isAscending) {
        ToDoListPage.addItem("1aitem 4", "the total number of tasks is wrong, please check!");

        if (!isAscending) {
            click(DESCENDING_BUTTON);
            Collections.sort(expectedTasksAscOrder, Collections.reverseOrder());
        } else {
            click(ASCENDING_BUTTON);
        }

        List<WebElement> tasks = Browser.driver.findElements(By.xpath("//li[@class='item']"));

        List<String> actualTasks = new ArrayList<>();

        for (WebElement element : tasks) {
            actualTasks.add(element.getText().replaceAll("Edit", "").replaceAll("X", "").trim());
        }

        Assert.assertEquals(actualTasks, expectedTasksAscOrder);
    }

    public static void verifyPageTitleAndDescriptionText(String messageOnFailureTitle, String messsageOnFailureDescription) {
        String actualTitleText = getText(PAGE_TITLE);
        String actualParagraph = getText(PAGE_DESCRIPTION);

        Assert.assertEquals(actualTitleText, pageTitle, messageOnFailureTitle);
        Assert.assertEquals(actualParagraph, pageDescription, messsageOnFailureDescription);
    }
}
