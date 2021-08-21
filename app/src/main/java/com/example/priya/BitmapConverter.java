package com.example.priya;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;

public class BitmapConverter {
    @TypeConverter
    public byte[] Bitmaptobytes(Bitmap bitmap){
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,70,outputStream);
        byte bytes[];
        bytes=outputStream.toByteArray();

        return bytes;
    }
    @TypeConverter
    public Bitmap bytetobitmap(byte[] bytes)
    {
        Bitmap bitmap=BitmapFactory.decodeByteArray(bytes,0, bytes.length);
        return bitmap;
    }
}
