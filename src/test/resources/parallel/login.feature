Feature: Login Functionality for OpenCart E-commerce Website
#  As as user of the open cart plaform
#  I want to be able to login to my account
#  And aces my account related features

  Background:
    Given I am on the OpenCrat login page

  Scenario:Open cart valid credentials
      Given I Have entered a valid "qatestertest@gmail.com"and "Test@123"
      When I click on the login button
      Then I should be logged in successfully

  Scenario Outline: Open Verify invalid or empty credentials
      Given I Have entered a invalid <username> and <password>
      When I click on the login button
      Then I should  see an error message indicating <error_Message>
      Examples:
        | username          | password        | error_Message                                         |
        | Invalid@email.com | invalidpassword | Warning: No match for E-Mail Address and/or Password. |
        | abcdef          | invalidpassword | Warning: No match for E-Mail Address and/or Password. |
        | valid@email.com | abcfrf | Warning: No match for E-Mail Address and/or Password. |

  Scenario:Open Cart reset password link
    Given I click on ForgottenPassword Link
    Then I should be redirected to the password reset page with title "Forgot Your Password?"