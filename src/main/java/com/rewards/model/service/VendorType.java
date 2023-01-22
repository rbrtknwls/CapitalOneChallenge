package com.rewards.model.service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;

public enum VendorType {
    SportsCheck, TimHortons, Subway, Other;

    public static VendorType getType(String vendor) {
        return switch (vendor) {
            case "sportcheck" -> SportsCheck;
            case "tim_hortons" -> TimHortons;
            case "subway" -> Subway;
            default -> Other;
        };

    }


}
