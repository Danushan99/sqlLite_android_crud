package mad.example.sqllite.database;

import android.provider.BaseColumns;

import java.util.Stack;

public final class UseerMaster {
    private UseerMaster(){}

    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERNAME ="username";
        public static final String COLUMN_NAME_PASSWORD ="password";



    }

}
