package io.sankalp.coronavirustracker.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LocationStats {

    private String state;

    private String country;

    private int latestReportedTotalCases;

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestReportedTotalCases=" + latestReportedTotalCases +
                '}';
    }
}
