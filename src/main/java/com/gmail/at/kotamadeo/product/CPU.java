package com.gmail.at.kotamadeo.product;

import com.gmail.at.kotamadeo.utils.Utils;

public class CPU extends Product {
    private static final String[] NAMES = {"I9-12900K", "I9-11900K", "I9-10900K", "Ryzen 9 5900X", "Ryzen 9 3950X",
            "Ryzen 9 5950X"};
    private static final int[] PRICES = {799, 599, 499, 799, 699, 600};

    @Override
    public void productList() {
        super.names = NAMES;
        super.prices = PRICES;
        System.out.printf("%sСписок процессоров доступных к покупке:%s%n", Utils.ANSI_YELLOW, Utils.ANSI_RESET);
        super.productList();
    }

    @Override
    public String[] getNames() {
        return NAMES;
    }

    @Override
    public int[] getPrices() {
        return PRICES;
    }
}
