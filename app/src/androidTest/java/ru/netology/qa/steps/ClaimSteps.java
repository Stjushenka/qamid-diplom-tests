package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementAddClaimInMainPage;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonAddClaim;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonCancelClaim;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonClaims;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonFilter;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonMainMenu;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonOk;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonOkDate;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonOkError;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonOkNotification;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonOkTime;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsButtonSave;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsCheckBoxCancelled;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsCheckBoxExecuted;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsDateField;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsDescriptionField;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsExecutorField;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsRemoveCheckBoxInProgress;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsRemoveCheckBoxOpen;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsTimeField;
import static ru.netology.qa.elemets.ClaimPage.getClaimsElementsTitleField;

import io.qameta.allure.kotlin.Allure;

public class ClaimSteps {


    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
        onView(getClaimsElementsButtonMainMenu())
                .perform(click());
    }

    public static void clickButtonClaims() {
        Allure.step("Нажать на кнопку Заявки");
        onView(getClaimsElementsButtonClaims())
                .perform(click());
    }

    public static void clickButtonFilter() {
        Allure.step("Нажать на кнопку Фильтрация");
        onView(getClaimsElementsButtonFilter())
                .perform(click());
    }

    public static void clickRemoveCheckBoxOpen() {
        Allure.step("Снять флажок с чекбокса Открыта");
        onView(getClaimsElementsRemoveCheckBoxOpen())
                .perform(click());
    }

    public static void clickButtonOk() {
        Allure.step("Нажать кнопку ОК");
        onView(getClaimsElementsButtonOk())
                .perform(click());
    }

    public static void clickRemoveCheckBoxInProgress() {
        Allure.step("Снять флажок с чекбокса В работе");
        onView(getClaimsElementsRemoveCheckBoxInProgress())
                .perform(click());
    }

    public static void clickCheckBoxExecuted() {
        Allure.step("Выбрать критерий для фильтрации Выполнена");
        onView(getClaimsElementsCheckBoxExecuted())
                .perform(click());
    }

    public static void clickCheckBoxCancelled() {
        Allure.step("Выбрать критерий для фильтрации Отмененные");
        onView(getClaimsElementsCheckBoxCancelled())
                .perform(click());
    }

    public static void clickButtonAddClaim() {
        Allure.step("Нажать на кнопку Создание Заявки");
        onView(getClaimsElementsButtonAddClaim())
                .perform(click());
    }

    public static void clickTitleField() {
        Allure.step("Ввести в поле Тема наименование темы");
        onView(getClaimsElementsTitleField())
                .perform(replaceText("Осмотр нового пациента окончился печально"), closeSoftKeyboard());
    }

    public static void clickCheckBoxExecutorField() {
        Allure.step("В поле Исполнитель выбрать из списка ФИО исполнителя");
        onView(getClaimsElementsExecutorField())
                .perform(replaceText("Иванов Сергей Викторович"), closeSoftKeyboard());
    }

    public static void clickDateField() {
        Allure.step("Нажать на поле Дата");
        onView(getClaimsElementsDateField())
                .perform(click());
    }

    public static void clickButtonOkDate() {
        Allure.step("Нажать кнопку ОК");
        onView(getClaimsElementsButtonOkDate())
                .perform(click());
    }

    public static void clickTimeField() {
        Allure.step("Нажать на поле Время");
        onView(getClaimsElementsTimeField())
                .perform(click());
    }

    public static void clickButtonOkTime() {
        Allure.step("Нажать кнопку ОК");
        onView(getClaimsElementsButtonOkTime())
                .perform(click());
    }

    public static void clickDescriptionField() {
        Allure.step("Ввести в поле Описание описание заявки");
        onView(getClaimsElementsDescriptionField())
                .perform(replaceText("Описание не будет полным"), closeSoftKeyboard());
    }

    public static void clickButtonSave() {
        Allure.step("Нажать на кнопку Сохранить");
        onView(getClaimsElementsButtonSave())
                .perform(click());
    }

    public static void clickButtonOkError() {
        Allure.step("Нажать кнопку ОК");
        onView(getClaimsElementsButtonOkError())
                .perform(click());
    }

    public static void clickButtonCancelClaim() {
        Allure.step("Нажать кнопку Отмена");
        onView(getClaimsElementsButtonCancelClaim())
                .perform(click());
    }

    public static void clickButtonOkNotification() {
        Allure.step("Нажать кнопку ОК Уведомления");
        onView(getClaimsElementsButtonOkNotification())
                .perform(click());
    }

    public static void clickTitleFieldMaximumCharacters() {
        Allure.step("Ввести в поле Тема максимально-допустимое количество символов");
        onView(getClaimsElementsTitleField())
                .perform(replaceText("Ж1!К%?*;№АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ1234567891011"), closeSoftKeyboard());
    }

    public static void clickAddClaimInMainPage() {
        Allure.step("Добавить заявку с главной страницы");
        onView(getClaimsElementAddClaimInMainPage())
                .perform(click());
    }
}
