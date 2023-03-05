package ru.netology.qa.Tests;

import static android.os.SystemClock.sleep;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

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

        //Реализован в MainTests @Before
    @Test
    @Story("2")
    @Description("Авторизация валидными данными")
    public void successfulAuthorization () {
        sleep(5000);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        sleep(5000);
        AuthorizationPage.clickButtonSingIn();
        sleep(5000);
        AuthorizationPage.clickButtonExit();
        sleep(3000);
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @Story("3")
    @Description("Поле Логин пустое, при авторизации")
    public void loginFieldIsEmpty () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginEmpty();
        AuthorizationSteps.clickPasswordField();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    @Story("4")
    @Description("Поле Логин заполнено данными незарегистрированного пользователя, при авторизации")
    public void loginFieldUnregisteredUser () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldUnregisteredUser();
        AuthorizationSteps.clickPasswordField();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("5")
    @Description("Поле Логин состоит из спецсимволов, при авторизации")
    public void loginFieldWithSpecialCharacters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithSpecialCharacters();
        AuthorizationSteps.clickPasswordField();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("6")
    @Description("Поле Логин состоит из одного символа, при авторизации")
    public void loginFieldOneLetter () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldOneLetter();
        AuthorizationSteps.clickPasswordField();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("7")
    @Description("Поле Логин состоит из букв разного регистра, при авторизации")
    public void loginFieldLettersOfDifferentCase () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldLettersOfDifferentCase();
        AuthorizationSteps.clickPasswordField();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("8")
    @Description("Поле Пароль пустое, при авторизации")
    public void passwordFieldIsEmpty () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldIsEmpty();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("9")
    @Description("Поле Пароль заполнено данными незарегистрированного пользователя, при авторизации")
    public void passwordFieldUnregisteredUser () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldUnregisteredUser();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("10")
    @Description("Поле Пароль состоит из спецсимволов, при авторизации")
    public void passwordFieldWithSpecialCharacters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithSpecialCharacters();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("11")
    @Description("Поле Пароль состоит из одного символа, при авторизации")
    public void passwordFieldOneLetter () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldOneLetter();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @Story("12")
    @Description("Поле Пароль состоит из букв разного регистра, при авторизации")
    public void passwordFieldLettersOfDifferentCase () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldLettersOfDifferentCase();
        AuthorizationPage.clickButtonSingIn();
        sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

}
