package com.may.covid19tracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CovidDataServiceTest {

    @Autowired
    CovidDataService covidDataService;

    @Test
    public void getCovidDatas() throws IOException {
        List<KoreaCovidInfo> list = new ArrayList<>();

        // when
        list = covidDataService.getCovidDatas();

        // then
        assertEquals("합계", list.get(0).getCountry());

    }
}