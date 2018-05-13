package com.app.altex.altexsafe.customelements;

/**
 * Created by igorqua on 13.03.2018.
 */


import java.io.Serializable;

/**
 * Represents an Item in our application. Each item has a name, id, full size image url and
 * thumbnail url.
 */
public class ImageGridItem implements Serializable {

    private static final String LARGE_BASE_URL = "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/large/";
    private static final String THUMB_BASE_URL = "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/";



    public String mName;
    public String mContent = "";
    public String image;

    public ImageGridItem(String name, String content, String url) {
        mName = name;
        mContent = content;
        image = url;
    }

    public int getId() {
        return mName.hashCode();
    }
    public String getImage() {
        return image;
    }

    public String getContent() { return mContent;   }

    public String getName() {
        return mName;
    }
}

