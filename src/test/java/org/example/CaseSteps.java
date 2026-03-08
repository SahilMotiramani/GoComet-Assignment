package org.example;

import com.microsoft.playwright.*;
import io.cucumber.java.en.*;

public class CaseSteps {

    Playwright playwright;
    Browser browser;
    Page page;

    @Given("User opens CaseKaro website")
    public void openWebsite() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        page = browser.newPage();
        page.navigate("https://casekaro.com");
    }

    @When("User searches iPhone 16 Pro")
    public void searchModel() {

        page.locator("#HeaderMenu-mobile-covers").click();
        page.fill("#modelSearch", "iPhone 16 Pro");
        page.locator("#searchResults > a:nth-child(1)").click();
    }

    @And("User opens the first product")
    public void openProduct() {

        page.locator("#CardLink-template--17532658516086__product-grid-7644699951222").first().click();
    }

    @And("User adds Hard Soft and Glass cases")
    public void addCases() {

        String addBtn = "#ProductSubmitButton-template--17532659400822__main";
        String closeDrawer = "#CartDrawer > div.drawer__inner.gradient.color-scheme-1 > div.drawer__header > button";

        page.locator(addBtn).click();
        page.locator(closeDrawer).click();

        page.locator("#variant-selects-template--17532659400822__main > fieldset > label:nth-child(11)").click();
        page.locator(addBtn).click();
        page.locator(closeDrawer).click();

        page.locator("#variant-selects-template--17532659400822__main > fieldset > label:nth-child(9)").click();
        page.locator(addBtn).click();
        page.locator(closeDrawer).click();
    }

    @Then("Cart should contain 3 items")
    public void validateCart() {

        page.locator("#cart-icon-bubble").click();

        int items = page.locator(".cart-item").count();

        System.out.println("Items in cart: " + items);

        for (int i = 0; i < items; i++) {

            String product = page.locator(".cart-item__name").nth(i).textContent();

            System.out.println("Product: " + product);
            System.out.println("Link: " + page.url());
            System.out.println("----------------------");
        }

        browser.close();
    }
}