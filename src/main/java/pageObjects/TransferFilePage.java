package pageObjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.ConfigFileReader;
import utils.Waiter;

/**
 * The Class holds the information related to transfer page where user can
 * upload and transfer the files. All the actions on transfer page is executed
 * with in this class.
 */
public class TransferFilePage {

	/** The Constant Log. */
	private static final Logger Log = Logger.getLogger(TransferFilePage.class);

	/** The driver. */
	private WebDriver driver;

	/**
	 * Instantiates a new transfer file page.
	 * 
	 * @param driver the driver
	 */
	public TransferFilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/** The btn add your files. */
	@FindBy(how = How.CSS, using = ".uploader__files h2")
	private WebElement btnAddFiles;

	/** The btn add folder. */
	@FindBy(how = How.CSS, using = ".uploader__sub-title")
	private WebElement btnAddFolder;

	/** The btn more options icon. */
	@FindBy(how = How.CSS, using = "[aria-label='Toggle transfer options']")
	private WebElement btnMoreOptionsIcon;

	/** The rbtn get transfer link. */
	@FindBy(how = How.CSS, using = "[for='transfer__type-link']")
	private WebElement rbtnGetTransferLink;

	/** The rbtn send email transfer. */
	@FindBy(how = How.CSS, using = "[for='transfer__type-email']")
	private WebElement rbtnSendEmailTransfer;

	/** The btn get link. */
	@FindBy(how = How.CSS, using = ".transfer__button")
	private WebElement btnGetLink;

	/** The lbl uploaded file count. */
	@FindBy(how = How.CSS, using = "[class='uploader__add-files-count']")
	private WebElement lblUploadedFileCount;

	/** The lbl upload completed. */
	@FindBy(how = How.CSS, using = ".uploader h2")
	private WebElement lblUploadCompleted;

	/** The tbx download link. */
	@FindBy(how = How.CSS, using = ".transfer-link__url")
	private WebElement tbxDownloadLink;

	/** The conf. */
	ConfigFileReader conf = new ConfigFileReader();

	/**
	 * This method is used to add the files from local machine to WeTransfer
	 * 
	 * @throws Exception the exception
	 */
	public void AddFiles() throws Exception {
		String filePath = new File("").getAbsolutePath() + "\\resource\\" + conf.getUploadFileName();
		Waiter.click(driver, btnAddFiles);
		Robot robot = new Robot(); // Robot class is used to mimic the Keyboard actions
		robot.setAutoDelay(1000);
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		robot.keyPress(KeyEvent.VK_CONTROL); // This will mimic the process of pressing CTRL key in the keyboard
		robot.keyPress(KeyEvent.VK_V); // This will mimic the process of pressing V key in the keyboard

		robot.keyRelease(KeyEvent.VK_CONTROL); // This will mimic the process of releasing CTRL key in the keyboard
		robot.keyRelease(KeyEvent.VK_V); // This will mimic the process of releasing V key in the keyboard

		robot.keyPress(KeyEvent.VK_ENTER); // This will mimic the process of pressing ENTER key in the keyboard
		robot.keyRelease(KeyEvent.VK_ENTER); // This will mimic the process of releasing ENTER Key in the keyboard.
		Assert.assertTrue(IsFileAddedSuccessfully());
	}

	/**
	 * This method will upload the added files on to WeTransfer.
	 */
	public void UploadFile() {
		Waiter.clickViaJS(driver, btnMoreOptionsIcon);
		Waiter.clickViaJS(driver, rbtnGetTransferLink);
		Waiter.clickViaJS(driver, btnGetLink);
	}

	/**
	 * This method checks whether the files are added successfully or not.
	 * 
	 * @return true, if successful
	 * @return false, if unsuccessful
	 */
	public boolean IsFileAddedSuccessfully() {
		String labelName = lblUploadedFileCount.getText();
		Log.info("Files added label value is:" + labelName);
		if (labelName.contains("file added")) {
			Log.debug("File is added successfully.");
			return true;
		} else {
			Log.debug("Failed to add the file.");
			return false;
		}
	}

	/**
	 * This method checks whether file is uploaded to WeTransfer or not by checking
	 * whether success message is displayed and also checks for the download link.
	 * 
	 * @return true, if successful
	 * @return false, if unsuccessful
	 */
	public boolean IsFileUploadedSuccessfully() {
		String uploadCompletedLabel = lblUploadCompleted.getText();
		String uploadLinkValue = tbxDownloadLink.getAttribute("value");
		Log.info("Files uploaded label value is:" + uploadCompletedLabel);
		if (uploadCompletedLabel.contains("done") && uploadLinkValue.contains("https://we.tl")) {
			Log.debug("File is uploaded successfully.");
			return true;
		} else {
			Log.debug("Failed to upload the file.");
			return false;
		}
	}

}
