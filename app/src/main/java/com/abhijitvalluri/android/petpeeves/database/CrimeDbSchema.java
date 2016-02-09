package com.abhijitvalluri.android.petpeeves.database;

/**
 * Database Schema to store the CriminalIntent app's crime data.
 */
public class CrimeDbSchema {
    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String SUSPECT_NAME = "suspectName";
            public static final String SUSPECT_ID = "suspectID";
        }
    }
}