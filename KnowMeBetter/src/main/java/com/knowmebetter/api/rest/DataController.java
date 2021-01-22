package com.knowmebetter.api.rest;

import com.knowmebetter.application.manager.DataManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DataController extends RestBaseController {

    @Autowired
    private DataManager dataManager;

    @GetMapping("formatdata")
    private void formatdata() throws IOException, InvalidFormatException {
        dataManager.formatdata();
    }

    @GetMapping("jointure")
    private void jointure() throws IOException, InvalidFormatException {
        dataManager.jointure();
    }

    @GetMapping("top")
    private void top() throws IOException, InvalidFormatException {
        dataManager.top();
    }
}
