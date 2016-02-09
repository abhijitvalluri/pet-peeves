package com.abhijitvalluri.android.petpeeves;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

/**
 * DatePickerActivity hosts a date picker. This is for the second challenge.
 */
public class DatePickerActivity extends SingleFragmentActivity {
    private static final String EXTRA_DATE =
            "com.abhijitvalluri.android.criminalintent.date";

    @Override
    protected Fragment createFragment() {
        Date date = (Date) getIntent().getSerializableExtra(EXTRA_DATE);
        return DatePickerFragment
                .newInstance(date);
    }

    public static Intent newIntent(Context packageContext, Date date) {
        Intent i = new Intent(packageContext, DatePickerActivity.class);
        i.putExtra(EXTRA_DATE, date);
        return i;
    }
}