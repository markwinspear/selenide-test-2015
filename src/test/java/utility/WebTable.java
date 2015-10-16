package utility;

/**
 * Creates as there are no built in Webdriver classes to handle Webtables or tables (Selenium Testing Tools Cookbook)
 */
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class WebTable {

    private WebElement webTable;

    public WebTable(WebElement webTable) {
        setwebTable(webTable);
    }

    public WebElement getwebTable() {
        return webTable;
    }

    public void setwebTable(WebElement webTable) {
        this.webTable = webTable;
    }

    public int getRowCount() {
        List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
        return tableRows.size();
    }

    public int getColumnsCount() {
        List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
        WebElement headerRow = tableRows.get(0);
        List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
        return tableCols.size();
    }

    /**
     * Retrieve data from a specific cell of a table
     * @param rowIndex Row number
     * @param colIndex Column number
     * @return the contents of the specified cell
     * @throws NoSuchElementException
     */
    public String getCellData (int rowIndex, int colIndex) {
            List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(rowIndex - 1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            WebElement cell = tableCols.get(colIndex - 1);
            return cell.getText();
        }

    /**
     * For editable table cells, return the editable cell as a WebElement.
     * May need expanding to include an index for editable cells if more than one exists within a cell
     * @param rowIndex Row number
     * @param colIndex Cell number
     * @return the cell as a WebElement
     * @throws NoSuchElementException
     */
    public WebElement getEditableCellAsWebElement (int rowIndex, int colIndex) throws NoSuchElementException {
        try {
            List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(rowIndex - 1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            WebElement cell = tableCols.get(colIndex - 1);
            WebElement cellEditor = cell.findElement(By.tagName("input"));
            return cellEditor;

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Failed to get cell");
        }

    }
}
