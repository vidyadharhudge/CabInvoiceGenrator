package com.cabinvoicegenrator;

import java.util.Objects;

public class InvoiceSummary {
    private final double totalNumberOfRides;
    private final double totalFare;
    private final double avgFarePerRide;

    public InvoiceSummary(double totalNumberOfRides, double totalFare) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFare = totalFare;
        this.avgFarePerRide = this.totalFare/this.totalNumberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return totalNumberOfRides == summary.totalNumberOfRides &&
                Double.compare(summary.totalFare, totalFare) == 0 &&
                Double.compare(summary.avgFarePerRide, avgFarePerRide) == 0;
    }

}
