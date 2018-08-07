import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//1
'Log into FOCiS QM application with Quote Creation access.'
CustomKeywords.'browser.SignIn.As'(GlobalVariable.CSR_User, GlobalVariable.CSR_password)

'Take Screenshot of \'Quotation List Page\' '
WebUI.takeScreenshot()

'Click to Quotation Tab'
WebUI.click(findTestObject('Quotation/Menu/Quotation'))

'Click to Quotation Documents Tab'
WebUI.click(findTestObject('Quotation/Menu/Customer_Documents'))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

'Wait for Add customer new document Icon to be visible'
WebUI.waitForElementVisible(findTestObject('Quotation/Customer_Documents/Add_New_Customer_Document'), 60)

'Wait for Add customer new document Icon to be clickable'
WebUI.waitForElementClickable(findTestObject('Quotation/Customer_Documents/Add_New_Customer_Document'), 300)

'Take screenshot for customer document page'
WebUI.takeScreenshot()

'Click to Add customer new document Icon'
WebUI.click(findTestObject('Quotation/Customer_Documents/Add_New_Customer_Document'))

'Take screenshot for customer document page'
WebUI.takeScreenshot()

'Wait for customer name Popup to be visible'
WebUI.waitForElementVisible(findTestObject('Quotation/Customer_Documents/Customer_Name_PopUp'), 60)

'Click to customer name Popup to be visible'
WebUI.click(findTestObject('Quotation/Customer_Documents/Customer_Name_PopUp'))

WebUI.waitForJQueryLoad(60)

'Set value for customer name for search'
WebUI.setText(findTestObject('Quotation/MQ/QuoteSummaryPage/searchAddress'), 'z AES TEST STAKEHOLDER')

WebUI.sendKeys(findTestObject('Quotation/MQ/QuoteSummaryPage/searchAddress'), Keys.chord(Keys.ENTER))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

WebUI.delay(2)

'Wait for select address to be present'
WebUI.waitForElementPresent(findTestObject('Quotation/MQ/QuoteSummaryPage/selectAddress'), 30)

'Wait for select address to be clickable'
WebUI.waitForElementClickable(findTestObject('Quotation/MQ/QuoteSummaryPage/selectAddress'), 60)

'Click to select address'
WebUI.click(findTestObject('Quotation/MQ/QuoteSummaryPage/selectAddress'))

WebUI.delay(1)

'Take screenshot for customer document page'
WebUI.takeScreenshot()

'Click to customer document create button'
WebUI.click(findTestObject('Quotation/Customer_Documents/Customer_Document_Create_Button'))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

'Take screenshot for customer document page'
WebUI.takeScreenshot()

'Click to Add new document '
WebUI.click(findTestObject('Quotation/Customer_Documents/Add_New_Document'))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

'Enter Document type value'
WebUI.setText(findTestObject('Quotation/Customer_Documents/Document_Type'), 'Customer Document Test')

'Get the absolute file path'
String path = System.getProperty('user.dir') + '\\Drivers\\CustomerDocument.pdf'

System.err.println(path)

'Upload the customer document'
WebUI.uploadFile(findTestObject('Quotation/Customer_Documents/Document_Name'), path)

'Take screenshot for customer document page'
WebUI.takeScreenshot()

'Click to customer details create button'
WebUI.click(findTestObject('Quotation/Customer_Documents/Customer_Document_Details_Create_Button'))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

'Capture the document no in Quote Info Screen and store it as Global Variable'
GlobalVariable.Document_Number = WebUI.getText(findTestObject('Quotation/Customer_Documents/Customer_Document_Number'))

'In Console print the document No.  '
System.err.println(GlobalVariable.Document_Number)

'Take Screenshot after document number being generated'
WebUI.takeScreenshot()

WebUI.waitForPageLoad(10, FailureHandling.OPTIONAL)

'Wait for Uploaded document checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('Quotation/Customer_Documents/Customer_Document_Delete_Checkbox'), 60)

'Wait for Uploaded document checkbox to be clickable'
WebUI.waitForElementClickable(findTestObject('Quotation/Customer_Documents/Customer_Document_Delete_Checkbox'), 60)

WebUI.delay(1)

'Click to Uploaded document checkbox'
WebUI.click(findTestObject('Quotation/Customer_Documents/Customer_Document_Delete_Checkbox'))

'Click to Uploaded document delete Icon'
WebUI.click(findTestObject('Quotation/Customer_Documents/Customer_Document_Delete_Icon'))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

'Take Screenshot after deleting the uploaded document'
WebUI.takeScreenshot()

'Click to Quotation Tab'
WebUI.click(findTestObject('Quotation/Menu/Quotation'))

'Click to Quotation documents Tab'
WebUI.click(findTestObject('Quotation/Menu/Customer_Documents'))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

'Wait for customer document search textbox to be visible'
WebUI.waitForElementVisible(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Search'), 300)

'Enter document number for search'
WebUI.setText(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Search'), GlobalVariable.Document_Number)

WebUI.sendKeys(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Search'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Search'), Keys.chord(Keys.BACK_SPACE))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

WebUI.delay(2)

'Wait for customer document row checkbox to be visible'
WebUI.waitForElementVisible(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Row_Checkbox'), 60)

'Wait for customer document row checkbox to be Clickable'
WebUI.waitForElementClickable(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Row_Checkbox'), 60)

'Take screenshot for customer document searched result'
WebUI.takeScreenshot()

'Click to customer document row checkbox'
WebUI.click(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Row_Checkbox'))

'Click to customer document delete icon'
WebUI.click(findTestObject('Quotation/Customer_Documents/Delete_Customer_Document_Number'))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

'Wait for customer document search textbox to be visible'
WebUI.waitForElementClickable(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Search'), 300)

'Enter document number for search'
WebUI.setText(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Search'), GlobalVariable.Document_Number)

WebUI.sendKeys(findTestObject('Quotation/Customer_Documents/Customer_Document_Number_Search'), Keys.chord(Keys.BACK_SPACE))

'Wait until page is loaded'
CustomKeywords.'fn.QM.Wait_For.page_loading'()

WebUI.delay(2)

'Take screenshot for customer document searched result'
WebUI.takeScreenshot()

'Wait for customer document search result to be visible'
WebUI.waitForElementVisible(findTestObject('Quotation/Customer_Documents/Customer_Document _Search_Result_text'), 60)

'Get the customer document search result text'
String Status = WebUI.getText(findTestObject('Quotation/Customer_Documents/Customer_Document _Search_Result_text'))

'Print the customer document search result text'
println(Status)

'Get the assert value after comapring values'
Boolean StatusValue = Status.equals('No records to view')

'Print the assert value'
println(StatusValue == true)

'Validating value with Assert condition'
assert StatusValue == true

'Static delay'
WebUI.delay(2)

'Close the Browser'
WebUI.closeBrowser()

