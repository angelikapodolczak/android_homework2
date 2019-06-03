package com.example.homework2_list;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework2_list.items.ItemListContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoItemFragment extends Fragment {

    private ItemListContent.Item mDisplayedItem;

    public InfoItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        Intent intent = activity.getIntent();

        if(intent !=null) {
            ItemListContent.Item recivedItem = intent.getParcelableExtra(MainActivity.itemExtra);
            if(recivedItem != null) {
                displayItem(recivedItem);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_item, container, false);
    }


    public void displayItem(ItemListContent.Item item){
        FragmentActivity activity = getActivity();

        TextView itemInfoCar = activity.findViewById(R.id.ItemInfoCar);
        TextView itemInfoColor = activity.findViewById(R.id.ItemInfoColor);
        TextView itemInfoSpecification = activity.findViewById(R.id.ItemInfoSpecification);
        final ImageView itemInfoImage = activity.findViewById(R.id.ItemInfoImage);

        itemInfoCar.setText(item.car);
        itemInfoColor.setText(item.color);
        itemInfoSpecification.setText(item.specification);
        if(item.picPath != null && !item.picPath.isEmpty()){
            if(item.picPath.contains("car")) {
                Drawable itemDrawable;
                switch(item.picPath){
                    case "car1":
                        itemDrawable = activity.getResources().getDrawable(R.drawable.car1);
                        break;
                    case "car2":
                        itemDrawable = activity.getResources().getDrawable(R.drawable.car2);
                        break;
                    case "car3":
                        itemDrawable = activity.getResources().getDrawable(R.drawable.car3);
                        break;
                    case "car4":
                        itemDrawable = activity.getResources().getDrawable(R.drawable.car4);
                        break;
                    case "car5":
                        itemDrawable =activity.getResources().getDrawable(R.drawable.car5);
                        break;
                    case "car6":
                        itemDrawable = activity.getResources().getDrawable(R.drawable.car6);
                        break;
                    case "car7":
                        itemDrawable = activity.getResources().getDrawable(R.drawable.car7);
                        break;
                    default:
                        itemDrawable = activity.getResources().getDrawable(R.drawable.car);

                }
                itemInfoImage.setImageDrawable(itemDrawable);
            } else {
                Handler handler = new Handler();
                itemInfoImage.setVisibility(View.INVISIBLE);
                handler. postDelayed(new Runnable() {
                    @Override
                    public void run(){
                        itemInfoImage.setVisibility(View.VISIBLE);
                        Bitmap cameraImage = PicUtils.decodePic(mDisplayedItem.picPath,
                                itemInfoImage.getWidth(),
                                itemInfoImage.getHeight());
                        itemInfoImage.setImageBitmap(cameraImage);
                    }
                }, 200);
            }
        } else{
            itemInfoImage.setImageDrawable(activity.getResources().getDrawable(R.drawable.car));
        }
        mDisplayedItem = item;
    }
}
