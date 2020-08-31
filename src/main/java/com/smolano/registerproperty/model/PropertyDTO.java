package com.smolano.registerproperty.model;

public class PropertyDTO {
    private double area;
    private int numberOfRooms;
    private int numberOfBathrooms;
    private boolean isForSale;
    private boolean isForLease;
    private double leaseValue;

    public PropertyDTO() {

    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public boolean isForLease() {
        return isForLease;
    }

    public void setForLease(boolean forLease) {
        isForLease = forLease;
    }

    public double getLeaseValue() {
        return leaseValue;
    }

    public void setLeaseValue(double leaseValue) {
        this.leaseValue = leaseValue;
    }

    @Override
    public String toString() {
        return "PropertyDTO{" +
                "area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", isForSale=" + isForSale +
                ", isForLease=" + isForLease +
                ", leaseValue=" + leaseValue +
                '}';
    }
}
