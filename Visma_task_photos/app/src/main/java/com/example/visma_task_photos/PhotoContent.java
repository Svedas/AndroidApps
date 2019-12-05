/** Made by Mantas Švedas
 * For Visma Paid Mobile Development (iOS/Android) Internship
 */

package com.example.visma_task_photos;

import java.util.ArrayList;
import java.util.List;

public class PhotoContent {

    // Static field for storing photos (urls)
    public static final List<Photo> ITEMS = new ArrayList<>();
    public static void addItem(Photo item) {
        ITEMS.add(0, item);
    }
}
