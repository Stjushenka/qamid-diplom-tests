package ru.netology.qa.elemets;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.AuthorizationSteps;

public class AuthorizationPage extends AuthorizationSteps {
    public static ViewInteraction loginField = onView(withId(R.id.login_text_input_layout));
    public static ViewInteraction passwordField = onView(withId(R.id.password_text_input_layout));
    public static ViewInteraction loginButton = onView(withId(R.id.enter_button));
    public static ViewInteraction loginFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.login_text_input_layout))));
    public static ViewInteraction passwordFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.password_text_input_layout))));
    public static ViewInteraction titleTextElement = onView(withText("Authorization"));
    public static ViewInteraction logOut = onView(allOf(withId(android.R.id.title), withText("Log out")));
    public static ViewInteraction exitBtn = onView(allOf(withId(R.id.authorization_image_button)));
}
