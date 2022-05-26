package com.gmail.at.kotamadeo.cart;

import com.gmail.at.kotamadeo.product.CPU;
import com.gmail.at.kotamadeo.product.GraphicCards;
import com.gmail.at.kotamadeo.product.MotherBoards;
import com.gmail.at.kotamadeo.utils.Utils;

public class Cart {
    private final MotherBoards motherBoards = new MotherBoards();
    private final CPU cpu = new CPU();
    private final GraphicCards graphicCards = new GraphicCards();
    private int totalReceipt;

    public void userCart(String[] names, int[] prices, int[] productCart) {
        System.out.printf("%18s%s%45s%20s%60s%s%n", Utils.ANSI_YELLOW, "название", "количество в корзине",
                "цена $/шт.", "текущая стоимость к оплате $", Utils.ANSI_RESET);
        var counter = 0;
        var currentReceipt = 0;
        for (var i = 0; i < names.length; i++) {
            if (productCart[i] > 0) {
                counter++;
                currentReceipt = productCart[i] * prices[i];
                System.out.printf("%s%s. %s                  %s                %s                             %s%s%n",
                        Utils.ANSI_CYAN, counter, names[i], productCart[i], prices[i], currentReceipt,
                        Utils.ANSI_RESET);
            }
        }
        totalReceipt += currentReceipt;
    }

    public void totalCart(int[] cartGC, int[] cartCPU, int[] cartMB) {
        System.out.printf("%45s%s%s%n", Utils.ANSI_BLUE, "Ваш список покупок!", Utils.ANSI_RESET);
        System.out.printf("%18s%s%45s%20s%45s%s%n", Utils.ANSI_YELLOW, "название", "количество в корзине",
                "цена $/шт.", "текущая стоимость $", Utils.ANSI_RESET);
        var counter = 0;
        for (var i = 0; i < graphicCards.getNames().length; i++) {
            if (cartGC[i] > 0) {
                var receiptGC = cartGC[i] * graphicCards.getPrices()[i];
                counter++;
                System.out.printf("%15s%s%s%s", Utils.ANSI_CYAN, counter, ".", Utils.ANSI_RESET);
                System.out.printf("%s%s%s", Utils.ANSI_CYAN, graphicCards.getNames()[i], Utils.ANSI_RESET);
                System.out.printf("%25s%s%s", Utils.ANSI_CYAN, cartGC[i], Utils.ANSI_RESET);
                System.out.printf("%15s%s%s", Utils.ANSI_CYAN, graphicCards.getPrices()[i], Utils.ANSI_RESET);
                System.out.printf("%25s%s%s%n", Utils.ANSI_CYAN, receiptGC, Utils.ANSI_RESET);
            }
        }
        for (var i = 0; i < cpu.getNames().length; i++) {
            if (cartCPU[i] > 0) {
                var receiptCPU = cartCPU[i] * cpu.getPrices()[i];
                counter++;
                System.out.printf("%15s%s%s%s", Utils.ANSI_CYAN, counter, ".", Utils.ANSI_RESET);
                System.out.printf("%s%s%s", Utils.ANSI_CYAN, cpu.getNames()[i], Utils.ANSI_RESET);
                System.out.printf("%25s%s%s", Utils.ANSI_CYAN, cartCPU[i], Utils.ANSI_RESET);
                System.out.printf("%15s%s%s", Utils.ANSI_CYAN, cpu.getPrices()[i], Utils.ANSI_RESET);
                System.out.printf("%25s%s%s%n", Utils.ANSI_CYAN, receiptCPU, Utils.ANSI_RESET);
            }
        }
        for (var i = 0; i < motherBoards.getNames().length; i++) {
            if (cartMB[i] > 0) {
                var receiptMB = cartMB[i] * motherBoards.getPrices()[i];
                counter++;
                System.out.printf("%15s%s%s%s", Utils.ANSI_CYAN, counter, ".", Utils.ANSI_RESET);
                System.out.printf("%s%s%s", Utils.ANSI_CYAN, motherBoards.getNames()[i], Utils.ANSI_RESET);
                System.out.printf("%25s%s%s", Utils.ANSI_CYAN, cartMB[i], Utils.ANSI_RESET);
                System.out.printf("%15s%s%s", Utils.ANSI_CYAN, motherBoards.getPrices()[i], Utils.ANSI_RESET);
                System.out.printf("%25s%s%s%n", Utils.ANSI_CYAN, receiptMB, Utils.ANSI_RESET);
            }
        }
        System.out.printf("%55s", " ");
        System.out.printf("%sОбщая сумма к оплате: %s$%s%n", Utils.ANSI_GREEN, totalReceipt, Utils.ANSI_RESET);
    }
}
