package openagent.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://findagents.openagent.com.au/28/")
public class FindAgentsListingPage extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade captureProfileModalNameField;

    @FindBy(xpath = "//form[@id='details-submit-form']/input[@type='email']")
    private WebElementFacade captureProfileModalEmailField;

    @FindBy(xpath = "//form[@id='details-submit-form']/input[@type='tel']")
    private WebElementFacade captureProfileModalTelField;

    @FindBy(linkText = "Compare Agents")
    private WebElementFacade captureProfileModalSubmitButton;

    @FindBy(xpath = "//span[@class='page-maintitle']")
    private WebElementFacade pageTitle;

    public void fill_create_profile_modal_form(String name, String email, String tel) {
        captureProfileModalNameField.type(name);
        captureProfileModalEmailField.type(email);
        captureProfileModalTelField.type(tel);
    }

    public void submit_create_profile_modal_form() {
        captureProfileModalSubmitButton.click();
    }

    public String get_title() {
        return pageTitle.getTextValue();
    }
}