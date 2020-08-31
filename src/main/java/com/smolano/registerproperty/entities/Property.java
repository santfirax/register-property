package com.smolano.registerproperty.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private double area;
    private int numberOfRooms;
    private int numberOfBathrooms;
    private boolean isForSale;
    private boolean isForLease;
    private double leaseValue;
    private String code= UUID.randomUUID().toString();

    public Property(double area, int numberOfRooms, int numberOfBathrooms, boolean isForSale, boolean isForLease, double leaseValue) {
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.isForSale = isForSale;
        this.isForLease = isForLease;
        this.leaseValue = leaseValue;
    }

    public Property() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", isForSale=" + isForSale +
                ", isForLease=" + isForLease +
                ", leaseValue=" + leaseValue +
                ", code='" + code + '\'' +
                '}';
    }
}
