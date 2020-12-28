package com.may.covid19tracker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataService{

    public List<KoreaCovidInfo> getCovidDatas() throws IOException {
        List<KoreaCovidInfo> list = new ArrayList<>();
        String COVID_DATA_URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
        Document doc = Jsoup.connect(COVID_DATA_URL).get();
        Elements elements = doc.select("table tbody tr");

        for(Element element: elements){
            Elements tdElements = element.select("td");

            KoreaCovidInfo koreaCovidInfo = KoreaCovidInfo.builder()
                    .country(element.select("th").text())
                    .totalNum(Integer.parseInt(tdElements.get(3).text().replace(",","")))
                    .diffFromBeforeDay(Integer.parseInt(tdElements.get(0).text().replace(",","")))
                    .deathNum(Integer.parseInt(tdElements.get(6).text().replace(",","")))
                    .incidence(Double.parseDouble(tdElements.get(7).text().replace("-","0")))
                    .build();

            list.add(koreaCovidInfo);
        }
        return list;
    }
}
