Feature: Restful-booker CRUD operation check
  I should be able to check CRUD operation on the website

  Scenario Outline:Verify CRUD operation on Restful-booker application
    Given I am on home page
    When  I create a new booking providing username "<username>" password "<password>"
    Then  I create a new booking providing "<firstname>" "<lastname>" "<total price>" "<deposit paid>" "<additional needs>" "<checkin>" "<checkout>"
    Then  I verify that the booking is created successfully
    And   I update the user with updatefirstname "<firstname1>" updatelastname "<lastname1>" updatetotal price "<total price1>""<deposit paid>" "<additional needs>" "<checkin>" "<checkout>"
    Then  I verify that the booking with updatefirstname "<firstname1>" is updated successfully
    When  I delete the updated booking
    Then  I verify that the booking is deleted successfully
    Examples:
      |username |password   |firstname|lastname |total price|deposit paid |additional needs |checkin      |checkout   |firstname1|lastname1 |total price1|
      |admin    |password123|Keisha   |Paul     |230.44     |true         |Breakfast        |2018-01-01   |2019-01-01 |Keisha1   |Paul1     |1230.44     |