package ru.netology.qa.Tests;

import static android.os.SystemClock.sleep;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.qa.util.Util.withIndex;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elemets.AuthorizationPage;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimSteps;
import ru.netology.qa.steps.MainSteps;
import ru.netology.qa.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class MainTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization() throws InterruptedException {
        Thread.sleep(7000);
        try {
            AuthorizationPage.textAuthorization();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        sleep(1000);
        AuthorizationPage.clickButtonSingIn();
    }

    @AfterClass
    public static void Logout() {
        sleep(2000);
        AuthorizationPage.clickButtonExit();
        sleep(2000);
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @Story("13")
    @Description("Переход во вкладку Все Новости через главное меню")
    public void gotoAllNewsPage() {
        MainSteps.clickButtonAllNews();
        sleep(1000);
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
    }


    @Test
    @Story("14")
    @Description("Переход во вкладку Все Заявки через главное меню")
    public void buttonAllClaims() {
        MainSteps.clickButtonClaims();
        sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("15")
    @Description("Развернуть и свернуть новостную ленту")
    public void clickDDListNews() {
        MainSteps.clickDDListNews();
        sleep(1000);
        MainSteps.clickDDListNews();
        sleep(1000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    @Test
    @Story("16")
    @Description("Развернуть новость")
    public void clickDDListNewsInBlock() {
        MainSteps.clickDDListNewInBlock();
        sleep(1000);
        onView(withIndex(withId(R.id.news_item_material_card_view), 1)).check(matches(isDisplayed()));
    }

    @Test
    @Story("17")
    @Description("Развернуть и свернуть список заявок")
    public void clickDDListClaims() {
        MainSteps.clickDDListClaims();
        sleep(1000);
        MainSteps.clickDDListClaims();
        sleep(1000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }
    @Test
    @Story("18")
    @Description("Создание Заявки из главного меню")
    public void addClaimInMainPage() {
        ClaimSteps.clickAddClaimInMainPage();
        sleep(1000);
        ClaimSteps.clickTitleFieldMaximumCharacters();
        ClaimSteps.clickCheckBoxExecutorField();
        ClaimSteps.clickDateField();
        ClaimSteps.clickButtonOkDate();
        sleep(1000);
        ClaimSteps.clickTimeField();
        ClaimSteps.clickButtonOkTime();
        ClaimSteps.clickDescriptionField();
        ClaimSteps.clickButtonSave();
        sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    @Test
    @Story("20")
    @Description("Фильтрация заявок по критерию Открыта во вкладке Заявки")
    public void applicationFilterInProgress() {
        MainSteps.clickButtonClaims();
        sleep(1000);
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxOpen();
        ClaimSteps.clickButtonOk();
        sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("21")
    @Description("Фильтрация заявок по критерию В работе во вкладке Заявки")
    public void applicationFilterOpen() {
        MainSteps.clickButtonClaims();
        sleep(1000);
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxInProgress();
        ClaimSteps.clickButtonOk();
        sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("22")
    @Description("Фильтрация заявок по критерию Выполнена во вкладке Заявки")
    public void applicationFilterExecuted() {
        MainSteps.clickButtonClaims();
        sleep(1000);
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxOpen();
        ClaimSteps.clickRemoveCheckBoxInProgress();
        ClaimSteps.clickCheckBoxExecuted();
        ClaimSteps.clickButtonOk();
        sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("23")
    @Description("Фильтрация заявок по критерию Отмененные во вкладке Заявки")
    public void applicationFilterCancelled() {
        MainSteps.clickButtonClaims();
        sleep(1000);
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxOpen();
        ClaimSteps.clickRemoveCheckBoxInProgress();
        sleep(2000);
        ClaimSteps.clickCheckBoxCancelled();
        ClaimSteps.clickButtonOk();
        sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("24")
    @Description("Создание заявки во вкладке Заявки")
    public void addNewClaim() {
        ClaimSteps.clickButtonMainMenu();
        ClaimSteps.clickButtonClaims();
        sleep(1000);
        ClaimSteps.clickButtonAddClaim();
        ClaimSteps.clickTitleField();
        ClaimSteps.clickCheckBoxExecutorField();
        ClaimSteps.clickDateField();
        ClaimSteps.clickButtonOkDate();
        sleep(1000);
        ClaimSteps.clickTimeField();
        ClaimSteps.clickButtonOkTime();
        ClaimSteps.clickDescriptionField();
        ClaimSteps.clickButtonSave();
        sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("25")
    @Description("Поле Тема пустое, при создании заявки, во вкладке Заявки")
    public void titleFieldIsEmpty() {
        ClaimSteps.clickButtonMainMenu();
        ClaimSteps.clickButtonClaims();
        sleep(2000);
        ClaimSteps.clickButtonAddClaim();
        ClaimSteps.clickCheckBoxExecutorField();
        ClaimSteps.clickDateField();
        ClaimSteps.clickButtonOkDate();
        sleep(1000);
        ClaimSteps.clickTimeField();
        ClaimSteps.clickButtonOkTime();
        ClaimSteps.clickDescriptionField();
        ClaimSteps.clickButtonSave();
        sleep(2000);
        onView(allOf(withId(R.id.message), isFocusable()));
        ClaimSteps.clickButtonOkError();
        sleep(2000);
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
        ClaimSteps.clickButtonCancelClaim();
        ClaimSteps.clickButtonOkNotification();
    }

    @Test
    @Story("26")
    @Description("Создание новости")
    public void creationNewsInControlPanel() {
        sleep(2000);
        MainSteps.clickButtonAllNews();
        sleep(2000);
        NewsSteps.clickEditNewsInNewsPage();
        sleep(2000);
        NewsSteps.clickAddNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        sleep(2000);
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickButtonOkDateCreatingNews();
        sleep(2000);
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickButtonOkTimeCreatingNews();
        NewsSteps.clickDescriptionCreatingNews();
        NewsSteps.clickButtonSaveCreatingNews();
        sleep(2000);
        onView(allOf(withIndex(withId(R.id.news_item_material_card_view), 0))).check(matches(isDisplayed()));
    }
}
