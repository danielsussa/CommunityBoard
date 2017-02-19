package com.example.controller;

import com.example.model.Canvas;
import com.example.model.CanvasFactory;
import com.example.repo.CanvasRepo;
import com.example.service.CanvasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by daniel on 15/09/16.
 */

@Controller
@RequestMapping
public class BoardController {

    @Autowired
    CanvasServices canvasServices;

    @RequestMapping
    public ModelAndView getPage(){
        ModelAndView mv = new ModelAndView("board/board");
        Canvas canvas = CanvasFactory.getCanvas();
        mv.addObject("canvas",canvas);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody String saveDraw(@ModelAttribute("canvas") String data){
        Canvas canvas = CanvasFactory.getCanvas();
        canvas.setData(data);
        canvas.setMillis(System.currentTimeMillis());
        return "board/board";
    }

    @RequestMapping(value = "/getCanvas", method = RequestMethod.GET)
    public @ResponseBody String getCanvas(){
        Canvas canvas = CanvasFactory.getCanvas();
        return canvas.getData();
    }
}
