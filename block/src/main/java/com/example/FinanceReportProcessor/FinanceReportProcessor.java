package com.example.FinanceReportProcessor;

import java.util.ArrayList;
import java.util.List;

import com.example.FinanceReport.FinanceReport;
import com.example.Payment.Payment;

import static java.lang.Character.toLowerCase;

public class FinanceReportProcessor {
    public static FinanceReport fullNameBeginsWithLetter(FinanceReport report, Payment[] payments, char letter) {
        List<Payment> payment = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getName().trim().toLowerCase().charAt(0) == toLowerCase(letter)) {
                payment.add(p);
            }
        }
        return new FinanceReport(payment.toArray(new Payment[0]), report.getFullNameAftor(), report.getReportDate());
    }
    public static FinanceReport smallerPayments( FinanceReport report, Payment[] payments, int value) {
        List<Payment> payment = new ArrayList<>();
            for (Payment p : payments) {
                if (p.getSum() < value) {
                    payment.add(p);
                }
            }
            if (value<0){
                throw new IllegalArgumentException("Сумма не может быть меньше нуля");
            }
        return new FinanceReport(payment.toArray(new Payment[0]), report.getFullNameAftor(), report.getReportDate());
    }
}
