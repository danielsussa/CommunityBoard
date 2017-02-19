package com.example.model;

import org.springframework.stereotype.Component;

/**
 * Created by DEK on 18/02/2017.
 */

public class CanvasFactory {

    static  Canvas canvas = new Canvas();


    public static Canvas getCanvas() {
        return canvas;
    }

    public static void setCanvas(Canvas canvas) {
        CanvasFactory.canvas = canvas;
    }

    public static void clear() {
        canvas = new Canvas();
    }

}
