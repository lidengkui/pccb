
package com.pccb.test.test;

import com.pccb.common.com.pccb.common.boot.Apps;

/**
 * @author qiubo
 */
public abstract class TestBase extends AppWebTestBase {
	protected static final String PROFILE = "stest";

	static {
		Apps.setProfileIfNotExists(PROFILE);
	}
	
}
