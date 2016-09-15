package com.example.controller;

import com.example.model.Canvas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by daniel on 15/09/16.
 */

@Controller
@RequestMapping
public class BoardController {

    Canvas canvas = new Canvas();

    @RequestMapping
    public String getPage(){
        return "board/board";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody String saveDraw(@ModelAttribute("canvas") String data){
        canvas.setData(data);
        return "board/board";
    }
}
