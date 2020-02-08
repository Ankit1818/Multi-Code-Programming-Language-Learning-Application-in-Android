package com.example.myadapater2;

public class Model
{
    String image;
    String text;

    public Model(String image, String text)
    {
        this.image=image;
        this.text=text;
    }
    public String getImage()
    {
        return image;
    }
    public void setImage(String image)
    {
        this.image = image;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
}
