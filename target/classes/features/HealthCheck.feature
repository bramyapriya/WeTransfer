Feature: HealthCheck
  This feature helps customer to perform the health check of the application and also inspects the application url status

  @regression @smoke
  Scenario: Verify whether aplication home page is displayed properly or not
    When Customer opens the Thuisbezorgd application url
    Then application home page should be displayed successfully

  @regression @smoke
  Scenario: Verify is there any broken links in the application or not
    When Customer tries to check each and every thuizbezorgd urls to check their status
    Then Customer should get the information related to active and broken url status
