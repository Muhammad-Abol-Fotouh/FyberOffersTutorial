package com.fyber.offerstutorial;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import com.fyber.offerstutorial.UI.Activities.FormActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by muhammadkorany on 10/14/16.
 */
@RunWith(AndroidJUnit4.class)
public class TestFormActivity extends ActivityInstrumentationTestCase2<FormActivity>{

    FormActivity activity;

    public TestFormActivity(){
        super(FormActivity.class);

    }

    @Rule
    public ActivityTestRule<FormActivity> mActivityTestRule = new ActivityTestRule<>(FormActivity.class);


    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = getActivity();
    }

    @Test
    public void testViewNotNull(){
        MaterialEditText uid = (MaterialEditText) activity.findViewById(R.id.et_uid);
        assertNotNull(uid);
    }
}
