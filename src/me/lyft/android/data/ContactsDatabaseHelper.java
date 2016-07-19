package me.lyft.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDatabaseHelper
  extends SQLiteOpenHelper
{
  private static final String DATABASE_NAME = "lyft_contacts.db";
  private static final int DATABASE_VERSION = 1;
  
  public ContactsDatabaseHelper(Context paramContext)
  {
    super(paramContext, "lyft_contacts.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE Contacts ( _id integer primary key autoincrement, name varchar default '', phone varchar default '', times_splitted integer default 0, last_time_splitted integer default 0)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 <= 1) || (paramInt2 > 2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.data.ContactsDatabaseHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */