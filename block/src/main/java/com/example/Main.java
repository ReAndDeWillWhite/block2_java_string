package com.example;

import java.util.Date;

import com.example.FinanceReport.FinanceReport;
import com.example.Payment.Payment;

import static com.example.FinanceReportProcessor.FinanceReportProcessor.fullNameBeginsWithLetter;
import static com.example.FinanceReportProcessor.FinanceReportProcessor.smallerPayments;

public class Main {
        public static void main(String[] args) {
        Payment[] payments = {
            new Payment("Иванов Иван Иванович", 15, 03, 2024, 15000),
            new Payment("Петров Петр Петрович", 22, 04, 2024, 20000),
            new Payment("Сидорова Сидорова Сидоровна", 05, 05, 2024, 12000),
            new Payment("Кузнецов Кузьма Кузьмич", 20, 12, 2024, 30000)
        };
        Date reportDate = new Date();
        FinanceReport report = new FinanceReport(payments, "Кирилл Кирилович Кирилов", reportDate);

        System.out.println("Количество платежей: " + report.getAmountOfPayments());

        FinanceReport fullNameBeginsWithLetter = fullNameBeginsWithLetter(report, payments, 'И');
        System.out.println("\nПервая буква Фамилии 'И':\n" + fullNameBeginsWithLetter);

        FinanceReport smallerPayments = smallerPayments(report, payments, 20000);
        System.out.println("\nПлатежи, у которых сумма меньше\n" + smallerPayments);

        System.out.println("Платеж " + report.getIndexOfPayments(0));

        Payment newPayment = new Payment("Сидоров Сидор Сидорович", 20, 3, 2024, 75000);
        report.setIndexOfPayment(0, newPayment);
        System.out.println("Платеж " + report.getIndexOfPayments(0));
    }
}
