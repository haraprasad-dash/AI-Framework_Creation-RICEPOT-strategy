# Salesforce Automation Framework

An enterprise-level Selenium WebDriver automation framework for testing Salesforce CRM applications. Built with Java, Maven, TestNG, and follows the Page Object Model (POM) design pattern with PageFactory.

## 🚀 Features

- **Page Object Model (POM)** with PageFactory implementation
- **Cross-browser support** (Chrome, Firefox, Edge)
- **WebDriverManager** for automatic driver management
- **TestNG** for test execution and reporting
- **Explicit Waits** for robust element synchronization
- **XPath-only locators** (no CSS selectors)
- **Exception handling** with structured try-catch blocks
- **Maven** for dependency management and build automation

## 📋 Prerequisites

- Java 8 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser installed

## 🛠️ Tech Stack

| Technology | Version |
|------------|---------|
| Selenium WebDriver | 3.141.59 |
| TestNG | 7.5.1 |
| WebDriverManager | 5.9.2 |
| Maven | 3.6+ |
| Java | 1.8+ |

## 📁 Project Structure

```
salesforce-automation-framework/
├── pom.xml
├── README.md
├── RICE_POT_pe.md
└── src/
    ├── main/java/com/salesforce/
    │   ├── pages/
    │   │   └── LoginPage.java          # Page Object for Login page
    │   └── utils/
    ├── test/java/com/salesforce/tests/
    │   ├── BaseTest.java               # Base class with setup/teardown
    │   └── LoginTest.java              # Test cases
    └── test/resources/
        └── testng.xml                  # Test suite configuration
```

## 🎯 Test Coverage

### Login Page Tests

| Test Case | Description |
|-----------|-------------|
| `testValidLogin` | Valid login with correct credentials |
| `testInvalidLoginBlankUsername` | Invalid login with blank username |
| `testInvalidLoginBlankPassword` | Invalid login with blank password |
| `testInvalidLoginBlankCredentials` | Invalid login with blank username and password |
| `testInvalidLoginWrongPassword` | Invalid login with incorrect password |
| `testInvalidLoginNonExistentUser` | Invalid login with non-existent user |
| `testInvalidLoginInvalidEmailFormat` | Invalid login with invalid email format |
| `testInvalidLoginSQLInjection` | Security test with SQL injection attempt |
| `testRememberMeCheckboxDisplayed` | Verify Remember Me checkbox is displayed |
| `testLoginWithRememberMe` | Verify login with Remember Me selected |

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/haraprasad-dash/AI-Framework_Creation-RICEPOT-strategy.git
cd AI-Framework_Creation-RICEPOT-strategy
```

### 2. Build the Project

```bash
mvn clean compile
```

### 3. Run Tests

Run all tests:
```bash
mvn test
```

Run with specific browser (default: chrome):
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
```

### 4. View Test Reports

After test execution, reports are available at:
```
target/surefire-reports/index.html
```

Open this file in a browser to view detailed TestNG reports.

## ⚙️ Configuration

### TestNG Suite Configuration

Modify `src/test/resources/testng.xml` to change browser or test parameters:

```xml
<suite name="SalesforceTestSuite">
    <parameter name="browser" value="chrome"/>
    <test name="LoginTests">
        <classes>
            <class name="com.salesforce.tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

### Browser Support

The framework supports the following browsers:
- **Chrome** (default)
- **Firefox**
- **Edge**

Browser drivers are automatically managed by WebDriverManager.

## 📝 Key Classes

### LoginPage.java
Page Object for Salesforce login page with methods:
- `enterUsername(String username)`
- `enterPassword(String password)`
- `clickLoginButton()`
- `performLogin(String username, String password)`
- `clickRememberMe()`
- `getErrorMessage()`
- `isErrorMessageDisplayed()`
- `isLoginPageDisplayed()`

### BaseTest.java
Base test class providing:
- WebDriver initialization
- Browser configuration
- Setup and teardown methods (`@BeforeMethod`, `@AfterMethod`)
- Implicit and page load timeouts

### LoginTest.java
Test class with 10 test cases covering:
- Positive scenarios (valid login)
- Negative scenarios (invalid credentials)
- Edge cases (blank fields, SQL injection)
- UI verification (Remember Me checkbox)

## 🔒 Security Testing

The framework includes security test cases:
- **SQL Injection** attempts on login fields
- **Invalid email format** validation
- **Non-existent user** handling

## 📊 Test Results

Sample test execution results:

```
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
Time elapsed: 64.901 s
BUILD SUCCESS
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Haraprasad Dash**
- GitHub: [@haraprasad-dash](https://github.com/haraprasad-dash)

## 🙏 Acknowledgments

- [Selenium WebDriver](https://www.selenium.dev/)
- [TestNG](https://testng.org/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
- [Maven](https://maven.apache.org/)

---

**Note:** This framework was built following the RICE_POT strategy for enterprise-level automation testing standards.
