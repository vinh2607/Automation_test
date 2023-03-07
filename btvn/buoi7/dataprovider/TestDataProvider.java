package nganttt.btvn.buoi7.dataprovider;

import nganttt.btvn.buoi7.model.LoginModel;
import nganttt.btvn.buoi7.model.ProductModel;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "LoginFunction")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {LoginModel.builder().username("standard_user").password("secret_sauce").build()},
                {LoginModel.builder().username("locked_out_user").password("secret_sauce").build()},
                {LoginModel.builder().username("problem_user").password("secret_sauce").build()},
                {LoginModel.builder().username("performance_glitch_user").password("secret_sauce").build()}
        };
    }

    @DataProvider(name = "AddItemToCartFunction")
    public Object[][] itemDataProvider() {
        return new Object[][]{
                {ProductModel.builder().name("Sauce Labs Bolt T-Shirt").price("$15.99").build()},
                {ProductModel.builder().name("Sauce Labs Onesie").price("$7.99").build()},
        };
    }
}
