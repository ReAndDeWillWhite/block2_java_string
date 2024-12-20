package com.example.Payment;

public class Payment {
    private String name;
    private int day;
    private int month;
    private int year;
    private int sum;

    // Конструкторы
        public Payment () {
            
        }

        public Payment(String name, int day, int month, int year, int sum) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sum = sum;
    }
    // Конструкторы

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    // Сеттеры

    // Геттеры
    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getSum() {
        return sum;
    }
    
    // Геттеры

    // hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        result = prime * result + sum;
        return result;
    }
    // hashCode

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Payment other = (Payment) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        if (sum != other.sum)
            return false;
        return true;
    }
        // equals

        //toString
    @Override
    public String toString() {
        return "Payment [name=" + name + ", day=" + day + ", month=" + month + ", year=" + year + ", sum=" + sum + "]";
    }
        //toString

        
}
