Project is setup in Page Object model using BDD, Junit framework

Steps to unpack and execute the Automation framework for specific to the Automation Challenge


1. Clone the project in local repo
2. Load the DDG project in IDE(e.g. Eclipse)
3. Run the Clean and Build
4. Modify the tag e.g. @AC1, @AC2 in ddTCRun file under src/java/stepdefinition folder
5. Execute the ddTCRun java file the results is displayed in the IDE(eclipse console)

note: please modify the runner class file if want to execute only one scenario by refering the @tagName as mention in below example

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",tags = {"@AC1"},
format = { "pretty", "html:target/cucumber-html-report", "pretty:target/cucumber-report.json" })
