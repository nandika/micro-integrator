/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.esb.http.inbound.transport.test;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.esb.integration.common.utils.ESBIntegrationTest;

public class HttpInboundTransportTenantTestCase extends ESBIntegrationTest {

    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {
        super.init();
    }

    @Test(groups = "wso2.esb", description = "Inbound Http  test case for tenant")
    public void inboundHttpTest() throws AxisFault {
        OMElement response = axis2Client.sendSimpleStockQuoteRequest("http://localhost:8081/t/wso2.com/", null, "IBM");
        Assert.assertNotNull(response);
        Assert.assertEquals("getQuoteResponse", response.getLocalName());
    }

    @Test(groups = "wso2.esb", description = "Inbound Http  test case for tenant API dispatching")
    public void inboundHttpAPITest() throws AxisFault {
        OMElement response = axis2Client
                .sendSimpleStockQuoteRequest("http://localhost:8082/t/wso2.com/test/map", null, "IBM");
        Assert.assertNotNull(response);
        Assert.assertEquals("getQuoteResponse", response.getLocalName());
    }
}
