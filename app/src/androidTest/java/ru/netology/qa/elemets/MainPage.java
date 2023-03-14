package ru.netology.qa.elemets;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.qa.WaitId.waitUntilElement;
import static ru.netology.qa.util.Util.withIndex;
import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.MainSteps;


public class MainPage extends MainSteps {

    public static Matcher<View> getMainElementsButtonAllNews() {
        waitUntilElement(R.id.all_news_text_view);
        return withId(R.id.all_news_text_view);
    }

    public static Matcher<View> getMainElementsButtonClaims() {
        waitUntilElement(R.id.all_claims_text_view);
        return withId(R.id.all_claims_text_view);
    }

    public static Matcher<View> clickDropDownListNews() {
        waitUntilElement(R.id.expand_material_button);
        return withIndex(withId(R.id.expand_material_button), 0);
    }

    public static Matcher<View> clickDropDownListNewInBlock() {
        waitUntilElement(R.id.container_list_news_include_on_fragment_main);
        return withIndex(withId(R.id.container_list_news_include_on_fragment_main), 0);
    }

    public static Matcher<View> clickDropDownListClaims() {
        waitUntilElement(R.id.expand_material_button);
        return withIndex(withId(R.id.expand_material_button), 1);
    }
}