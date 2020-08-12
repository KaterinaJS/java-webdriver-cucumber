@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@id='header-search-input']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='header-search-input']"
    And I click on element with xpath "//button[@id='header-desktop-search-button']"
    Then I wait for element with xpath "//*[@id='web']" to be present
    Then element with xpath "//*[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//label[@class='search icon tooltip']"
    Then I wait for element with xpath "//*[@id='b_results']" to be present
    Then element with xpath "//*[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    And I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='gsc-control-wrapper-cse']" to be present
    Then element with xpath "//div[@class='gsc-control-wrapper-cse']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for SwissCows
    Given I open url "https://swisscows.com/"
    Then I should see page title as "Swisscows the alternative, data secure search engine."
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    And I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for SearchEncrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//section[contains(@class, 'results')]" to be present
    Then element with xpath "//section[contains(@class, 'results')]" should contain text "cucumber"

  @predefined8
  Scenario: Predefined steps for StartPage
    Given I open url "https://www.startpage.com/"
    Then I should see page title as "Startpage.com - The world's most private search engine"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    And I click on element with xpath "//button[@class='search-form-home__form__button']"
    Then I wait for 3 sec
    Then I wait for element with xpath "//div[@class='layout-web__mainline']" to be present
    Then element with xpath "//div[@class='layout-web__mainline']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    And I click on element with xpath "//button[contains(@class,'button mini-suggest')]"
    Then I wait for element with xpath "//div[@class='main__content']" to be present
    Then element with xpath "//div[@class='main__content']" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for BoardReader
    Given I open url "https://boardreader.com/"
    Then I should see page title as "Boardreader - Forum Search Engine"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    Then I wait for 3 sec
    Then I wait for element with xpath "//div[contains(@class,'searchResultsBlock')]" to be present
    Then element with xpath "//div[contains(@class,'searchResultsBlock')]" should contain text "behavior"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title as "Ecosia - the search engine that plants trees"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@aria-label='Submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"

  @predefined12
  Scenario: Responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1280 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 800 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 400 and 1024
    Then element with xpath "//b[@id='location']" should not be displayed

  @predefined13
  Scenario: Min length
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    And I clear element with xpath "//input[@name='username']"
    When I type "ab" into element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='username-error']" should not be displayed

  @predefined14
  Scenario: Valid email address
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "john@smith com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "john@smith.com" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined15
  Scenario: "Password" set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "12345" into element with xpath "//input[@id='password']"
    And I type "12346" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='confirmPassword-error']" should be displayed
    When I clear element with xpath "//input[@id='confirmPassword']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='confirmPassword-error']" should not be displayed
    When I clear element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled

  @predefined16
  Scenario: "Name" field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@role='dialog']" should be displayed
    When I type "John" into element with xpath "//input[@id='firstName']"
    And I type "Bob" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "John Bob Smith"

  @predefined17
  Scenario: Accepting Privacy Policy
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I wait for 2 sec
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined18
  Scenario: Non-required fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1234567890" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Canada']"
    And I click on element with xpath "//input[@value='male']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "1020 Main Str., Palo Alto, CA" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='3']"
    And I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1980']"
    And I click on element with xpath "//a[text()='12']"

  @predefined19
  Scenario: Submit and validate the form
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "JS" into element with xpath "//input[@name='username']"
    And I type "john@smith.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@role='dialog']" should be displayed
    When I type "John" into element with xpath "//input[@id='firstName']"
    And I type "Bob" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    And I type "1234567890" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='3']"
    And I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1980']"
    And I click on element with xpath "//a[text()='12']"
    And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Canada']"
    And I click on element with xpath "//input[@value='male']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "1020 Main Str., Palo Alto, CA" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//div[@id='quotePageResult']" should be displayed
    And element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"
    And element with xpath "//b[@name='gender']" should have text as "male"
    And element with xpath "//b[@name='dateOfBirth']" should have text as "04/12/1980"
    And element with xpath "//b[@name='password']" should not have text as "12345"
    And element with xpath "//b[@name='name']" should have text as "John Bob Smith"
    And element with xpath "//b[@name='thirdPartyAgreement']" should have text as "accepted"
    And element with xpath "//b[@name='phone']" should have text as "1234567890"
    And element with xpath "//b[@name='allowedToContact']" should have text as "true"
    And element with xpath "//b[@name='username']" should have text as "JS"
    And element with xpath "//b[@name='countryOfOrigin']" should have text as "Canada"
    And element with xpath "//b[@name='address']" should have text as "1020 Main Str., Palo Alto, CA"
    And element with xpath "//b[@name='email']" should have text as "john@smith.com"
    And element with xpath "//b[@name='carMake']" should have text as "Toyota"









    
    




  