Feature: EGO Cepte
  @VerificationOfTheAnnouncementsSection
  Scenario: Verification of the Announcements section
    Given Click the Announcements button
    Then Verify Announcements post
  @SearchBusStop
  Scenario: Search Bus Stop
    Given Click the Durak Ara button
    Given Click the add card button
    Given Add card number
    Given Add card title
    Given Choose card color
