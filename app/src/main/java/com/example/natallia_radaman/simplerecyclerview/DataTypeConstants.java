package com.example.natallia_radaman.simplerecyclerview;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({DataTypeConstants.AUTHOR_DATA_TYPE, DataTypeConstants.CONTENT_DATA_TYPE, DataTypeConstants.HEADER_DATA_TYPE})
@Retention(RetentionPolicy.SOURCE)
@interface DataTypeConstants {

    int AUTHOR_DATA_TYPE = 0;
    int CONTENT_DATA_TYPE = 1;
    int HEADER_DATA_TYPE = 2;
}
