package com.demoblaze.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BasePage{

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(xpath = "//div//input[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//div//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//div//input[@id='card']")
    public WebElement creditCard;

    @FindBy(xpath = "//div//input[@id='month']")
    public WebElement month;

    @FindBy(xpath = "//div//input[@id='year']")
    public WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchase;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement orderDetails;

    @FindBy(xpath = "//*[.='OK']")
    public WebElement ok;

    public void fillForm() {

        Faker faker = new Faker();
        name.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        creditCard.sendKeys(faker.finance().creditCard());
        month.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        year.sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        purchase.click();
    }

}
