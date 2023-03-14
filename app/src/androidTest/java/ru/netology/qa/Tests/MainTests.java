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

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class MainTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorization() {
        waitFor(3);
        AuthorizationSteps.login();
    }

    @Test
    @Story("13")
    @Description("Переход во вкладку Все Новости через главное меню")
    public void gotoAllNewsPage() {
        MainSteps.clickButtonAllNews();
        MainSteps.newsPage();
    }


    @Test
    @Story("14")
    @Description("Переход во вкладку Все Заявки через главное меню")
    public void buttonAllClaims() {
        MainSteps.clickButtonClaims();
        MainSteps.claimsPage();
    }

    @Test
    @Story("15")
    @Description("Развернуть и свернуть новостную ленту")
    public void clickDDListNews() {
        MainSteps.clickDDListNews();
        MainSteps.clickDDListNews();
        MainSteps.checkDDListNews();
    }

    @Test
    @Story("16")
    @Description("Развернуть новость")
    public void clickDDListNewsInBlock() {
        MainSteps.clickDDListNewInBlock();
        MainSteps.checkDDListNewInBlock();
    }

    @Test
    @Story("17")
    @Description("Развернуть и свернуть список заявок")
    public void clickDDListClaims() {
        MainSteps.clickDDListClaims();
        MainSteps.clickDDListClaims();
        MainSteps.checkDDListClaims();
    }

    @Test
    @Story("18")
    @Description("Создание Заявки из главного меню")
    public void addClaimInMainPage() {
        ClaimSteps.clickAddClaimInMainPage();
        ClaimSteps.clickTitleFieldMaximumCharacters("Ж1!К%?*;№АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ1234567891011");
        ClaimSteps.clickCheckBoxExecutorField("Иванов Сергей Викторович");
        ClaimSteps.clickDateField();
        ClaimSteps.clickButtonOkDate();
        ClaimSteps.clickTimeField();
        ClaimSteps.clickButtonOkTime();
        ClaimSteps.clickDescriptionField("Описание не будет полным");
        ClaimSteps.clickButtonSave();
        MainSteps.checkDDListClaims();
        ClaimSteps.chooseItemIfVisible("Ж1!К%?*;№АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ1234567891011");
    }
}
