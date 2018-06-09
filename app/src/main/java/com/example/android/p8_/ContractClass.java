package com.example.android.p8_;

import android.provider.BaseColumns;

public class ContractClass {


    private ContractClass() {
    }

    public static final class BooksEntry implements BaseColumns {

        public final static String TABLE_NAME = "Bookstore";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_NAME = "name";

        public final static String COLUMN_PRICE = "price";

        public final static String COLUMN_QUANTITY = "quantity";

        public final static String COLUMN_IMAGE = "images";

        public final static String COLUMN_SUPPLIER = "supplier";

        public final static String COLUMN_SUPER_PHONE_NUMBER = "phone";
    }

}
