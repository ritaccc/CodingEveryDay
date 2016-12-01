package com.company;

/**
 * Created by feideng on 10/19/16.
 */
public class Number {
    int value;
    int position;
    //GreenfootImage image = this.getImage();
    //image.scale(70, 70);

    Number(int value) {
        this.value = value;
    }

    public void act()
    {
//        if(Greenfoot.mouseDragged(this)) {
//            MouseInfo mouse = Greenfoot.getMouseInfo();
//            int mouseX = mouse.getX();
//            int mouseY = mouse.getY();
//            this.setLocation(mouseX, mouseY);
//        }
    }
    //@override
    // override getimage function, so we can get image file seperately.
    public void getImage(int number) {

    }
}
