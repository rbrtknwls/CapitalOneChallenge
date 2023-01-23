package com.rewards.model.service.vendor;

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
