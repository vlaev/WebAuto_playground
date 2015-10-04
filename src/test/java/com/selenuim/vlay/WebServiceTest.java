package com.selenuim.vlay;

import com.eviware.soapui.tools.SoapUITestCaseRunner;
import org.testng.annotations.Test;

public class WebServiceTest {

    @Test
    public void setUpSoapUI()throws Exception {
        SoapUITestCaseRunner soapUITestCaseRunner = new SoapUITestCaseRunner();
        soapUITestCaseRunner.setProjectFile("src/test/soapUI/vlay-pythonanywhere-soapui-project.xml");
        soapUITestCaseRunner.run();
    }


}
