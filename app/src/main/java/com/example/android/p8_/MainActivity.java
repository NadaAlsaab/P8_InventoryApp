package com.example.android.p8_;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.p8_.ContractClass.BooksEntry;

public class MainActivity extends AppCompatActivity {

    // Create database helper
    HelperClass helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new HelperClass(this);
        insertData();
    }

    public void insertData(){
        // Insert into database.

        // Gets the database in write mode
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BooksEntry.COLUMN_NAME,"WHO MOVED MY CHEESE");
        values.put(BooksEntry.COLUMN_PRICE, 40);
        values.put(BooksEntry.COLUMN_QUANTITY, 30);
        values.put(BooksEntry.COLUMN_IMAGE, "img");
        values.put(BooksEntry.COLUMN_SUPPLIER, "JAREER");
        values.put(BooksEntry.COLUMN_SUPER_PHONE_NUMBER, 25);


        long newRowId = db.insert(BooksEntry.TABLE_NAME,null,values);

        Log.e("... Price ...",""+values.get(BooksEntry.COLUMN_PRICE));
        Log.e("... Quantity ...",""+values.get(BooksEntry.COLUMN_QUANTITY));
        Log.e("... Image ...",""+values.get(BooksEntry.COLUMN_IMAGE));


        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving Book", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Book saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }

        Cursor cursor = db.query(ContractClass.BooksEntry.TABLE_NAME, null, null, null, null, null, null);


        TextView scoreView = (TextView) findViewById(R.id.txt);
        scoreView.setText("Items in the Database " + cursor.getCount());
        Log.e("countable", ""+cursor.getCount());

        queryData();
        cursor.close();

    }

    private Cursor queryData(){
        /**
         * Query the database.
         * Always close the cursor when you're done reading from it.
         * This releases all its resources and makes it invalid.
         */
        SQLiteDatabase database = helper.getReadableDatabase();
        String[] project = {BooksEntry._ID, BooksEntry.COLUMN_NAME, BooksEntry.COLUMN_QUANTITY};
        return database.query(BooksEntry.TABLE_NAME, project, null, null, null, null, null);
    }
}
