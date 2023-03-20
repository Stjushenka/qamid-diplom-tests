package ru.netology.qa.Tests;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.Tag;
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

    @Before
    public void loginAuth() {
        try {
            AuthorizationSteps.textAuthorization();
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            AuthorizationSteps.clickButtonExit();
            AuthorizationSteps.clickButtonLogOut();
        }
    }

    @Test
    @Tag("2")
    @Story("Авторизация валидными данными")
    public void successfulAuthorization() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.clickButtonExit();
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @Tag("3")
    @Story("Поле Логин пустое, при авторизации")
    public void loginFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField(" ");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorEmpty();
    }

    @Test
    @Tag("4")
    @Story("Поле Логин заполнено данными незарегистрированного пользователя, при авторизации")
    public void loginFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login123");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }

    @Test
    @Tag("5")
    @Story("Поле Логин состоит из спецсимволов, при авторизации")
    public void loginFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("^&*@#$");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }

    @Test
    @Tag("6")
    @Story("Поле Логин состоит из одного символа, при авторизации")
    public void loginFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("1");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }

    @Test
    @Tag("7")
    @Story("Поле Логин состоит из букв разного регистра, при авторизации")
    public void loginFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("LoGiN2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }

    @Test
    @Tag("8")
    @Story("Поле Пароль пустое, при авторизации")
    public void passwordFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField(" ");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorEmpty();
    }

    @Test
    @Tag("9")
    @Story("Поле Пароль заполнено данными незарегистрированного пользователя, при авторизации")
    public void passwordFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password123");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }

    @Test
    @Tag("10")
    @Story("Поле Пароль состоит из спецсимволов, при авторизации")
    public void passwordFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("(*^$%&");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }

    @Test
    @Tag("11")
    @Story("Поле Пароль состоит из одного символа, при авторизации")
    public void passwordFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("1");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }

    @Test
    @Tag("12")
    @Story("Поле Пароль состоит из букв разного регистра, при авторизации")
    public void passwordFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("PaSSWord2");
        AuthorizationPage.clickButtonSingIn();
        AuthorizationPage.textErrorWrong();
    }
}
