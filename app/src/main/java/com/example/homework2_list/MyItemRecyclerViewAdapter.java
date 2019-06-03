package com.example.homework2_list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework2_list.ItemFragment.OnListFragmentInteractionListener;
import com.example.homework2_list.items.ItemListContent.Item;

import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<Item> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Item item = mValues.get(position);
        holder.mItem = item;
        holder.mContentView.setText(item.car);
        final String picPath = item.picPath;
        Context context = holder.mView.getContext();
        if(picPath != null && !picPath.isEmpty()){
            //if picPath is set
            if(picPath.contains("car"))
            {
                Drawable itemDrawable;
                switch(picPath){
                    case "car1":
                        itemDrawable = context.getResources().getDrawable(R.drawable.car1);
                        break;
                    case "car2":
                        itemDrawable = context.getResources().getDrawable(R.drawable.car2);
                        break;
                    case "car3":
                        itemDrawable = context.getResources().getDrawable(R.drawable.car3);
                        break;
                    case "car4":
                        itemDrawable = context.getResources().getDrawable(R.drawable.car4);
                        break;
                    case "car5":
                        itemDrawable = context.getResources().getDrawable(R.drawable.car5);
                        break;
                    case "car6":
                        itemDrawable = context.getResources().getDrawable(R.drawable.car6);
                        break;
                    case "car7":
                        itemDrawable = context.getResources().getDrawable(R.drawable.car7);
                        break;
                    default:
                        itemDrawable = context.getResources().getDrawable(R.drawable.car);

                }
                holder.mItemImageView.setImageDrawable(itemDrawable);
            }
            else
            {
                Bitmap cameraImage = PicUtils.decodePic(item.picPath, 60, 90);
                holder.mItemImageView.setImageBitmap(cameraImage);
            }
        }else {
            holder.mItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.car));
        }

        holder.mDeleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentClickInteraction(holder.mItem, position, true);
                }
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentClickInteraction(holder.mItem, position, false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mItemImageView;
        public final TextView mContentView;
        public final ImageButton mDeleteView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemImageView = view.findViewById(R.id.book_img);
            mContentView = (TextView) view.findViewById(R.id.content);
            mDeleteView = (ImageButton) view.findViewById(R.id.img_delete);
        }

        @Override
        public String toString() {

            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
