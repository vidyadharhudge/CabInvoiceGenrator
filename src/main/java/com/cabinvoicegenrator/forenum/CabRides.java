package com.cabinvoicegenrator.forenum;
import com.cabinvoicegenrator.exception.CabInvoiceServiceException;
import com.cabinvoicegenrator.model.Ride;

public enum CabRides {
    NORMAL(10.0, 1.0, 5.0),
    PREMIUM(15.0,2.0,20.0);

    private final double costPerKilometer;
    private final double costPerMinute;
    private final double minFarePerRide;

    CabRides(double costPerKilometer, double costPerMinute, double minFarePerRide) {
        this.costPerKilometer = costPerKilometer;
        this.costPerMinute = costPerMinute;
        this.minFarePerRide = minFarePerRide;
    }

    public double calculateCostOfRide(Ride ride) {
        if (ride.distance >= 0 && ride.time >= 1) {
            double rideCost = ride.distance * costPerKilometer + ride.time * costPerMinute;
            return Math.max(rideCost, minFarePerRide);
        } else {
            throw new CabInvoiceServiceException(CabInvoiceServiceException.ExceptionType.NEGATIVE_DISTANCE,"Enter valid Distance And Time");
        }
    }
}

