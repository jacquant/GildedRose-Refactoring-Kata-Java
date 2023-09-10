package com.gildedrose;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private Item[] items = new Item[1];
    private GildedRose app;

    @Given("The item with name={string}")
    public void initial_sellin_is_and_quality_is(String name) {
        initial(name, 0, 0);
    }

    @Given("The item with name={string} and sellIn={int} and quality={int}")
    public void initial(String name, Integer sellIn, Integer quality) {
        items[0] = new Item(name, sellIn, quality);
        app = new GildedRose(items);
    }

    @When("I update the quality")
    public void i_update_the_quality() {
            i_update_the_quality_x_times(1);
    }

    @When("I update the quality {int} times")
    public void i_update_the_quality_x_times(int times) {
        for (int i = 0; i < times; i++) {
            app.updateQuality();
        }
    }

    @Then("I should get item with name={string}")
    public void i_should_get_name_as(String expectedName) {
        assertEquals(expectedName, app.items[0].name);
    }

    @Then("I should get item with sellIn={int}")
    public void i_should_get_sellin_as(int expectedSellIn) {
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }
    @Then("I should get item with quality={int}")
    public void i_should_get_quality_as(int expectedQuality) {
        assertEquals(expectedQuality, app.items[0].quality);
    }
}

