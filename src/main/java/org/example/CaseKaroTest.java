package org.example;

import com.microsoft.playwright.*;

public class CaseKaroTest {

    static void addCase(Page page, String materialSelector, String addToCartBtn, String closeDrawerBtn, String materialName) {

        page.locator(materialSelector).click();
        page.locator(addToCartBtn).click();

        System.out.println(materialName + " case added");

        page.waitForTimeout(2000);

        // Close cart drawer
        page.locator(closeDrawerBtn).click();
        page.waitForTimeout(2000);
    }

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();

            // STEP 1 - Open website
            page.navigate("https://casekaro.com");

            // STEP 2 - Click Mobile Covers
            page.locator("#HeaderMenu-mobile-covers").click();

            // STEP 3 - Search model
            page.fill("#modelSearch", "iPhone 16 Pro");
            page.waitForTimeout(2000);

            // STEP 4 - Select model
            page.locator("#searchResults > a:nth-child(1)").click();

            System.out.println("Model selected: iPhone 16 Pro");

            page.waitForTimeout(3000);

            // STEP 5 - Choose options
            page.locator("#CardLink-template--19067879227510__product-grid-7644699951222").first().click();


            page.waitForTimeout(3000);

            String addToCartBtn = "#ProductSubmitButton-template--19067880243318__main";
            String closeDrawerBtn = "#CartDrawer > div.drawer__inner.gradient.color-scheme-1 > div.drawer__header > button";

            // -------- HARD CASE --------
            page.locator(addToCartBtn).click();
            System.out.println("Hard case added");

            page.waitForTimeout(2000);
            page.locator(closeDrawerBtn).click();
            page.waitForTimeout(2000);

            // -------- SOFT CASE --------
            addCase(
                    page,
                    "#variant-selects-template--19067880243318__main > fieldset > label:nth-child(11)",
                    addToCartBtn,
                    closeDrawerBtn,
                    "Soft"
            );

            // -------- GLASS CASE --------
            addCase(
                    page,
                    "#variant-selects-template--19067880243318__main > fieldset > label:nth-child(9)",
                    addToCartBtn,
                    closeDrawerBtn,
                    "Glass"
            );

            // STEP 6 - Open cart
            page.locator("#cart-icon-bubble").click();

            page.waitForTimeout(3000);

            // STEP 7 - Validate cart items
            int items = page.locator(".cart-item").count();

            System.out.println("Items in cart: " + items);

            if (items == 3) {
                System.out.println("Validation Passed: 3 items added");
            } else {
                System.out.println("Validation Failed");
            }
            // STEP 8 - Print product details
            for (int i = 0; i < items; i++) {

                String product = page.locator(".cart-item__name").nth(i).textContent();
                String price = page.locator(".cart-item__price-wrapper span").nth(i).textContent().trim();
                System.out.println("Product: " + product);
                System.out.println("Price: " +price);
                System.out.println("Link: " + page.url());
                System.out.println("------------------------------");
            }

            browser.close();
            browser.close();

        }
    }
}