/** Made by Mantas Švedas
 * For Visma Paid Mobile Development (iOS/Android) Internship
 */

package com.example.visma_task_photos;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity {

    private ImageView imageView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageView = findViewById(R.id.imageView);

        // Getting intent from main activity
        if(getIntent().hasExtra("_url")){
            url = getIntent().getExtras().getString("_url");;
        }

        // Displaying photo
        Picasso.get()
                .load(url)
                .into(imageView);
    }
}
