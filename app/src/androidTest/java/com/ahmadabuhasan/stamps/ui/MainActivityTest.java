package com.ahmadabuhasan.stamps.ui;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.ahmadabuhasan.stamps.R;
import com.ahmadabuhasan.stamps.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void btnApaBole() {
        onView(withId(R.id.btn_ApaBole)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_ApaBole)).perform(click());

        delayTwoSecond();
        onView(withId(R.id.result_list)).check(matches(isDisplayed()));
        onData(anything())
                .inAdapterView(withId(R.id.result_list))
                .atPosition(99)
                .perform(click());
    }

    @Test
    public void btnApiWeather() {
        onView(withId(R.id.btn_Weather)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_Weather)).perform(click());

        delayTwoSecond();
        onView(withId(R.id.rvWeather)).check(matches(isDisplayed()));
        onView(withId(R.id.rvWeather)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    private void delayTwoSecond() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}