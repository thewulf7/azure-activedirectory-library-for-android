
package com.microsoft.adal.test;

import junit.framework.Assert;

import com.microsoft.adal.CacheKey;
import com.microsoft.adal.TokenCacheItem;

import android.test.AndroidTestCase;

public class CacheKeyTests extends AndroidTestCase {

    /**
     * Verify constructor and getters
     */
    public void testcreateCacheKey() {
        CacheKey testKey = CacheKey.createCacheKey("authority", "resource", "clientId");
        assertEquals("Same authority is expected", "authority", testKey.getAuthority());
        assertEquals("Same resource is expected", "resource", testKey.getResource());
        assertEquals("Same clientid is expected", "clientId", testKey.getClientId());

        // key itself contains at least authority
        assertTrue(testKey.toString().contains("authority"));
    }

    /**
     * null values does not fail
     */
    public void testcreateCacheKeyNullValues() {
        CacheKey testKey = CacheKey.createCacheKey(null, null, null);
        assertEquals(null, testKey.getAuthority());
        assertEquals(null, testKey.getResource());
        assertEquals(null, testKey.getClientId());

        // key itself contains at least authority
        assertFalse(testKey.toString().contains("authority"));
    }

    public void testcreateCacheKeyNullItem() {

        try {
            CacheKey.createCacheKey((TokenCacheItem)null);
            Assert.fail("not expected");
        } catch (Exception exc) {
            assertTrue("argument exception", exc instanceof IllegalArgumentException);
        }
    }
}