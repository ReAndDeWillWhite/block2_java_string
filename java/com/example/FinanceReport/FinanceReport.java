package com.example.FinanceReport;

import com.example.Payment.Payment;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class FinanceReport {

    private Payment payment;
    private Payment [] payments;
    private String fullAuthor;
    private Date reportDate;


    
    public FinanceReport(Payment[] payments, String fullAftor, Date reportDate) {
        this.payments = Arrays.copyOf(payments, payments.length);
        this.fullAuthor = fullAftor;
        this.reportDate = reportDate;
    }

    public FinanceReport(FinanceReport other) {
        this(Arrays.copyOf(other.payments, other.payments.length), other.fullAuthor, other.reportDate);
    }

    public Payment[] getPayments() {
        return Arrays.copyOf(payments, payments.length);
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    public int getAmountOfPayments () {
        return payments.length;
    }

    public Payment getIndexOfPayments(int i)  {
        if (i < 0 || i>= payments.length){
            throw new IndexOutOfBoundsException("Индекс платежа находится вне допустимого диапазона.");
        } else {
            return payments [i];
        }

    }
    public void setIndexOfPayment(int i, Payment payment) {
        if (i < 0 || i >= payments.length) {
            throw new IndexOutOfBoundsException("Индекс платежа находится вне допустимого диапазона.");
        }
        if(payment == null){
            throw new NullPointerException("Платеж не может быть null");
        }else {
            payments [i] = payment;
        }
    }

    public String getFullNameAftor() {

        return fullAuthor;
    }

    public void setFullNameAuthor(String fullNameAuthor) {

        this.fullAuthor = fullNameAuthor;
    }

    public Date getReportDate() {

        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Автор: %s, дата: %s , Платежи: [", getFullNameAftor(), sdf.format(reportDate)));
        for (Payment p : payments) {
            sb.append(String.format("Плательщик: %s, дата: %d.%d.%d сумма: %d руб. %d коп.\n", p.getName(), p.getDay(), p.getMonth(), p.getYear(), p.getSum() / 100, p.getSum()));
        }
            sb.append("]]");
        return sb.toString();
        }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return Objects.equals(payment, that.payment) && Objects.deepEquals(payments, that.payments) && Objects.equals(fullAuthor, that.fullAuthor) && Objects.equals(reportDate, that.reportDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment, Arrays.hashCode(payments), fullAuthor, reportDate);
    }
}
