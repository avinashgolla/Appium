package com.imaginea.pageobjects.nativeApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

/**
 * All Keyword of Fashion Page should be update here
 * 
 * @author krishnakumarnellore
 *
 */
public class FashionPageActivity extends UIUtility {

    private String fashionSubCategory = "com.snapdeal.main:id/subCategoryTitleTextView";
    private String sortResourceId = "com.snapdeal.main:id/textView";
    private String productDiscount = "com.snapdeal.main:id/productDiscount";
    private String productTitle = "com.snapdeal.main:id/productTitle";
    private String startPrice = "com.snapdeal.main:id/filterTextStart";
    private String endPrice = "com.snapdeal.main:id/filterTextEnd";
    private String productDisplayPrice = "com.snapdeal.main:id/productDisplayPrice";
    private String productDiscountPrice = "com.snapdeal.main:id/productDiscount";
    private String imageId = "com.snapdeal.main:id/imageView";
    private String menuCartIcon = "com.snapdeal.main:id/menu_cart_icon";
    private String txtProductName = "com.snapdeal.main:id/txtProductName";
    private String txtCount = "com.snapdeal.main:id/txtCount";
    private String sliderTitle = "com.snapdeal.main:id/sliderTitle";
    private String groupTitle = "com.snapdeal.main:id/groupTitle";
    private String reviewText = "com.snapdeal.main:id/writeFirstReviewstxt";
    private String avgRatingText = "com.snapdeal.main:id/avg_rating_txt";
    private String addToCart = "com.snapdeal.main:id/stvDoneDialogAttribute";

    public FashionPageActivity(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Select Sub Category of Fashion
     * 
     * @param subCategory
     */
    public void selectSubCategory(String subCategory) {
        sleep(3000L);
        clickElementByText(subCategory);        
    }

    /**
     * Get Sub Category List
     * 
     * @return
     */
    public List<String> getSubCategoryList() {
        return getListOfElementsByID(fashionSubCategory);
    }

    /**
     * Get List of Sort Category
     * 
     * @return
     */
    public List<String> getSortCategoryList() {
        return getListOfElementsByID(sortResourceId);
    }

    /**
     * Get Product Discount List
     * 
     * @return
     */
    public List<String> getProductDiscountList() {
        swipeDown();
        return getListOfElementsByID(productDiscount);
    }

    /**
     * To click field by Text
     * 
     * @param title
     */
    public void selectCategoryByText(String title) {
        String category = String.format("//android.widget.TextView[@text='%s']", title);
        fluentWait(driver.findElement(By.xpath(category)));
        waitForElementVisibility(30, driver.findElement(By.xpath(category)));
        clickElementusingXPath(category);
    }

    /**
     * Click on Apply Button
     */
    public void clickApplyButton() {
        clickElementByText("APPLY");
    }

    /**
     * Click on Apply Button
     */
    public void clickApplyFiltersButton() {
        clickElementByText("Apply Filters");
    }

    /**
     * Get Product Title List
     * 
     * @return
     */
    public List<String> getProductTitleList() {        
        swipeDown();
        return getListOfElementsByID(productTitle);
    }

    /**
     * Set Price Filter
     * 
     * @param sPrice
     * @param ePrice
     */
    public void setPriceFilter(String sPrice, String ePrice) {
        enterTextByID(startPrice, sPrice);
        enterTextByID(endPrice, ePrice);
        clickElementByText("Apply Filters");
    }

    /**
     * Get Product Display Price List
     * 
     * @return
     */
    public List<String> getProductDisplayPriceList() {
        swipeDown();
        swipeDown();
        return getListOfElementsByID(productDisplayPrice);
    }

    /**
     * Get Product Discount List
     * 
     * @return
     */
    public List<String> getProductDiscountPriceList() {        
        swipeDown();        
        return getListOfElementsByID(productDiscountPrice);
    }

    /**
     * Zoom Image by single tap
     */
    public void zoomImage() {
        zoomImageById(imageId);
    }

    /**
     * Click On Menu Cart Icon
     */
    public void clickMenuCartIcon() {
        clickElementusingID(menuCartIcon);
    }

    /**
     * Get Product Name Added to cart list
     * 
     * @return
     */
    public List<String> getCartProductNameList() {
        return getListOfElementsByID(txtProductName);
    }

    /**
     * Get Count Of cart Product List
     * 
     * @return
     */
    public List<String> getCartProductCountList() {
        return getListOfElementsByID(txtCount);
    }

    /**
     * Swipe down
     * 
     * @param title
     * @return
     */
    public boolean swipeDownAndFindSliderTitle(String title) {        
        List<String> stitle = new ArrayList<>();
        while (!stitle.contains(title)) {
            swipeDown();
            try {
                stitle = getListOfElementsByID(sliderTitle);
                if (stitle.contains("Sunglasses & Fragrances")) {
                    break;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                continue;
            }
        }
        return stitle.contains(title);
    }

    /**
     * Swipe Filter Category in Button of Mobile Devices
     */
    public void swipeFilterCategoryInBottom() {       
        
        WebElement element = null;
        String category = "//android.widget.TextView[@text='%s']";
        try {
            fluentWait(driver.findElementByXPath(String.format(category, "Discount %")));
            List<WebElement> elements =driver.findElementsById("com.snapdeal.main:id/main_container");   
            element = elements.get(elements.size()-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        if (element != null)
            swipeLeft(element);
        sleep(2000L);
        List<String> containerText = getListOfElementsByID("com.snapdeal.main:id/main_container");
        int counter = 0;
        while (counter < 2) {
            List<WebElement> elements =driver.findElementsById("com.snapdeal.main:id/main_container");   
            element = elements.get(elements.size()-1);
            swipeLeft(element);
            counter++;
        }
    }

    /**
     * Is Product Group Title displayed
     * 
     * @return
     */
    public boolean isProductGroupTitleElementPresent() {
        return isElementPresent(groupTitle);
    }

    /**
     * Swipe down and get rating of App
     * 
     * @return
     */
    public String swipeDownAndFindRating() {        
        while (!isElementPresent(avgRatingText)) {
            swipeDown();
        }
        return getListOfElementsByID(avgRatingText).get(0);
    }
    
    public void clickAddToCart(){        
        fluentWait(driver.findElementById(addToCart));
        clickElementusingID(addToCart);
    }
}
