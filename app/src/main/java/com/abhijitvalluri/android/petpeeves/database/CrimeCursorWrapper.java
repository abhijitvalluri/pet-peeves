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
