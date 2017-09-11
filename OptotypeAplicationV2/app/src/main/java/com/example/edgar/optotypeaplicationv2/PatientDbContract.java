package com.example.edgar.optotypeaplicationv2;

import android.provider.BaseColumns;

/**
 * Created by Edgar on 10/09/2017.
 */

public class PatientDbContract {

    public static abstract class PatientEntry  implements BaseColumns {

        public static final String TABLE_NAME = "patient_db_app";

        public static final String ID = "idPatient";
        public static final String NAME = "name";
        public static final String LASTNAME = "LastName";
        public static final String MIDDLENAME = "middleName";
        public static final String MAIDENNAME = "maidenName";
        public static final String YEARSOLD = "yearsOld";
        public static final String PHOTO = "photo";
        public static final String FKUSER = "fkUser";

    }
}
