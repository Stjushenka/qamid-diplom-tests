package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.netology.qa.elemets.MainPage.clickDropDownListClaims;
import static ru.netology.qa.elemets.MainPage.clickDropDownListNewInBlock;
import static ru.netology.qa.elemets.MainPage.clickDropDownListNews;
import static ru.netology.qa.elemets.MainPage.getMainElementsButtonAllNews;
import static ru.netology.qa.elemets.MainPage.getMainElementsButtonClaims;
import static ru.netology.qa.util.Util.nestedScrollTo;

import io.qameta.allure.kotlin.Allure;

public class MainSteps {

    public static void clickButtonAllNews(){
        Allure.step("Нажать на кнопку ВСЕ НОВОСТИ");
        onView(getMainElementsButtonAllNews())
                .perform(click());
    }

    public static void clickButtonClaims(){
        Allure.step("Нажать на кнопку ВСЕ ЗАЯВКИ");
        onView(getMainElementsButtonClaims())
                .perform(nestedScrollTo())
                .perform(click());
    }

    public static void clickDDListNews(){
        Allure.step("Разворачивание и сворачивание новостной ленты");
        onView(clickDropDownListNews())
                .perform(click());
    }

    public static void clickDDListNewInBlock(){
        Allure.step("Разворачивание описания новости");
        onView(clickDropDownListNewInBlock())
                .perform(click());
    }

    public static void clickDDListClaims(){
        Allure.step("Разворачивание и сворачивание ленты с притензиями");
        onView(clickDropDownListClaims())
                .perform(click());
    }
}
