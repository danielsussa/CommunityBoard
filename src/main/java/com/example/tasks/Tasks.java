package com.example.tasks;

import com.example.model.Canvas;
import com.example.model.CanvasFactory;
import com.example.service.CanvasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Level;

/**
 * Created by DEK on 25/01/2017.
 * Checa as conexões do TCP
 */
public class Tasks {

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Scheduled(cron = "0 */40 0 * * SUN", zone = TIME_ZONE)
    public void readMsg() {
        System.out.println("CLEAR!");
        Canvas canvas = CanvasFactory.getCanvas();
        //canvasServices.save(canvas);
        CanvasFactory.clear();
    }

}
