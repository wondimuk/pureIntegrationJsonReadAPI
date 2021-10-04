package com.pi.picodingreadjson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pi.picodingreadjson.model.BreedsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;

@Service
public class BreedsService {

    private BreedsModel breedsModel;

    private FileReader fileReader;

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    //    method to read Json file
    public BreedsModel getAllData() throws IOException {
        fileReader = new FileReader("apidata.json");

//        Object mapper help to read json file to a business model
        breedsModel = objectMapper.readValue(fileReader, BreedsModel.class);

        return breedsModel;
    }
}
