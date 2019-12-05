/** Made by Mantas Švedas
 * For Visma Paid Mobile Development (iOS/Android) Internship
 */

package com.example.visma_task_photos;

public class Photo {

    private String url;

    // Default constructor, just in case
    public Photo(){
        this.url = "_";
    }

    public Photo(String url){
        this.url = url;
    }

    public String getUrl() {return this.url;}
    public void setUrl(String url) {this.url = url;}
}
