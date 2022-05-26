# **Задачи № 1 **Покупка товаров**

## **Цель**:

1. Написать программу, планирующую продуктовую корзину. У вас есть список доступных продуктов в одном массиве и соответствующая им цена в другом массиве. Пользователь вводит номер продукта из первого списка и количество продуктов этого вида, которое хочет купить. Программа добавляет указанное количество выбранного продукта в итоговую сумму продуктовой корзины. Действие повторяется до тех пор, пока пользователь не введет команду "end". Только после этого выводится вся корзина выбранных товаров и итоговая сумма.

### *Пример*:

``` Пример 1
0 или выход: чтобы выйти из программы.
1: видеокарты.
2: процессоры.
3: материнские платы.
4: вывести общую стоимость покупок.
>>>>>>> 
1
Список видеокарт доступных к покупке:
1. название:             RTX 3090                              цена: 1499$/шт.
2. название:             RTX 3080                              цена: 699$/шт.
3. название:             RTX 3070                              цена: 499$/шт.
4. название:             RTX 3060                              цена: 329$/шт.
5. название:           RTX 3060TI                              цена: 399$/шт.
6. название:              RX 6900                              цена: 999$/шт.
Введите номер товара и количество через пробел:
2 3
   название       количество в корзине    цена $/шт.         текущая стоимость к оплате $
1. RTX 3080                  3              699                      2097

2
Список процессоров доступных к покупке:
1. название:            I9-12900K                              цена: 799$/шт.
2. название:            I9-11900K                              цена: 599$/шт.
3. название:            I9-10900K                              цена: 499$/шт.
4. название:        Ryzen 9 5900X                              цена: 799$/шт.
5. название:        Ryzen 9 3950X                              цена: 699$/шт.
6. название:        Ryzen 9 5950X                              цена: 600$/шт.
Введите номер товара и количество через пробел:
5 3
     название       количество в корзине    цена $/шт.         текущая стоимость к оплате $
1. Ryzen 9 3950X            3                 699                         2097

3
Список материнских плат доступных к покупке:
1. название:  Gigabyte Z690 AORUS                              цена: 999$/шт.
2. название:     ROG MAXIMUS Z690                              цена: 899$/шт.
3. название:    MSI Z690 Tomahawk                              цена: 899$/шт.
4. название:   Asus ROG HERO XIII                              цена: 929$/шт.
5. название:         MSI Z690 MEG                              цена: 699$/шт.
6. название:       MSI Z690-A PRO                              цена: 920$/шт.
Введите номер товара и количество через пробел:
6 2
         название       количество в корзине    цена $/шт.         текущая стоимость к оплате $
1. MSI Z690-A PRO                  2               920                         1840
 
0
                                   Ваш список покупок!
             название       количество в корзине    цена $/шт.          текущая стоимость $
           1.RTX 3080                    3          699                    2097
      2.Ryzen 9 3950X                    3          699                    2097
     3.MSI Z690-A PRO                    2          920                    1840
                                                                Общая сумма к оплате: 6034$
```

### **Моя реализация**:

1. Реализация осуществлена в парадигме ООП.
2. Создал структуру классов:

* **Program** - отвечающий за запуск программы, путем инициирования метода *start()* (с инициированием внутри себя
  вспомогательного метода *printMenu()*);

#### Класс **Program**:
``` java
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
```

* **Product** - являющийся суперклассом для **GraphicCards**, **MotherBoards** и **CPU**;

#### Класс **Product**:
``` java   
class Product {
    protected String[] names;
    protected int[] prices;

    protected void productList() {
        for (var i = 0; i < names.length; i++) {
            System.out.printf("%s%-1s%s%20s%40s%s%s%s%n", Utils.ANSI_PURPLE, i + 1, ". название: ", names[i], "цена: ",
                    prices[i], "$/шт.", Utils.ANSI_RESET);
        }
    }

    public String[] getNames() {
        return names;
    }

    public int[] getPrices() {
        return prices;
    }
}
```
* **GraphicCards** - описывающий видеокарты и реализующий **Product** посредством переопределения методов;
* **CPU** - описывающий процессоры и реализующий **Product** посредством переопределения методов;
* **MotherBoards** - описывающий материнские платы и реализующий **Product** посредством переопределения методов;
* **Cart** - описывающий продуктовую корзину. Имеет методы *UserCart()* позволяющий итерировать и выводить список покупок и текущую стоимость на экран и *totalCart()* выводящий полный список покупки и итоговую стоимость.

#### Класс **Cart**:
```java
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
```

3. Использовал ```try-catch```, чтобы избежать падение программы в исключения.

#### Метод *main()* в классе **Main**:
``` java
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }
}
```

## *Вывод в консоль*:

* меню:
``` 
Добро пожаловать в онлайн-магазин!
Возможные разделы магазина:
0 или выход: чтобы выйти из программы.
1: видеокарты.
2: процессоры.
3: материнские платы.
4: вывести общую стоимость покупок.
>>>>>>>
```