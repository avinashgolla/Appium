package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

/**
 * 
 * @author avinashg
 *
 */


public class MobileElectronicsPageActivity extends UIUtility {

	By homeMenu = MobileBy.className("android.widget.TextView");
	String title = "android.widget.TextView";
	String mobileElectronics = "//*[text()='Mobiles & Electronics']";
	String mobileByTypes = "com.snapdeal.main:id/tysProductItemTitle";
	String mobileByPrice = "com.snapdeal.main:id/txvProductItemTitle";
	String mobileByPicks = "com.snapdeal.main:id/price_range_text";
	String gameTypes = "com.snapdeal.main:id/price_range_text";
	String gameItems = "com.snapdeal.main:id/txvProductItemTitle";
	String bestDeals = "com.snapdeal.main:id/tysProductItemTitle";
	String trimmersPrice = "com.snapdeal.main:id/tysProductItemTitle";
	String greatDeals = "com.snapdeal.main:id/price_range_text";
	String moreLink = "//android.widget.TextView[text()='More']";
	String applianceItems = "com.snapdeal.main:id/txvProductItemTitle";
	String tabletTypes = "com.snapdeal.main:id/tysProductItemTitle";
	String tabletItems = "com.snapdeal.main:id/txvProductItemTitle";
	String osText = "com.snapdeal.main:id/price_range_text";
	String priceStore = "com.snapdeal.main:id/price_range_text";
	String item = "//android.widget.TextView[text()='Televisions']";
	String cartButton = "com.snapdeal.main:id/addCartBUtton";
	String goToCart = "com.snapdeal.main:id/addCartBUtton";
	String removeItem = "com.snapdeal.main:id/btnMinus";
	String remove = "com.snapdeal.main:id/tvNoDialog";
	String firstTV = "com.snapdeal.main:id/productTitle";

	public MobileElectronicsPageActivity(AppiumDriver driver) {
		super(driver);
		sleep(5000L);
		initPage(driver.findElement(homeMenu));
	}

	public void navigateToBackPage() {
		driver.navigate().back();
		/*
		 * Below code also works AndroidDriver adriver = (AndroidDriver) driver;
		 * adriver.pressKeyCode(AndroidKeyCode.BACK);
		 */
	}

	public String getPageTitle(String subCategoryName) {
		String category = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		waitForElementVisibility( 60, driver.findElementByXPath(category));
		return driver.findElementByXPath(category).getText();

	}

	public List<String> getAllMobilesByPriceRange() {
		List<String> text = getListOfElementsByID( mobileByPrice);
		List<String> fList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			fList.add(text.get(i));

		}
		return fList;
	}

	public List<String> getAllMobilesByPriceType() {
		waitForElementVisibility( 60, driver.findElementById(mobileByTypes));
		List<String> text = getListOfElementsByID( mobileByTypes);
		return text;
	}

	public List<String> getAllMobilesByPicks() {
		driver.scrollToExact("Top Picks");
		List<String> text = getListOfElementsByID( mobileByPicks);
		return text;
	}

	public List<String> getAllGameItems() {
		List<String> text = getListOfElementsByID( gameItems);
		List<String> ftext = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
			ftext.add(text.get(i));
		return ftext;
	}

	public List<String> getAllGameTypes() {
		driver.scrollTo("Play Games with consoles");

		List<String> text = getListOfElementsByID( gameTypes);
		return text;
	}

	public List<String> getAllBestDeals() {
		driver.scrollToExact("Limited Period Offer");
		List<String> text = getListOfElementsByID( bestDeals);
		return text;
	}

	public List<String> getAllApplianceItems() {
		List<String> text = getListOfElementsByID( applianceItems);
		return text;
	}

	private void clickMoreLink() {
		clickElementusingXPath( moreLink);
	}

	public List<String> getGreatDeals() {
		driver.scrollTo("Great Deals");
		List<String> text = getListOfElementsByID( greatDeals);
		return text;
	}

	public List<String> getAllTrimmersByPrice() {
		driver.scrollToExact("Trimmers By Price");
		List<String> text = getListOfElementsByID( trimmersPrice);
		return text;
	}

	public List<String> getTabletTypes() {
		List<String> text = getListOfElementsByID( tabletTypes);
		return text;
	}

	public List<String> getTabletItems() {
		List<String> text = getListOfElementsByID( tabletItems);
		return text;
	}

	public List<String> getPriceStore() {
		driver.scrollTo("20,000 and Above");
		List<String> text = getListOfElementsByID( priceStore);
		return text;
	}

	public List<String> getOS() {
		driver.scrollTo("Shop By Operating System");
		List<String> text = getListOfElementsByID( osText);
		return text;
	}

	public void addItemToCart(String item) {
		clickElementByText( item);
		sleep(5000L);
		clickElementByText( getFirstItemTitle());
		sleep(5000L);
		clickElementByText( getFirstTVTitle());
		sleep(5000L);
		clickElementusingID( cartButton);
	}

	public void removeItemToCart() {
		sleep(5000L);
		clickElementusingID( goToCart);
		sleep(5000L);
		clickElementusingID( removeItem);
		clickElementusingID( remove);
		navigateToBackPage();
	}

	public String getCartButtonText() {
		return driver.findElementById("com.snapdeal.main:id/addCartBUtton").getText();

	}

	public String getFirstTVTitle() {
		return driver.findElementById(firstTV).getText();
	}

	public String getFirstItemTitle() {
		return driver.findElementById(mobileByPrice).getText();
	}

	public void swipeAndZoom(String item) {
		clickElementByText( item);
		sleep(5000L);
		clickElementByText( getFirstItemTitle());
		sleep(5000L);
		clickElementByText( getFirstTVTitle());
		clickElementusingID( "com.snapdeal.main:id/imageView");
		for (int i = 0; i < 10; i++)
			driver.pinch(driver.findElementById("com.snapdeal.main:id/imageView"));
	}

	public List<String> getEquipmentTypes() {
		List<String> text = getListOfElementsByID( mobileByPrice);
		return text;
	}

	public List<String> getOfficeMustHaves() {
		swipeDown();
		List<String> text = getListOfElementsByID( tabletTypes);
		return text;
	}

	public List<String> getShopByType() {
		driver.scrollTo("Shop By Type");
		List<String> text = getListOfElementsByID( mobileByPicks);
		return text;
	}

	public List<String> getAllItems() {
		List<String> text = getListOfElementsByID( mobileByPrice);
		return text;
	}

	public List<String> getTopViewedProducts() {
		swipeDown();
		List<String> text = getListOfElementsByID( mobileByTypes);
		return text;
	}

	public List<String> getItemsFromBudgetStore() {
		driver.scrollToExact("McAfee Antivirus @ Rs 99");
		List<String> text = getListOfElementsByID( mobileByPicks);
		return text;
	}

	public List<String> getAllCameraItems() {
		List<String> text = getListOfElementsByID( mobileByPrice);
		return text;
	}

	public List<String> getAllBestCameras() {
		driver.scrollToExact("Best of Cameras");
		List<String> text = getListOfElementsByID( mobileByPicks);
		return text;
	}
}
