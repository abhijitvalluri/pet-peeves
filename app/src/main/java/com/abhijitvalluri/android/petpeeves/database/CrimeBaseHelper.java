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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.abhijitvalluri.android.petpeeves.database.CrimeDbSchema.CrimeTable;

/**
 * Helper class for the Database
 */
public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CrimeTable.NAME + "(" +
                   " _id integer primary key autoincrement, " +
                   CrimeTable.Cols.UUID + ", " +
                   CrimeTable.Cols.TITLE + ", " +
                   CrimeTable.Cols.DATE + ", " +
                   CrimeTable.Cols.SOLVED + ", " +
                   CrimeTable.Cols.SUSPECT_NAME + ", " +
                   CrimeTable.Cols.SUSPECT_ID +
                   ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
