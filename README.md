# EgoCepte-Mobile-Application-Appium-ExtentReport

This project is developed to perform automation tests for the Beymen Mobile Application using a Java and Selenium-based Appium test framework.

<p align="center">
  <img src="https://www.ego.gov.tr/resim/normal/26495.jpg" alt="Project Logo" width="300" />
</p>

## Requirements

- Java Development Kit (JDK) 1.8 or above
- Maven
- IntelliJ IDEA (or your preferred Java IDE)
- Appium
- Android Emulator or Physical Android Device

## Kurulum

1. Download or clone this project from GitHub.

2. Go to the project folder and execute the following command to install the necessary dependencies:
   ```
   mvn clean install
   ```

3. Start the Appium server and prepare the Android Emulator or Physical Device for running application tests.

4. Update the deviceName, platformName, platformVersion, and appPath variables in the ConfigReader.java file according to your device and application information.

5. To run the tests, use the following command:
   ```
   mvn test
   ```

## Test Reports

"Extent Report" was used as reporting as a result of the test run. In this way, we obtained 2 reports, both in html extension and in PDF type. We coded one "fail" scenario to confirm that the report is working correctly. In this scenario, we took a screenshot of the screen where the error occurred and added it to our report. We have reports in the Reports folder.

## Automatic Email Sending

We automatically send your PDF reports created after test runs by e-mail.

## License

This project is open-source and subject to the terms specified in the License File.

## Contact

For any questions or suggestions, please contact us at farslan0699@gmail.com.

## Contribution

If you would like to contribute to this project, you can do so by opening a "Pull Request" to submit your changes. Additionally, you can review existing "Issues" and provide feedback to help improve the project.

---

This detailed README file has been enriched by adding more information about the project's structure, test scenarios, installation, and contribution process. Additionally, information about test reports has been provided, and the contact email for the project has been included. This provides a comprehensive guide for users and contributors to the project.


