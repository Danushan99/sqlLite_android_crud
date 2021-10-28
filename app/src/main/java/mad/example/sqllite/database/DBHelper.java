package mad.example.sqllite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String Database_Name ="UserIndo.db";

    public DBHelper( Context context) { super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES=
                "CREATE TABLE " + UseerMaster.Users.TABLE_NAME + "(" +
                        UseerMaster.Users._ID +"INTEGER PRIMARY KEY," +
                        UseerMaster.Users.COLUMN_NAME_USERNAME+ "TEXT,"+
                        UseerMaster.Users.COLUMN_NAME_PASSWORD+ "TEXT)";

    db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
