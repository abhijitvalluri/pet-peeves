/*
   Copyright 2016 Abhijit Kiran Valluri

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.abhijitvalluri.android.petpeeves;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;

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
