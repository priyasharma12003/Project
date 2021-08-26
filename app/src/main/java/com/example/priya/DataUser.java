package com.example.priya;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class DataUser {

        private String name;
        private int age;
        private boolean active;
        private String imageUrl;

        public DataUser(String name, int age, boolean active, String imageUrl) {
            this.name = name;
            this.age = age;
            this.active = active;
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", active=" + active +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
        }

       @BindingAdapter("android:imageloader")
        public static void imageload(ImageView imageView,String imageUrl){
           Glide.with(imageView)
                   .load(imageUrl)
                   .into(imageView);

        }
}
