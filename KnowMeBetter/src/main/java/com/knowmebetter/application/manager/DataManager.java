package com.knowmebetter.application.manager;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public interface DataManager {
    void formatdata() throws IOException, InvalidFormatException;

    void jointure()  throws IOException, InvalidFormatException;

    void top() throws IOException, InvalidFormatException;
}
