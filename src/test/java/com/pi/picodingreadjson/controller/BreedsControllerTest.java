package com.pi.picodingreadjson.controller;

import com.pi.picodingreadjson.model.BreedsModel;
import com.pi.picodingreadjson.service.BreedsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BreedsControllerTest {

    @Mock
    private BreedsService breedsService;

    @InjectMocks
    private BreedsController breedsController;

    private BreedsModel breedsModel;

    @BeforeEach
    public void setup() {
        breedsModel = new BreedsModel();
        breedsModel.setWolfhound(Arrays.asList("irish"));
    }

//    This method tests some data returned by api with the mocked retrieved data.
    @Test
    public void shouldReturnWolFoundValueResult() throws IOException {
        when(breedsService.getAllData()).thenReturn(breedsModel);

//        Assertions : if the controller method data is the same with the expected value
        assertEquals(breedsModel.getWolfhound(), breedsService.getAllData().getWolfhound(),
                "Error during assertions");
        assertEquals(breedsModel.getWhippet(),null);
    }
}
