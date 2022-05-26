package com.gmail.at.kotamadeo.program;

import com.gmail.at.kotamadeo.cart.Cart;
import com.gmail.at.kotamadeo.product.CPU;
import com.gmail.at.kotamadeo.product.GraphicCards;
import com.gmail.at.kotamadeo.product.MotherBoards;
import com.gmail.at.kotamadeo.utils.Utils;

import java.util.Scanner;

public class Program {
    private final Scanner scanner = new Scanner(System.in);
    private final Cart cart = new Cart();
    private final CPU cpu = new CPU();
    private final int[] productCartCPU = new int[cpu.getNames().length];
    private final MotherBoards motherBoards = new MotherBoards();
    private final int[] productCartMotherBoards = new int[motherBoards.getNames().length];
    private final GraphicCards graphicCards = new GraphicCards();
    private final int[] productCartGraphicCards = new int[graphicCards.getNames().length];

    public void start() {
        String input;
        String[] allInput;
        while (true) {
            try {
                printMenu();
                input = scanner.nextLine();
                if ("выход".equalsIgnoreCase(input) || "0".equals(input)) {
                    cart.totalCart(productCartGraphicCards, productCartCPU, productCartMotherBoards);
                    scanner.close();
                    break;
                } else {
                    var operationNumber = Integer.parseInt(input);
                    switch (operationNumber) {
                        case 1:
                            graphicCards.productList();
                            System.out.println(Utils.ANSI_BLUE + "Введите номер товара и количество через пробел:" +
                                    Utils.ANSI_RESET);
                            allInput = scanner.nextLine().split(" ");
                            var inputGCNumber = Integer.parseInt(allInput[0]) - 1;
                            var inputGCAmount = Integer.parseInt(allInput[1]);
                            productCartGraphicCards[inputGCNumber] += inputGCAmount;
                            cart.userCart(graphicCards.getNames(), graphicCards.getPrices(),
                                    productCartGraphicCards);
                            break;
                        case 2:
                            cpu.productList();
                            System.out.println(Utils.ANSI_BLUE + "Введите номер товара и количество через пробел:" +
                                    Utils.ANSI_RESET);
                            allInput = scanner.nextLine().split(" ");
                            var inputCPUNumber = Integer.parseInt(allInput[0]) - 1;
                            var inputCPUAmount = Integer.parseInt(allInput[1]);
                            productCartCPU[inputCPUNumber] += inputCPUAmount;
                            cart.userCart(cpu.getNames(), cpu.getPrices(), productCartCPU);
                            break;
                        case 3:
                            motherBoards.productList();
                            System.out.println(Utils.ANSI_BLUE + "Введите номер товара и количество через пробел:" +
                                    Utils.ANSI_RESET);
                            allInput = scanner.nextLine().split(" ");
                            var inputMBNumber = Integer.parseInt(allInput[0]) - 1;
                            var inputMBAmount = Integer.parseInt(allInput[1]);
                            productCartMotherBoards[inputMBNumber] += inputMBAmount;
                            cart.userCart(motherBoards.getNames(), motherBoards.getPrices(),
                                    productCartMotherBoards);
                            break;
                        case 4:
                            cart.totalCart(productCartGraphicCards, productCartCPU, productCartMotherBoards);
                            break;
                        default:
                            System.out.println(Utils.ANSI_RED + "Вы ввели неверный номер операции!" + Utils.ANSI_RESET);
                    }
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println(Utils.ANSI_RED + "Ошибка ввода!" + Utils.ANSI_RESET);
            }
        }
    }

    private void printMenu() {
        System.out.println(Utils.ANSI_YELLOW + "Добро пожаловать в онлайн-магазин!" + Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_PURPLE + "Возможные разделы магазина:" + Utils.ANSI_RESET);
        System.out.println("0 или выход: чтобы выйти из программы.");
        System.out.println("1: видеокарты.");
        System.out.println("2: процессоры.");
        System.out.println("3: материнские платы.");
        System.out.println("4: вывести общую стоимость покупок.");
        System.out.print(">>>>>>>");
    }
}
