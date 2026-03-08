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

        // Click Mobile Covers
        page.locator("#HeaderMenu-mobile-covers").click();

        // Search model
        page.fill("#modelSearch", "iPhone 16 Pro");

        page.waitForTimeout(2000);

        // Select first result
        page.locator("#searchResults > a:nth-child(1)").click();
    }

    @And("User opens the first product")
    public void openProduct() {

        page.waitForTimeout(3000);

        page.locator("#CardLink-template--19067879227510__product-grid-7644699951222").first().click();
    }

    @And("User adds Hard Soft and Glass cases")
    public void addCases() {

        String addBtn = "#ProductSubmitButton-template--19067880243318__main";

        String closeDrawer = "#CartDrawer > div.drawer__inner.gradient.color-scheme-1 > div.drawer__header > button";

        // HARD
        page.locator(addBtn).click();
        page.waitForTimeout(2000);
        page.locator(closeDrawer).click();
        page.waitForTimeout(2000);

        // SOFT
        page.locator("#variant-selects-template--19067880243318__main > fieldset > label:nth-child(11)").click();
        page.locator(addBtn).click();
        page.waitForTimeout(2000);
        page.locator(closeDrawer).click();
        page.waitForTimeout(2000);

        // GLASS
        page.locator("#variant-selects-template--19067880243318__main > fieldset > label:nth-child(9)").click();
        page.locator(addBtn).click();
        page.waitForTimeout(2000);
        page.locator(closeDrawer).click();
    }

    @Then("Cart should contain 3 items")
    public void validateCart() {

        page.locator("#cart-icon-bubble").click();

        page.waitForTimeout(3000);

        int items = page.locator(".cart-item").count();

        System.out.println("Items in cart: " + items);

        if (items == 3) {
            System.out.println("Validation Passed: 3 items added");
        } else {
            System.out.println("Validation Failed");
        }

        for (int i = 0; i < items; i++) {

            String product = page.locator(".cart-item__name").nth(i).textContent();

            String price = page.locator(".cart-item__price-wrapper span")
                    .nth(i)
                    .textContent()
                    .trim();

            System.out.println("Product: " + product);
            System.out.println("Price: " + price);
            System.out.println("Link: " + page.url());

            System.out.println("----------------------");
        }

        browser.close();
    }
}