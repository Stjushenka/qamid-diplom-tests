package ru.netology.qa.elemets;

import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.AuthorizationSteps;

public class AuthorizationPage extends AuthorizationSteps {

    public static Matcher<View> getAuthorizationElementsButton () {
        return allOf(withId(R.id.enter_button));
    }

    public static Matcher<View> getAuthorizationElementsLoginField() {
        return allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout))));
    }

    public static Matcher<View> getAuthorizationElementsPasswordField() {
        return allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout))));
    }

    public static Matcher<View> getAuthorizationElementsButtonExit() {
        return allOf(withId(R.id.authorization_image_button));
    }

    public static Matcher<View> getAuthorizationElementsButtonLogOut() {
        return allOf(withId(android.R.id.title), withText("Log out"));
    }

    public static Matcher<View> getAuthorizationElementsTextAuthorization() {
        return allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))));
    }
}