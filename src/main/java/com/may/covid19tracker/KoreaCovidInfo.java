package com.may.covid19tracker;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class KoreaCovidInfo {
    private String country; // 시도명

    private int totalNum; // 확진환자

    private int diffFromBeforeDay; // 전일대비확진환자 증감

    private int deathNum; // 사망자

    private double incidence; // 발생률
}
