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
public class ClaimsTests {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorization() {
        waitFor(3);
        AuthorizationSteps.login();
    }

    @Test
    @Story("20")
    @Description("Фильтрация заявок по критерию Открыта во вкладке Заявки")
    public void applicationFilterInProgress() {
        MainSteps.clickButtonClaims();
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxOpen();
        ClaimSteps.clickButtonOk();
        MainSteps.claimsPage();
    }

    @Test
    @Story("21")
    @Description("Фильтрация заявок по критерию В работе во вкладке Заявки")
    public void applicationFilterOpen() {
        MainSteps.clickButtonClaims();
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxInProgress();
        ClaimSteps.clickButtonOk();
        MainSteps.claimsPage();
    }

    @Test
    @Story("22")
    @Description("Фильтрация заявок по критерию Выполнена во вкладке Заявки")
    public void applicationFilterExecuted() {
        MainSteps.clickButtonClaims();
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxOpen();
        ClaimSteps.clickRemoveCheckBoxInProgress();
        ClaimSteps.clickCheckBoxExecuted();
        ClaimSteps.clickButtonOk();
        MainSteps.claimsPage();
    }

    @Test
    @Story("23")
    @Description("Фильтрация заявок по критерию Отмененные во вкладке Заявки")
    public void applicationFilterCancelled() {
        MainSteps.clickButtonClaims();
        ClaimSteps.clickButtonFilter();
        ClaimSteps.clickRemoveCheckBoxOpen();
        ClaimSteps.clickRemoveCheckBoxInProgress();
        ClaimSteps.clickCheckBoxCancelled();
        ClaimSteps.clickButtonOk();
        MainSteps.claimsPage();
    }

    @Test
    @Story("24")
    @Description("Создание заявки во вкладке Заявки")
    public void addNewClaim() {
        ClaimSteps.clickButtonMainMenu();
        ClaimSteps.clickButtonClaims();
        ClaimSteps.clickButtonAddClaim();
        ClaimSteps.clickTitleField("Осмотр нового пациента окончился печально");
        ClaimSteps.clickCheckBoxExecutorField("Иванов Сергей Викторович");
        ClaimSteps.clickDateField();
        ClaimSteps.clickButtonOkDate();
        ClaimSteps.clickTimeField();
        ClaimSteps.clickButtonOkTime();
        ClaimSteps.clickDescriptionField("Описание не будет полным");
        ClaimSteps.clickButtonSave();
        MainSteps.claimsPage();
    }

    @Test
    @Story("25")
    @Description("Поле Тема пустое, при создании заявки, во вкладке Заявки")
    public void titleFieldIsEmpty() {
        ClaimSteps.clickButtonMainMenu();
        ClaimSteps.clickButtonClaims();
        ClaimSteps.clickButtonAddClaim();
        ClaimSteps.clickCheckBoxExecutorField("Иванов Сергей Викторович");
        ClaimSteps.clickDateField();
        ClaimSteps.clickButtonOkDate();
        ClaimSteps.clickTimeField();
        ClaimSteps.clickButtonOkTime();
        ClaimSteps.clickDescriptionField("Описание не будет полным");
        ClaimSteps.clickButtonSave();
        ClaimSteps.clickButtonOkError();
        ClaimSteps.errorIconInField();
        ClaimSteps.clickButtonCancelClaim();
        ClaimSteps.clickButtonOkNotification();
    }
}
