package ru.netology.qa.Tests;

import static ru.netology.qa.WaitId.waitFor;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimSteps;
import ru.netology.qa.steps.MainSteps;
import ru.netology.qa.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorization() {
        waitFor(3);
        AuthorizationSteps.login();
    }

    @Test
    @Story("26")
    @Description("Создание новости")
    public void creationNewsInControlPanel() {
        MainSteps.clickButtonAllNews();
        NewsSteps.clickEditNewsInNewsPage();
        NewsSteps.clickAddNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickButtonOkDateCreatingNews();
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickButtonOkTimeCreatingNews();
        NewsSteps.clickDescriptionCreatingNews();
        NewsSteps.clickButtonSaveCreatingNews();
        MainSteps.checkDDListNewInBlock();
        ClaimSteps.chooseItemIfVisible("Главные новости сегодня");
    }
}
