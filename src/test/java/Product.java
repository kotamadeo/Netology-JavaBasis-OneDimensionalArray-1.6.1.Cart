import com.gmail.at.kotamadeo.utils.Utils;

class Product {
    protected String[] names;
    protected int[] prices;

    protected void productList() {
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s%-1s%s%20s%40s%s%s%s%n", Utils.ANSI_PURPLE, i + 1, ". название: ", names[i],
                    "цена: ", prices[i], "$/шт.", Utils.ANSI_RESET);
        }
    }

    public String[] getNames() {
        return names;
    }

    public int[] getPrices() {
        return prices;
    }
}
