/** Made by Mantas Švedas
 * For Visma Paid Mobile Development (iOS/Android) Internship
 */

package com.example.visma_task_photos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.visma_task_photos.PhotoFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyPhotoRecyclerViewAdapter extends RecyclerView.Adapter<MyPhotoRecyclerViewAdapter.MyViewHolder> {

    private List<Photo> photoList;

    public MyPhotoRecyclerViewAdapter(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_photo, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Photo photo = photoList.get(position);

        // Picasso usage for easier photo loading
        Picasso.get()
                .load(photo.getUrl())
                .into(holder.image);
    }

    // Custom ViewHolder
    static class MyViewHolder extends RecyclerView.ViewHolder {
        final View view;
        ImageView image;
        //public Photo photo;

        MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            image = itemView.findViewById(R.id.photo_view);
        }
    }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return photoList.size();
    }
}