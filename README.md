# 🚆 RedBus Train Search Automation Framework (Java + Selenium + TestNG)

This project is an **end-to-end Selenium automation framework** built in **Java** to test the **RedBus Train Search module**. It follows **industry-standard automation practices** such as **Page Object Model (POM)**, **data-driven testing**, and **configurable browser execution**.

The framework is designed to be **scalable, maintainable, and interview-ready**, showcasing real-world automation skills.

---

## 📌 Project Objective

To automate and validate the **RedBus Train booking search flow**, ensuring:

* ✔ Correct train search results
* ✔ Accurate filtering (e.g., Sleeper, AC classes)
* ✔ Stable behavior after UI refresh and DOM updates
* ✔ Reliable validations using assertions

---

## 🛠️ Tech Stack

| Category        | Tools                   |
| --------------- | ----------------------- |
| Language        | Java 17                 |
| Automation      | Selenium WebDriver      |
| Test Framework  | TestNG                  |
| Design Pattern  | Page Object Model (POM) |
| Build Tool      | Maven                   |
| Test Data       | JSON                    |
| Browser Support | Chrome, Edge, Firefox   |

---

## 🌐 Supported Browsers

The test framework supports execution on:

* Chrome
* Edge
* Firefox

Browser can be selected using **GlobalData.properties**:

```
browser=Chrome
```

---

## 📸 Reporting & Failure Handling

* 📊 **Extent HTML Reports integrated with TestNG**
* 📷 **Automatic screenshot capture on test failure**
* 📄 Test execution status logged in reports
* 🧠 Synchronization handled using **explicit waits** to avoid flaky tests

---

## 🧪 Test Scenarios Automated

### 1️⃣ JSON-Driven Train Search

Reads train search data from `trainData.json`:

* Loads source station from JSON
* Loads destination station from JSON
* Loads journey month and date from JSON
* Handles auto-suggestions and selects valid stations dynamically

---

### 2️⃣ Free Cancellation Handling

Uses JSON-driven values to:

* Apply free cancellation toggle (Yes / No)
* Validate correct application of the filter
* Ensure search flow adapts based on cancellation option

---

### 3️⃣ Search Results & Journey Class Validation

* Applies journey class filters (SL, 2A, 3A, CC, etc.)
* Ensures results refresh correctly after filter application
* Collects displayed journey classes dynamically
* Validates filtered results match expected class

---

### 4️⃣ Calendar & Date Selection

* Handles dynamic date picker
* Navigates across months when required
* Selects JSON-driven journey date reliably

---

### 5️⃣ Error State Validation

* Detects application-level error messages such as:

  * "Something went wrong"
* Fails tests gracefully with meaningful assertions
* Prevents misleading Selenium element failures

---

### 6️⃣ Framework Structure (POM + TestNG)

* Page Object Model used for clean separation of concerns
* `BaseTest` handles browser setup and teardown
* Reusable utilities implemented in `AbstractComponents` for:

  * explicit waits
  * synchronization
  * element presence validation
* DataProvider-driven execution using JSON test data

---

## ▶️ How to Run the Tests

Run using IDE:

* Execute `E2E_Test.java`

OR

* Run the suite using `testng.xml`

Browser configuration can be updated in `GlobalData.properties`.

---

## 🌟 Project Highlights

* JSON-driven source, destination, date, and journey class selection
* Clean and maintainable Page Object Model structure
* Custom and explicit waits for stable execution
* Auto-suggestion handling for dynamic UI elements
* Graceful error handling when application fails
* Scalable framework ready for extension

Suggestions and improvements are always welcome.

---

## 💡 Key Automation Concepts Used

* Explicit waits using `ExpectedConditions`
* Fresh element fetching after DOM refresh
* Clear separation of test logic and page logic
* Reusable methods and utility classes
* Configuration-driven execution

---

## 👩‍💻 Author

**Dhwani**
Automation / QA Engineer
🔗 GitHub: [https://github.com/Dhwanidp](https://github.com/Dhwanidp)

---

## ⭐ Final Note

This project reflects **hands-on automation experience** and understanding of **real-world testing challenges** such as synchronization, dynamic elements, and maintainable framework design.

If you find this project helpful, feel free to ⭐ the repository!
