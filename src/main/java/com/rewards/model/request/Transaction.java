package com.rewards.model.request;


import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    Date date;
    String merchant_code;
    long amount_cents;

}
