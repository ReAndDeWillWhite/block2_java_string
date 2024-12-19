package com.example.FinanceReportProcessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.Date;

import com.example.FinanceReport.FinanceReport;
import com.example.Payment.Payment;

public class FinanceReportProcessorTest {
        @Test
    public void fullNameBeginsWithMaxLetter() {
        Payment[] payments = {
                new Payment("Иванов Иван Иванович", 15, 03, 2024, 15000),
                new Payment("Петров Петр Петрович", 22, 04, 2024, 20000),
                new Payment("Сидорова Сидорова Сидоровна", 05, 05, 2024, 12000),
                new Payment("Кузнецов Кузьма Кузьмич", 20, 11, 2024, 30000)
        };
        Payment[] payment = {
            new Payment("Кузнецов Кузьма Кузьмич", 20, 11, 2024, 30000)
        };
        FinanceReport fr = new FinanceReport(payment, "Кирилл Кирилович", new Date());
        FinanceReport fr1 = new FinanceReport(payments, "Кирилл Кирилович", new Date());
        assertEquals(fr, FinanceReportProcessor.fullNameBeginsWithLetter(fr1, payments, 'К'));
    }
    @Test
    public void fullNameBeginsWithMinLetter() {
        Payment[] payments = {
            new Payment("Иванов Иван Иванович", 15, 03, 2024, 15000),
            new Payment("Петров Петр Петрович", 22, 04, 2024, 20000),
            new Payment("Сидорова Сидорова Сидоровна", 05, 05, 2024, 12000),
            new Payment("Кузнецов Кузьма Кузьмич", 20, 12, 2024, 30000)
        };
        Payment[] payment = {
            new Payment("Кузнецов Кузьма Кузьмич", 20, 12, 2024, 30000)
        };
        FinanceReport fr = new FinanceReport(payment, "Кирилл Кирилович", new Date());
        FinanceReport fr1 = new FinanceReport(payments, "Кирилл Кирилович", new Date());
        assertEquals(fr, FinanceReportProcessor.fullNameBeginsWithLetter(fr1, payments, 'К'));
    }

    @Test
    public void fullNameBeginsWithLetterException() {
        Payment[] payments = {
            new Payment("Иванов Иван Иванович", 15, 03, 2024, 15000),
            new Payment("Петров Петр Петрович", 22, 04, 2024, 20000),
            new Payment("Сидорова Сидорова Сидоровна", 05, 05, 2024, 12000),
            new Payment("Кузнецов Кузьма Кузьмич", 20, 12, 2024, 30000)
        };
        Payment[] payment = {
        };
        FinanceReport fr = new FinanceReport(payment, "Кирилл Кирилович", new Date());
        FinanceReport fr1 = new FinanceReport(payments, "Кирилл Кирилович", new Date());
        assertEquals(fr, FinanceReportProcessor.fullNameBeginsWithLetter(fr1, payments, ' '));
    }


    @Test
    public void smallerPayments() {
        Payment[] payments = {
            new Payment("Иванов Иван Иванович", 15, 03, 2024, 15000),
            new Payment("Петров Петр Петрович", 22, 04, 2024, 20000),
            new Payment("Сидорова Сидорова Сидоровна", 05, 05, 2024, 12000),
            new Payment("Кузнецов Кузьма Кузьмич", 20, 12, 2024, 30000)
        };

        Date date = new Date();
        FinanceReport fr1 = new FinanceReport(payments, "Кирилл Кирилович", date);
        Payment[] expectedPayments = {
            new Payment("Иванов Иван Иванович", 15, 03, 2024, 15000),
            new Payment("Петров Петр Петрович", 22, 04, 2024, 20000),
            new Payment("Сидорова Сидорова Сидоровна", 05, 05, 2024, 12000),
        };
        FinanceReport expected = new FinanceReport(expectedPayments, "Кирилл Кирилович", date);
        FinanceReport filtered = FinanceReportProcessor.smallerPayments(fr1, payments, 25000);

        assertEquals(expected, filtered);

    }

    @Test
    public void smallerPaymentsException() {
        Payment[] payments = {
            new Payment("Иванов Иван Иванович", 15, 03, 2024, 15000),
            new Payment("Петров Петр Петрович", 22, 04, 2024, 20000),
            new Payment("Сидорова Сидорова Сидоровна", 05, 05, 2024, 12000),
            new Payment("Кузнецов Кузьма Кузьмич", 20, 12, 2024, 30000)
        };

        Date date = new Date();
        FinanceReport fr1 = new FinanceReport(payments, "Кирилл Кирилович", date);
        assertThrows(IllegalArgumentException.class, () -> {
            FinanceReportProcessor.smallerPayments(fr1, payments, -100);
        });
    }
}
