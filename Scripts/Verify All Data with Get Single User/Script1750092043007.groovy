import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'collecting data from get users'
for (int i = 0; i < totalPage; ++i) {
    def responseGetUsers = WS.sendRequestAndVerify(findTestObject('Get Users', [('baseUrl') : GlobalVariable.baseUrl, ('apiKey') : apiKey
                , ('page') : i]), FailureHandling.STOP_ON_FAILURE)

    for (int j = 0; j < WS.getElementPropertyValue(responseGetUsers, 'data').size(); ++j) {
        int userId = WS.getElementPropertyValue(responseGetUsers, ('data[' + j) + '].id')

        def responseGetUser = WS.sendRequestAndVerify(findTestObject('Get Single User', [('baseUrl') : GlobalVariable.baseUrl
                    , ('userId') : userId, ('apiKey') : apiKey]), FailureHandling.STOP_ON_FAILURE)

        WS.verifyElementPropertyValue(responseGetUser, 'data.id', userId, FailureHandling.CONTINUE_ON_FAILURE)

        WS.verifyElementPropertyValue(responseGetUser, 'data.email', WS.getElementPropertyValue(responseGetUsers, ('data[' + 
                j) + '].email'), FailureHandling.CONTINUE_ON_FAILURE)

        WS.verifyElementPropertyValue(responseGetUser, 'data.first_name', WS.getElementPropertyValue(responseGetUsers, ('data[' + 
                j) + '].first_name'), FailureHandling.CONTINUE_ON_FAILURE)

        WS.verifyElementPropertyValue(responseGetUser, 'data.last_name', WS.getElementPropertyValue(responseGetUsers, ('data[' + 
                j) + '].last_name'), FailureHandling.CONTINUE_ON_FAILURE)

        WS.verifyElementPropertyValue(responseGetUser, 'data.avatar', WS.getElementPropertyValue(responseGetUsers, ('data[' + 
                j) + '].avatar'), FailureHandling.CONTINUE_ON_FAILURE)
    }
}

