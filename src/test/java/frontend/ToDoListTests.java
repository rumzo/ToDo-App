package frontend;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.ToDoListPage;

public class ToDoListTests extends BaseTest {

    @Test
    public void addAnItem() {
        ToDoListPage.goTo();
        ToDoListPage.addItem("item 4", "the total number of tasks is not as expected");
    }

    @Test
    public void deleteAnItem() {
        ToDoListPage.goTo();
        ToDoListPage.deleteItem("the total number of tasks is not as expected");
    }

    @Test
    public void checkAscendingOrder() {
        ToDoListPage.goTo();
        ToDoListPage.verifySorting("The items are not in ascending order, please check!", true);
    }

    @Test
    public void checkDescendingOrder() {
        ToDoListPage.goTo();
        ToDoListPage.verifySorting("The items are not in descending order, please check!", false);
    }

    @Test
    public void checkPageTitleAndDescription() {
        ToDoListPage.goTo();
        ToDoListPage.verifyPageTitleAndDescriptionText("Wrong page title, please check!", "Wrong page description, please check!");
    }
}
