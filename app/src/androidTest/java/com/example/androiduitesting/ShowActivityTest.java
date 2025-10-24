package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * UI tests for ShowActivity navigation and data passing.
 */
@RunWith(AndroidJUnit4.class)
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenario =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testActivitySwitch() {
        // Add a city and click on it
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Calgary"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Edmonton")).perform(click());

        onView(withId(R.id.text_city_name)).check(matches(isDisplayed()));
    }

    @Test
    public void testCityNameDisplayed() {
        // Add a city and open it
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Toronto"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Toronto")).perform(click());

        //check if city name displayed correctly
        onView(withId(R.id.text_city_name)).check(matches(withText("Toronto")));
    }

    @Test
    public void testBackButton() {
        // add a city and open it
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Montreal"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Montreal")).perform(click());

        //go back
        onView(withId(R.id.button_back)).perform(click());

        //verify it's back on MainActivity (city list visible again)
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
