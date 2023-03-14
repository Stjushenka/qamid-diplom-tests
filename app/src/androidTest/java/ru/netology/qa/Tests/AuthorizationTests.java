package ru.netology.qa.Tests;

import static android.os.SystemClock.sleep;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

import static ru.netology.qa.WaitId.waitFor;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elemets.AuthorizationPage;
import ru.netology.qa.steps.AuthorizationSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
    @RunWith(AllureAndroidJUnit4.class)

    @Epic("Тест-кейсы для проведения функционального тестирования вкладки Авторизация")
    public class AuthorizationTests {

        @Rule
        public ActivityTestRule<AppActivity> activityTestRule =
                new ActivityTestRule<>(AppActivity.class);

    @Test
    @Story("2")
    @Description("Авторизация валидными данными")
    public void successfulAuthorization () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.clickButtonExit();
        AuthorizationSteps.clickButtonLogOut();

    }

    @Test
    @Story("3")
    @Description("Поле Логин пустое, при авторизации")
    public void loginFieldIsEmpty () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField(" ");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    @Story("4")
    @Description("Поле Логин заполнено данными незарегистрированного пользователя, при авторизации")
    public void loginFieldUnregisteredUser () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login123");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("5")
    @Description("Поле Логин состоит из спецсимволов, при авторизации")
    public void loginFieldWithSpecialCharacters () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("^&*@#$");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("6")
    @Description("Поле Логин состоит из одного символа, при авторизации")
    public void loginFieldOneLetter () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("1");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("7")
    @Description("Поле Логин состоит из букв разного регистра, при авторизации")
    public void loginFieldLettersOfDifferentCase () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("LoGiN2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("8")
    @Description("Поле Пароль пустое, при авторизации")
    public void passwordFieldIsEmpty () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField(" ");
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("9")
    @Description("Поле Пароль заполнено данными незарегистрированного пользователя, при авторизации")
    public void passwordFieldUnregisteredUser () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password123");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("10")
    @Description("Поле Пароль состоит из спецсимволов, при авторизации")
    public void passwordFieldWithSpecialCharacters () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("(*^$%&");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("11")
    @Description("Поле Пароль состоит из одного символа, при авторизации")
    public void passwordFieldOneLetter () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("1");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("12")
    @Description("Поле Пароль состоит из букв разного регистра, при авторизации")
    public void passwordFieldLettersOfDifferentCase () {
        waitFor(3);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("PaSSWord2");
        AuthorizationPage.clickButtonSingIn();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }
}
