package com.example.controller;

import com.example.model.Canvas;
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

    Canvas canvas = new Canvas();

    @RequestMapping
    public ModelAndView getPage(){
        ModelAndView mv = new ModelAndView("board/board");
        mv.addObject("canvas",canvas);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody String saveDraw(@ModelAttribute("canvas") String data){
        canvas.setData(data);
        canvas.setMillis(System.currentTimeMillis());
        return "board/board";
    }

    @RequestMapping(value = "/getCanvas", method = RequestMethod.GET)
    public @ResponseBody String getCanvas(@ModelAttribute("canvas") String data){
        return canvas.getData();
    }
}
