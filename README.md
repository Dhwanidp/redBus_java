redBus Automation Framework (Selenium + Java + TestNG)

This project automates the redBus Train Search flow using
Java, Selenium WebDriver, TestNG, the Page Object Model (POM), and JSON-based test data.

The framework covers the complete search process:
Landing Page → Trains Module → Source & Destination → Date Selection → Free Cancellation → Search Results → Journey Class Validation,
with data-driven inputs and validations at each step.

--------------------------------------------------

Tech Stack

- Java (JDK 17)
- Selenium WebDriver
- TestNG
- Page Object Model (POM)
- JSON-based Test Data
- Apache Commons IO
- Jackson Databind (JSON to HashMap)
- Custom Wait Utilities

--------------------------------------------------

Supported Browsers

The test framework supports running tests on the following browsers:
- Chrome
- Edge
- Firefox
Choose the browser using GlobalData.properties:
browser=Chrome
--------------------------------------------------

Test Scenarios Automated

1. JSON-Driven Train Search

Reads train search data from trainData.json:

- Loads source station from JSON
- Loads destination station from JSON
- Loads journey month and date from JSON
- Handles auto-suggestions and selects valid stations dynamically

--------------------------------------------------

2. Free Cancellation Handling

Uses values from JSON to:

- Apply free cancellation toggle (Yes / No)
- Validate correct application of the filter
- Ensure search flow adapts based on cancellation option

--------------------------------------------------

3. Search Results & Journey Class Validation

- Applies journey class filter (SL, 2A, 3A, CC, etc.)
- Ensures results refresh correctly
- Collects displayed journey classes
- Validates that filtered results match expected class

--------------------------------------------------

4. Calendar & Date Selection

- Handles dynamic date picker
- Navigates across months when required
- Selects JSON-driven date reliably

--------------------------------------------------

5. Error State Validation

- Detects application-level error messages such as:
  "Something went wrong"
- Fails tests gracefully with meaningful assertions
- Prevents misleading Selenium element failures

--------------------------------------------------

6. Framework Structure (POM + TestNG)

- Uses Page Object Model for clean separation
- BaseTest for browser setup and teardown
- Reusable utilities in AbstractComponents for:
  - waits
  - synchronization
  - element presence checks
- DataProvider-driven execution using JSON test data

--------------------------------------------------

How to Run the Tests

Run the TestNG test class from the IDE:

- E2E_Test.java

OR

- Run the suite using TestNG XML file (testng.xml)

Browser configuration can be changed in GlobalData.properties.

--------------------------------------------------

Project Highlights

- JSON-driven source, destination, date, and journey class selection
- Clean and maintainable POM structure
- Custom and explicit waits for stable execution
- Auto-suggestion handling for dynamic UI
- Graceful error handling when application fails
- Simple, scalable, and ready to extend

Suggestions and improvements are welcome.
