Feature:Online Shoe Portal As a user should be able to login the application

  Background:
  Given User lunch the browser and navigate to SignIN page

  Scenario:Online Shoe Portal Login With valid credentials
    Given User enter valid credentials username "Admin" and password "Admin"
    And User click Login button
    Then Verify the page title is "Ace Online Shoe Portal"

  Scenario Outline:Online Shoe Portal Login With invalid credentials
    Given User enter valid <username> and <password>
    And User click Login button
    Then Verify error message <ErrorMsg>
    Examples:
      | username | password | ErrorMsg                                      |
      | Admin    |          | Both Username and Password field are required |
      |          | Admin    | Both Username and Password field are required |
      |          |          | Please provide details                        |
