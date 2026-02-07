# 🚆 RedBus Train Search Automation Framework (Java + Selenium + TestNG)

This project is an **end-to-end Selenium automation framework** built in **Java** to automate and validate the **RedBus Train Search module**.  
It follows **industry-standard automation practices** such as **Page Object Model (POM)**, **Object Library (OL)**, **JSON-driven testing**, **TestNG grouping**, and **suite-based execution**.

The framework is designed to be **scalable, maintainable, and interview-ready**, reflecting real-world automation framework design.

---

## 📌 Project Objective

To automate and validate the **RedBus Train booking search flow**, ensuring:

* ✔ Correct train search results  
* ✔ Accurate filtering (Sleeper, AC classes, etc.)  
* ✔ Stable behavior after UI refresh and DOM updates  
* ✔ Reliable validations using assertions  
* ✔ Controlled execution using TestNG groups and suites  

---

## 🛠️ Tech Stack

| Category        | Tools                          |
| --------------- | ------------------------------ |
| Language        | Java 17                        |
| Automation      | Selenium WebDriver             |
| Test Framework  | TestNG                         |
| Design Pattern  | Page Object Model (POM)        |
| Locator Design  | Object Library (OL)            |
| Build Tool      | Maven                          |
| Test Data       | JSON                           |
| Reporting       | Extent Reports (HTML)          |
| Browser Support | Chrome, Edge, Firefox          |

---

## 🌐 Supported Browsers

The framework supports execution on:

* Chrome  
* Edge  
* Firefox

browser=Chrome


---

## ⚙️ Test Execution Strategy (Suites + Groups)

The framework uses **TestNG Groups** combined with **multiple TestNG XML suites** for flexible execution.

### 🔹 TestNG Groups Used

* `smoke` – Critical sanity scenarios  
* `regression` – Full regression flow  
* `filter` – Filter-specific validations  
* `error` – Error and negative flow validations  

Groups are assigned at test method level and can be included or excluded via suite XML files.

---

## 📄 TestNG Suite Files

The following TestNG XML files control grouped execution:

* `testng.xml`  
* `testng-smoke.xml`  
* `testng-regression-core.xml`  
* `testng-regression-filter.xml`  
* `testng-regression-error.xml`  

This setup enables running **specific test categories** without changing test code.

---

## 📚 Object Library (OL)

An **Object Library (OL)** is implemented to centralize element locators:

* All UI locators are maintained separately  
* Eliminates locator duplication  
* Simplifies updates when UI changes  
* Improves readability and scalability  

---

## 📸 Reporting & Failure Handling

* 📊 **Extent HTML Reports integrated with TestNG**  
* 📷 **Automatic screenshot capture on test failure**  
* 📄 Execution status logged in reports  
* 🧠 Explicit waits used for stable synchronization  

---

## 🧪 Test Scenarios Automated

### 1️⃣ JSON-Driven Train Search

Reads data from `trainData.json`:

* Source station  
* Destination station  
* Journey month and date  
* Auto-suggestion handling  

---

### 2️⃣ Free Cancellation Handling

* Applies free cancellation toggle (Yes / No)  
* Validates filter behavior  
* Ensures correct search flow  

---

### 3️⃣ Search Results & Journey Class Validation

* Applies journey class filters (SL, 2A, 3A, CC, etc.)  
* Ensures results refresh correctly  
* Collects journey classes dynamically  
* Validates results against expected values  

---

### 4️⃣ Calendar & Date Selection

* Handles dynamic date picker  
* Navigates across months  
* Selects JSON-driven journey date  

---

### 5️⃣ Error State Validation

* Detects application-level errors such as:  
  * "Something went wrong"  
* Fails tests gracefully using assertions  
* Prevents false Selenium failures  

---

### 6️⃣ Framework Structure (POM + OL + TestNG Groups)

* Page Object Model for clean separation of concerns  
* Object Library for centralized locator management  
* TestNG Groups for logical test categorization  
* `BaseTest` for browser setup and teardown  
* `AbstractComponents` for reusable utilities:  
  * explicit waits  
  * synchronization  
  * element validation  
* DataProvider-driven execution using JSON  

---

## ▶️ How to Run the Tests

Using IDE:

* Run any TestNG XML file:
  * `testng-smoke.xml`
  * `testng-regression-core.xml`
  * `testng-regression-filter.xml`
  * `testng-regression-error.xml`

Using Maven:

mvn test


Execution behavior is controlled by TestNG suite files and group definitions.

---

## 🌟 Project Highlights

* TestNG group-based test categorization  
* Modular suite-based execution  
* Object Library for maintainable locators  
* JSON-driven test data handling  
* Stable execution using explicit waits  
* Dynamic UI and auto-suggestion handling  
* Graceful error and negative flow validation  
* Scalable automation framework design  

---

## 💡 Key Automation Concepts Used

* TestNG Groups and Suite management  
* Explicit waits using `ExpectedConditions`  
* Fresh element handling after DOM updates  
* Separation of test logic, page logic, and locators  
* Reusable base and utility components  

---

## 👩‍💻 Author

**Dhwani**  
Automation / QA Engineer  
🔗 GitHub: https://github.com/Dhwanidp  

---

## ⭐ Final Note

This project demonstrates **hands-on automation framework expertise** with real-world handling of **grouped execution**, **dynamic applications**, and **maintainable design patterns**.

If you find this project useful, feel free to ⭐ the repository!


Browser selection is controlled via `GlobalData.properties`:

