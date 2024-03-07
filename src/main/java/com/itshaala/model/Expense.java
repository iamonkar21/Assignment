package com.itshaala.model;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Expense {
    private String title;
    private double amount;
    private String note;
    private Date date;
    private Time time;
    private String paymentMode;
}
