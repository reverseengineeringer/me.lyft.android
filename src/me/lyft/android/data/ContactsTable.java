package me.lyft.android.data;

public class ContactsTable
{
  protected static final String TABLE_CREATE = "CREATE TABLE Contacts ( _id integer primary key autoincrement, name varchar default '', phone varchar default '', times_splitted integer default 0, last_time_splitted integer default 0)";
  public static final String TABLE_NAME = "Contacts";
}

/* Location:
 * Qualified Name:     me.lyft.android.data.ContactsTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */