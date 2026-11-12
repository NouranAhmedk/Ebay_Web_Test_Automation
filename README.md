# eBay Web Test Automation

Selenium and TestNG framework for the eBay search scenario: open the home page, search for an item, log the results count, and apply the Transmission filter.

## Architecture

The test does not talk to the browser directly. Each layer has one job.

| Layer | Location | Responsibility |
| --- | --- | --- |
| Test | `src/test/java/tests` | Calls page actions in scenario order and validates soft assertions at the end |
| Test base | `src/test/java/test_bases` | Starts and closes the browser, and loads test data |
| Page objects | `src/main/java/web_pages` | Locators in `*_Locators`, actions and checks in `*_Actions` |
| Browser utilities | `src/main/java/utilities` | Clicks, typing, waits, JavaScript, assertions, and logging |
| Driver | `src/main/java/drivers_and_browsers_setup` | Creates the WebDriver and stores it per thread |
| Test data | `src/test/resources` | URL, browser, and search text. Nothing scenario-specific is hardcoded in the test |
| Listener | `src/test/java/listeners` | Screenshots and the Allure failure attachment. Registered in the regression suite |
| Suite | `TestSuites/Categories/RegressionSuite.xml` | Runs every test in the `Regression` group |

`Home_Actions` covers the eBay home page. `Car_Actions` covers the search results page. Both extend their locator class, so a test calls an action method and never a locator.

Assertions are soft. `softAssert_Validate_All_SoftAssertions()` is the last line of the test, and each soft check has a matching hard check in `Common_Assertions`.

## Prerequisites

- JDK 21
- Maven
- Google Chrome
- [Allure Commandline](https://allurereport.org/docs/install/) 2.32 or newer, only for generating the report

## Test data

| File | Values |
| --- | --- |
| `src/test/resources/Config/Properties/Environment_Data.properties` | `ebay_url`, `browser_Name` |
| `src/test/resources/Files_To_Read_From/Properties/Home_Module_Data.properties` | `search_Item` |

`Load_Properties` reads these files. `Ebay_TestBase` passes the values into the test.

## Run the regression suite

From the project root:

```bash
mvn test
```

The `regression` profile is active by default and runs `TestSuites/Categories/RegressionSuite.xml`. The same command with the profile named explicitly is:

```bash
mvn test -Pregression
```

Logs are written to the console and to `logs/execution.log`. The search-results count is an INFO line from `log_Search_Results_Count`. Screenshots are written under `Screenshots/`.

## Generate the Allure report

The test run writes raw results to `allure-results`. Generate the HTML report after `mvn test` finishes:

```bash
allure generate allure-results --clean -o allure-report
allure open allure-report
```

To build the report and open it in one step:

```bash
allure serve allure-results
```

To write a single HTML file instead of a report folder:

```bash
allure generate allure-results --clean --single-file -o allure-report
```

Open `allure-report/index.html`. The results directory is set in `src/test/resources/allure.properties`.
