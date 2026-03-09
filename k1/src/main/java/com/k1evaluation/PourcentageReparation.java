package com.k1evaluation;

public class PourcentageReparation {

    private double ranger;
    private double everest;
    private double yukon;
    private double ram;

    public void setRanger(double ranger) {
        this.ranger = ranger;
    }

    public void setEverest(double everest) {
        this.everest = everest;
    }

    public void setYukon(double yukon) {
        this.yukon = yukon;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public double getRanger() {
        return ranger;
    }

    public double getEverest() {
        return everest;
    }

    public double getYukon() {
        return yukon;
    }

    public double getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "PourcentageReparation{" +
                "ranger=" + ranger +
                ", everest=" + everest +
                ", yukon=" + yukon +
                ", ram=" + ram +
                '}';
    }
}
