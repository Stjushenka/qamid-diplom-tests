package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static ru.netology.qa.elemets.NewsPage.editNewsInNewsPage;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsAddNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsButtonCategoryCreatingNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsButtonDateCreatingNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsButtonOkDateCreatingNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsButtonOkTimeCreatingNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsButtonSaveCreatingNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsButtonTimeCreatingNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsButtonTitleCreatingNews;
import static ru.netology.qa.elemets.NewsPage.getNewsControlPanelElementsDescriptionCreatingNews;

import io.qameta.allure.kotlin.Allure;

public class NewsSteps {

    public static void clickEditNewsInNewsPage(){
        Allure.step("Нажать на кнопку Редактировать страницу новостей");
        onView(editNewsInNewsPage())
                .perform(click());
    }

    public static void clickAddNews(){
        Allure.step("Нажать на кнопку Добавить новость");
        onView(getNewsControlPanelElementsAddNews())
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNews(){
        Allure.step("Выбрать категорию для создания новости");
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click());
    }

    public static void clickButtonTitleCreatingNews(){
        Allure.step("Ввести в поле Заголовок заголовок новости");
        onView(getNewsControlPanelElementsButtonTitleCreatingNews())
                .perform(click(), clearText(), replaceText("Главные новости сегодня"), closeSoftKeyboard());
    }

    public static void clickButtonDateCreatingNews(){
        Allure.step("В поле Дата публикации выбрать дату по календарю");
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonOkDateCreatingNews(){
        Allure.step("Нажать кнопку ОК Дата");
        onView(getNewsControlPanelElementsButtonOkDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews(){
        Allure.step("В поле Время выбрать время");
        onView(getNewsControlPanelElementsButtonTimeCreatingNews())
                .perform(click());
    }

    public static void clickDescriptionCreatingNews(){
        Allure.step("Ввести в поле Описание описание новости");
        onView(getNewsControlPanelElementsDescriptionCreatingNews())
                .perform(replaceText("Новое объявление"), closeSoftKeyboard());
    }

    public static void clickButtonOkTimeCreatingNews(){
        Allure.step("Нажать кнопку ОК Время");
        onView(getNewsControlPanelElementsButtonOkTimeCreatingNews())
                .perform(click());
    }

    public static void clickButtonSaveCreatingNews(){
        Allure.step("Нажать на кнопку Сохранить новость");
        onView(getNewsControlPanelElementsButtonSaveCreatingNews())
                .perform(scrollTo(), click());
    }
}