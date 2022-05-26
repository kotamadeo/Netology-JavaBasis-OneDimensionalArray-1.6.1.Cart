package com.gmail.at.kotamadeo.product;

import com.gmail.at.kotamadeo.utils.Utils;

public class GraphicCards extends Product {
    private static final String[] NAMES = {"RTX 3090", "RTX 3080", "RTX 3070", "RTX 3060", "RTX 3060TI", "RX 6900"};
    private static final int[] PRICES = {1499, 699, 499, 329, 399, 999};

  @Override
    public void productList() {
        super.names = NAMES;
        super.prices = PRICES;
        System.out.printf("%sСписок видеокарт доступных к покупке:%s%n", Utils.ANSI_YELLOW, Utils.ANSI_RESET);
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
