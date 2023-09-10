Feature: Gilded Rose
  I want to be sure that updating the quality of an item works as expected

  Scenario: Checking foo name
    Given The item with name="foo"
    When I update the quality
    Then I should get item with name="foo"

  Scenario: Checking standard item decrease by one each day
    Given The item with name="foo" and sellIn=10 and quality=10
    When I update the quality
    Then I should get item with name="foo"
    And I should get item with quality=9
    And I should get item with sellIn=9

    Scenario: Quality of an item is never negative
      Given The item with name="foo" and sellIn=10 and quality=0
      When I update the quality
      Then I should get item with name="foo"
      And I should get item with quality=0
      And I should get item with sellIn=9

    Scenario: Once the sell by date has passed, Quality degrades twice as fast
      Given The item with name="foo" and sellIn=0 and quality=10
      When I update the quality
      Then I should get item with name="foo"
      And I should get item with quality=8
      And I should get item with sellIn=-1

    Scenario: "Aged Brie" actually increases in Quality the older it gets
      Given The item with name="Aged Brie" and sellIn=10 and quality=10
        When I update the quality
        Then I should get item with name="Aged Brie"
        And I should get item with quality=11
        And I should get item with sellIn=9

    Scenario: The Quality of an item is never more than 50
      Given The item with name="Aged Brie" and sellIn=10 and quality=50
      When I update the quality
      Then I should get item with name="Aged Brie"
      And I should get item with quality=50
      And I should get item with sellIn=9

    Scenario: The Quality of Aged Brie increases twice as fast after the sell by date
      Given The item with name="Aged Brie" and sellIn=0 and quality=10
      When I update the quality
      Then I should get item with name="Aged Brie"
      And I should get item with quality=12
      And I should get item with sellIn=-1
      
    Scenario: "Sulfuras, Hand of Ragnaros", being a legendary item, never has to be sold or decreases in Quality
      Given The item with name="Sulfuras, Hand of Ragnaros" and sellIn=10 and quality=80
      When I update the quality
      Then I should get item with name="Sulfuras, Hand of Ragnaros"
      And I should get item with quality=80
      And I should get item with sellIn=10

    Scenario: "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
      Given The item with name="Backstage passes to a TAFKAL80ETC concert" and sellIn=15 and quality=20
      When I update the quality
      Then I should get item with name="Backstage passes to a TAFKAL80ETC concert"
      And I should get item with quality=21
      And I should get item with sellIn=14

    Scenario: "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; quality increases by 2 when there are 10 days or less
      Given The item with name="Backstage passes to a TAFKAL80ETC concert" and sellIn=10 and quality=20
      When I update the quality
      Then I should get item with name="Backstage passes to a TAFKAL80ETC concert"
      And I should get item with quality=22
      And I should get item with sellIn=9

  Scenario: "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; quality increases by 2 when there are 10 days or less
    Given The item with name="Backstage passes to a TAFKAL80ETC concert" and sellIn=10 and quality=20
    When I update the quality
    Then I should get item with name="Backstage passes to a TAFKAL80ETC concert"
    And I should get item with quality=22
    And I should get item with sellIn=9

    Scenario: "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; quality increases by 3 when there are 5 days or less
      Given The item with name="Backstage passes to a TAFKAL80ETC concert" and sellIn=6 and quality=20
      When I update the quality 2 times
      Then I should get item with name="Backstage passes to a TAFKAL80ETC concert"
      And I should get item with quality=25
      And I should get item with sellIn=4

    Scenario: "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; quality drops to 0 after the concert
      Given The item with name="Backstage passes to a TAFKAL80ETC concert" and sellIn=0 and quality=20
      When I update the quality
      Then I should get item with name="Backstage passes to a TAFKAL80ETC concert"
      And I should get item with quality=0
      And I should get item with sellIn=-1

    Scenario: An item can never have its Quality increase above 50
      Given The item with name="Backstage passes to a TAFKAL80ETC concert" and sellIn=10 and quality=48
      When I update the quality 3 times
      Then I should get item with name="Backstage passes to a TAFKAL80ETC concert"
      And I should get item with quality=50
      And I should get item with sellIn=7
