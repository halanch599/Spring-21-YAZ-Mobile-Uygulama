package com.example.yaz_1_1.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomerDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME = "oms.db";

    public static final String TABLE_NAME = "Customer";
    public static final String COLUMN_CUSTOMERID = "CustomerID";
    public static final String COLUMN_FIRSTNAME = "FirstName";
    public static final String COLUMN_LASTTNAME = "LasttName";
    public static final String COLUMN_ADDRESS = "Address";

    private static final String SQL_CREATE_CUSTOMER =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_CUSTOMERID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_FIRSTNAME + " TEXT," +
                    COLUMN_LASTTNAME + " TEXT," +
                    COLUMN_ADDRESS + " TEXT)";

    private static final String SQL_DELETE_CUSTOMER =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public CustomerDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CUSTOMER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_CUSTOMER);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public long AddCustomer(Customer c)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        try{

            ContentValues values = new ContentValues();
            values.put(COLUMN_FIRSTNAME,c.getFirstName());
            values.put(COLUMN_LASTTNAME,c.getLastName());
            values.put(COLUMN_ADDRESS,c.getAddress());

            return db.insert(TABLE_NAME,null,values);
        }
        catch (Exception ex)
        {
            return -1;
        }
        finally {
            db.close();
        }
    }

    public long AddCustomer(String firstname, String lastName, String address)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        try{

            ContentValues values = new ContentValues();
            values.put(COLUMN_FIRSTNAME,firstname);
            values.put(COLUMN_LASTTNAME,lastName);
            values.put(COLUMN_ADDRESS,address);

            return db.insert(TABLE_NAME,null,values);
        }
        catch (Exception ex)
        {
            return -1;
        }
        finally {
            db.close();
        }
    }

    public ArrayList<Customer> GetCustomers()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =null;

        try{

            String query ="SELECT * FROM " + TABLE_NAME;
            cursor = db.rawQuery(query,null);

            if (cursor==null)
                throw new Exception("Could not read from database");
            ArrayList<Customer> customers = new ArrayList<>();

            while (cursor.moveToNext())
            {
                int cID = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CUSTOMERID));
                String fname = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME));
                String lname = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTTNAME));
                String address = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ADDRESS));

                customers.add(new Customer(cID,fname,lname,address));
            }
            return  customers;
        }
        catch (Exception ex)
        {
            return null;
        }
        finally {
            db.close();
            cursor =null;
        }
    }
}
