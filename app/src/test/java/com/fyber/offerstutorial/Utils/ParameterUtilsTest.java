package com.fyber.offerstutorial.Utils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by muhammadkorany on 10/15/16.
 */
public class ParameterUtilsTest {

    String params = "appid=2070&google_ad_id=b8871030-8fac-439f-82e5-1ad2090d68fa&google_ad_id_limited_tracking_enabled=false&locale=en&os_version=22&timestamp=1476489425&uid=spiderman&1c915e3b5d42d05136185030892fbb846c278927";
    String hash = "39892851309ae9f2f7b9ef322c56ca67f944c8df";

    @Test
    public void sha1Hash() throws Exception {
        assertThat(hash, is(ParameterUtils.sha1Hash(params)));
    }

}