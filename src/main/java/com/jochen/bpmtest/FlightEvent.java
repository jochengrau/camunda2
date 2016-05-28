package com.jochen.bpmtest;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jochen on 24May16.
 */
public class FlightEvent /*implements Serializable*/ {

    String airline;
    Integer flightNumber;
    Date departureDate;
    Date arrivalDate;
    String aircraft;
    String depStation;
    String arrStation;

    public FlightEvent(String airline, Integer flightNumber, Date departureDate, Date arrivalDate, String aircraft, String depStation, String arrStation) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.aircraft = aircraft;
        this.depStation = depStation;
        this.arrStation = arrStation;
    }

    public FlightEvent() {
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getDepStation() {
        return depStation;
    }

    public void setDepStation(String depStation) {
        this.depStation = depStation;
    }

    public String getArrStation() {
        return arrStation;
    }

    public void setArrStation(String arrStation) {
        this.arrStation = arrStation;
    }

    @Override
    public String toString() {
        return "FlightEvent{" +
                "airline='" + airline + '\'' +
                ", flightNumber=" + flightNumber +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", aircraft='" + aircraft + '\'' +
                ", depStation='" + depStation + '\'' +
                ", arrStation='" + arrStation + '\'' +
                '}';
    }
}
