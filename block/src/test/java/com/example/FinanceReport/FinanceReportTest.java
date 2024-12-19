package com.example.FinanceReport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.Date;

import com.example.Payment.Payment;

public class FinanceReportTest {

        @Test
    public void getIndexOfPayment() {
        Payment[] payments = {
                new Payment("Иванов Иван Иванович", 10, 10, 2023, 10000),
                new Payment("Тумба Юмба Акамонова", 15, 11, 2023, 20000),
                new Payment("Пумбович Тимон Александрович", 20, 12, 2023, 30000),
                new Payment("Кума Тамара Ивановна", 25, 1, 2024, 15000)
        };
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        Payment payment = new Payment("Пумбович Тимон Александрович", 20, 12, 2023, 30000);
        assertEquals(payment, fr.getIndexOfPayments(2));
    }

    @Test
    public void getIndexOfPaymentException() {
        Payment[] payments = {
                new Payment("Иванов Иван Иванович", 10, 10, 2023, 10000),
                new Payment("Тумба Юмба Акамонова", 15, 11, 2023, 20000),
                new Payment("Пумбович Тимон Александрович", 20, 12, 2023, 30000),
                new Payment("Кума Тамара Ивановна", 25, 1, 2024, 15000)
        };
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.getIndexOfPayments(-2);
        });
    }

    @Test
    public void getIndexOfPaymentExceptionMoreLenght() {
        Payment[] payments = {
                new Payment("Иванов Иван Иванович", 10, 10, 2023, 10000),
                new Payment("Тумба Юмба Акамонова", 15, 11, 2023, 20000),
                new Payment("Пумбович Тимон Александрович", 20, 12, 2023, 30000),
                new Payment("Кума Тамара Ивановна", 25, 1, 2024, 15000)
        };
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.getIndexOfPayments(5);
        });
    }

    @Test
    public void setIndexOfPayments() {
        Payment[] payments = {new Payment("Test 1", 1, 1, 2024, 1000)};
        Payment newPayment = new Payment("Сидоров Сидор Сидорович", 20, 3, 2024, 75000);
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        fr.setIndexOfPayment(0, newPayment);
        assertEquals(newPayment, fr.getIndexOfPayments(0));
    }

    @Test
    public void setIndexOfPaymentsException() {
        Payment[] payments = {new Payment("Test 1", 1, 1, 2024, 1000)};
        Payment newPayment = new Payment("Сидоров Сидор Сидорович", 20, 3, 2024, 75000);
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.setIndexOfPayment(-1, newPayment);
        });
    }


    @Test
    public void setIndexOfPaymentsExceptionMoreLenght() {
        Payment[] payments = {new Payment("Test 1", 1, 1, 2024, 1000)};
        Payment newPayment = new Payment("Сидоров Сидор Сидорович", 20, 3, 2024, 75000);
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.setIndexOfPayment(3, newPayment);
        });
    }
}
