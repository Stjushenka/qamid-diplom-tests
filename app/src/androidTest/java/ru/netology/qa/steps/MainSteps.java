package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.qa.elemets.MainPage.clickDropDownListClaims;
import static ru.netology.qa.elemets.MainPage.clickDropDownListNewInBlock;
import static ru.netology.qa.elemets.MainPage.clickDropDownListNews;
import static ru.netology.qa.elemets.MainPage.getMainElementsButtonAllNews;
import static ru.netology.qa.elemets.MainPage.getMainElementsButtonClaims;
import static ru.netology.qa.util.Util.nestedScrollTo;
import static ru.netology.qa.util.Util.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainSteps {

    public static void clickButtonAllNews(){
        Allure.step("Нажать на кнопку ВСЕ НОВОСТИ");
        onView(getMainElementsButtonAllNews()).perform(click());
    }

    public static void newsPage() {
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
    }

    public static void clickButtonClaims(){
        Allure.step("Нажать на кнопку ВСЕ ЗАЯВКИ");
        onView(getMainElementsButtonClaims())
                .perform(nestedScrollTo())
                .perform(click());
    }

    public static void claimsPage() {
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    public static void clickDDListNews(){
        Allure.step("Разворачивание и сворачивание новостной ленты");
        onView(clickDropDownListNews())
                .perform(click());
    }

    public static void checkDDListNews() {
        Allure.step("Отображение новостной ленты");
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    public static void clickDDListNewInBlock(){
        Allure.step("Разворачивание описания новости");
        onView(clickDropDownListNewInBlock())
                .perform(click());
    }

    public static void checkDDListNewInBlock() {
        Allure.step("Отображение описания новости");
        onView(withIndex(withId(R.id.news_item_material_card_view), 1)).check(matches(isDisplayed()));
    }

    public static void clickDDListClaims(){
        Allure.step("Разворачивание и сворачивание ленты с притензиями");
        onView(clickDropDownListClaims())
                .perform(click());
    }

    public static void checkDDListClaims(){
        Allure.step("Отображение ленты с притензиями");
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }
}
