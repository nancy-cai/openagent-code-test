package openagent.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

public class Homepage extends PageObject {

    @FindBy(id = "property-search")
    private WebElementFacade searchAgentField;

    public void openPage() {
        getDriver().navigate().to("http://findagents.openagent.com.au/28/");
    }

    public void search_for_agent(String keyword) {
        searchAgentField.type(keyword);
    }

    public void select_search_agent_autocomplete(String suburb) {
        List<WebElement> suburbs = getDriver().findElements(By.xpath(".//*[@class='suburb-search-results']/ul/li"));
        for (WebElement sub : suburbs) {

            if (sub.getAttribute("data-sub").equalsIgnoreCase(suburb)) {
                sub.click();
                break;
            }
        }
    }
}