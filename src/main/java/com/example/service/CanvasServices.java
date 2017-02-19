package com.example.service;

import com.example.model.Canvas;
import com.example.repo.CanvasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DEK on 18/02/2017.
 */

@Service
public class CanvasServices {

    @Autowired
    CanvasRepo canvasRepo;

    public Canvas findLast(){
        List<Canvas> AllCanvas = canvasRepo.findAll();
        return AllCanvas.get(AllCanvas.size()-1);
    }

    public Canvas save(Canvas canvas){
        return canvasRepo.save(canvas);
    }
}
