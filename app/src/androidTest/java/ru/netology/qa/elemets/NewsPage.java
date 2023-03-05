package ru.netology.qa.elemets;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.NewsSteps;

public class NewsPage extends NewsSteps {

    public static Matcher<View> editNewsInNewsPage() {
        return allOf(withId(R.id.edit_news_material_button));
    }

    public static Matcher<View> getNewsControlPanelElementsAddNews() {
        return allOf(withId(R.id.add_news_image_view));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonCategoryCreatingNews() {
        return   allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }


    public static Matcher<View> getNewsControlPanelElementsButtonTitleCreatingNews() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonDateCreatingNews() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonOkDateCreatingNews() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonTimeCreatingNews() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsDescriptionCreatingNews() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonOkTimeCreatingNews() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonSaveCreatingNews() {
        return allOf(withId(R.id.save_button));
    }
}
