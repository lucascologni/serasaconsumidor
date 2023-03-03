Feature: Consumer login

  Background:
    Given that a consumer access the login page

  Scenario: A mandatory CPF message is displayed if consumer does not insert a CPF.
    Given that a consumer inserts a valid CPF
    When consumer erases the inserted cpf
    Then a mandatory CPF message is displayed

  Scenario: An invalid CPF message is displayed if consumer inserts an invalid CPF.
    When consumer inserts an invalid CPF
    Then an invalid CPF message is displayed

  Scenario: Continue button is enabled if consumer inserts a valid CPF.
    When consumer inserts a valid CPF
    Then the Continue button is enabled

  Scenario: Continue button is disabled if consumer erases the CPF.
    When consumer erases the inserted cpf
    Then the Continue button is disabled

  Scenario: Continue button is disabled if consumer inserts an invalid CPF.
    When consumer inserts an invalid CPF
    Then the Continue button is disabled