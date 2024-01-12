package model;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private int discount;
    private LocalDate discountLastDay = LocalDate.now();


}
