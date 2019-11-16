package com.jetty.homolo.security.encrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-11-16  上午11:48
 */
public class HmacSha256Test {
	private Logger logger = LoggerFactory.getLogger(HmacSha256Test.class);
	@Test
	public void test() {
		String appId = RandomStringUtils.randomNumeric(15).toLowerCase(Locale.CHINESE);
		logger.info("appId : {}", appId);
		String appSecret = RandomStringUtils.randomAlphanumeric(40);
		logger.info("appSecret : {}", appSecret);

		long nonce = new Date().getTime();
		logger.info("nonce : {}", nonce);

//		Base64.encodeBase64String(HmacUtils.hmacSha256

		byte[] bytes = HmacUtils.hmacSha256(appSecret, nonce + appSecret);
		Mac initializedMac = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, appSecret.getBytes());
		Mac mac = HmacUtils.updateHmac(initializedMac, nonce + appSecret);
		byte[] bytes1 = mac.doFinal();
		System.out.println(Arrays.toString(bytes));
		System.out.println(Arrays.toString(bytes1));
	}

	@Test
	public void testMD5() {
		String md5Digest = DigestUtils.md5Hex("中国");
		System.out.println(md5Digest);
	}
}
