package hack.sport.sporthealthandroidapp.db;

/**
 * Created by Abhishek Kumar on 1/2/2016.
 */
public class TableUser {

    public static final String TABLE_NAME = "table_user";

    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String INTEGER_PRIMARY_TYPE = " INTEGER PRIMARY KEY";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_USER_ENTRIES = "CREATE TABLE table_user (  userToken text,  " +
            "googleUserId text, imageUrl text,  serverAuthCode text,  emailID text,  userName text,  DOB date,  diseases text,  " +
            "location text,  goals text,  term_accpeptance bool,  height text,  weight text);";


    public static final String SQL_DELETE_USER_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
