package com.example.homework2_list.items;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Item> ITEMS = new ArrayList<Item>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Item item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void removeItem(int position) {
        String itemId = ITEMS.get(position).id;
        ITEMS.remove(position);
        ITEM_MAP.remove(itemId);
    }

    public static void clearList() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    private static Item createDummyItem(int position) {

        switch(position){
            case 1:
                return new Item(String.valueOf(position), "Skoda Octavia", "biały", "Samochód osobowy klasy kompaktowej produkowany od 1996 roku.", "car1");
            case 2:
                return new Item(String.valueOf(position), "Opel Insignia", "czarny", "Samochód osobowy klasy średniej produkowany od 2008 roku.", "car2");
            case 3:
                return new Item(String.valueOf(position), "Volkswagen Golf", "żółty", "Samochód osobowy klasy kompaktowej produkowany od 1974 roku. ", "car3");
            case 4:
                return new Item(String.valueOf(position), "Toyota Yaris", "czerwony", "Samochód osobowy klasy miejskiej produkowany od 1999 roku.", "car4");
            case 5:
                return new Item(String.valueOf(position), "Dacia Duster", "niebieski", "Samochód sportowo-użytkowy klasy kompaktowej produkowany od 2010 roku.", "car5");
            default:
                return new Item(String.valueOf(position), "Auto", "Kolor", "Opis","car");
        }

    }


    /**
     * A dummy item representing a piece of title.
     */
    public static class Item implements Parcelable {
        public final String id;
        public final String car;
        public final String color;
        public final String specification;
        public String picPath;

        //Redundant
        public Item(String id, String car, String color, String specification) {
            this.id = id;
            this.car = car;
            this.color = color;
            this.specification = specification;
            this.picPath = "";
        }

        public Item(String id, String car, String color, String specification, String picPath) {
            this.id = id;
            this.car = car;
            this.color = color;
            this.specification = specification;
            this.picPath = picPath;
        }

        protected Item(Parcel in) {
            id = in.readString();
            car = in.readString();
            color = in.readString();
            specification = in.readString();
            picPath = in.readString();
        }

        public static final Creator<Item> CREATOR = new Creator<Item>() {
            @Override
            public Item createFromParcel(Parcel in) {
                return new Item(in);
            }

            @Override
            public Item[] newArray(int size) {
                return new Item[size];
            }
        };

        @Override
        public String toString() {
            return car;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(car);
            dest.writeString(color);
            dest.writeString(specification);
            dest.writeString(picPath);
        }
    }
}
