package com.gmail.at.kotamadeo.product;

import com.gmail.at.kotamadeo.utils.Utils;

public class MotherBoards extends Product {
    private static final String[] NAMES = {"Gigabyte Z690 AORUS", "ROG MAXIMUS Z690", "MSI Z690 Tomahawk",
            "Asus ROG HERO XIII", "MSI Z690 MEG", "MSI Z690-A PRO"};
    private static final int[] PRICES = {999, 899, 899, 929, 699, 920};

    @Override
    public void productList() {
        super.names = NAMES;
        super.prices = PRICES;
        System.out.printf("%sСписок материнских плат доступных к покупке:%s%n", Utils.ANSI_YELLOW, Utils.ANSI_RESET);
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
