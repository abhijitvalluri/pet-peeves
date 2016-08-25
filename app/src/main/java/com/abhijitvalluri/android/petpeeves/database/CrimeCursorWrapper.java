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

package com.abhijitvalluri.android.petpeeves.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.abhijitvalluri.android.petpeeves.Crime;
import com.abhijitvalluri.android.petpeeves.database.CrimeDbSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

/**
 * A wrapper for the cursor class to make accessing data from the database more convenient.
 */
public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspectName = getString(getColumnIndex(CrimeTable.Cols.SUSPECT_NAME));
        Integer suspectID = getInt(getColumnIndex(CrimeTable.Cols.SUSPECT_ID));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspect(suspectName, suspectID);

        return crime;
    }
}
