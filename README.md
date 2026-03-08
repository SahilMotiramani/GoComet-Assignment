# CaseKaro Playwright Automation (Java + Cucumber)

This project automates the process of selecting and adding mobile phone cases on the CaseKaro website using Playwright with Java and Cucumber BDD.

The automation script performs end-to-end UI testing of the CaseKaro website by searching for a phone model, selecting different case materials, adding them to the cart, and validating the cart contents.

---
## 🎥 Demo Video

Watch the automation in action:

▶️ **Project Demo:**  
https://youtu.be/KgAyqWgBBhs


## Tech Stack

- Java
- Playwright (Java)
- Cucumber BDD
- JUnit
- Maven
- IntelliJ IDEA

---

## Project Structure

```
casekaro-playwright
│
├── pom.xml
│
├── src
│   │
│   ├── main
│   │   └── java
│   │       └── org.example
│   │           ├── CaseKaroTest.java
│   │           └── Main.java
│   │
│   └── test
│       ├── java
│       │   └── org.example
│       │       ├── CaseSteps.java
│       │       └── TestRunner.java
│       │
│       └── resources
│           └── casekaro.feature
│
└── README.md
```

---

## Test Scenario

The automation performs the following steps:

1. Open CaseKaro website
2. Navigate to Mobile Covers
3. Search for **iPhone 16 Pro**
4. Select the first available product
5. Add cases with different materials:
   - Hard Case
   - Soft Case
   - Glass Case
6. Open the cart
7. Validate that **3 items are present in the cart**
8. Print product details in the console

---

## Feature File (BDD)

Feature: CaseKaro Mobile Cover Automation

Scenario: Add Hard Soft and Glass cases to cart

Given User opens CaseKaro website  
When User searches iPhone 16 Pro  
And User opens the first product  
And User adds Hard Soft and Glass cases  
Then Cart should contain 3 items  

---

## How to Run the Test

### 1. Clone Repository

git clone https://github.com/SahilMotiramani/GoComet-Assignment

### 2. Open in IntelliJ

Open the project as a **Maven Project**.

### 3. Install Dependencies

Maven will automatically download dependencies.

### 4. Run the Test

Run the Cucumber test using:

TestRunner.java

Right click → **Run TestRunner**

---

## Expected Output

The automation will:

- Open the browser
- Search for iPhone 16 Pro covers
- Add Hard, Soft, and Glass cases
- Validate cart items

Example console output:

Model selected: iPhone 16 Pro  
Hard case added  
Soft case added  
Glass case added  
Items in cart: 3  
Validation Passed: 3 items added  

---

## Key Features

- End-to-end UI automation using Playwright
- BDD implementation using Cucumber
- Modular step definitions
- Automated cart validation
- Maven project structure

---

## Author

**Sahil Motiramani**

GitHub: https://github.com/SahilMotiramani  
LinkedIn: https://www.linkedin.com/in/sahil-motiramani-b116842a8
