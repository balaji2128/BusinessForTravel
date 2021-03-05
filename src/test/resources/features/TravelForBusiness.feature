@B2B_Travel @Sanity
  Feature: TravelForBusiness



    Background: User navigate to B2B page
      Given I am on travelForBusiness page

    @Test1
    Scenario: User should be able to add details
      When I Click on register
      Then I Should be redirect to the Forms
      And I Fill the details
      Then I Upload NPWP Document
      Then I Upload TDP Document
      Then I Upload SIUP Document
      Then I check the Documents
      Then I accpet to Terms and Conditions
