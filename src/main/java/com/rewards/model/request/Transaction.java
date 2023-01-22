package com.rewards.model.request;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Transaction {
    LocalDate date;
    String merchant_code;
    long amount_cents;

}
