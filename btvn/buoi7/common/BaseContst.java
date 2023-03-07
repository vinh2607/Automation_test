package nganttt.btvn.buoi7.common;

public class BaseContst {
    public static String URL = "https://www.saucedemo.com/";
    public static String DYNAMIC_INPUT_TEXT_FORM = "//input[@name='%s']";
    public static String DYNAMIC_INPUT_BUTTON_FORM = "//input[@name='%s']";
    public static String DYNAMIC_BUTTON_FORM = "//button[@name='%s']";
    public static String DYNAMIC_TITLE_FORM = "//span[text()='%s']";
    public static String cartContainer = "//div[@class='shopping_cart_container']";
    public static String itemNameXPath = "//div[@class='inventory_item_name']";
    public static String itemPriceXPath = "//div[@class='inventory_item_price']";
    public static String DYNAMIC_NAME_FORM = "//div[text()='%']";
    public static String DYNAMIC_PRICE_FORM = "//div[text()='%s']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    public static String DYNAMIC_BUTTON_ACTION_FORM = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";
    public static String DYNAMIC_OVERVIEWINFO_FORM = "//div[@class='%s']";

}
