package com.gd.test.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.RandomStringUtils;

import com.gd.test.common.CommonProperties;

public class Utils {
	/**
	 * Primary Key 생성
	 * 
	 * @return String
	 */
	public static String getPrimaryKey() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(new java.util.Date()) + RandomStringUtils.randomNumeric(6);	// 6자리 랜덤숫자를 만듦
		// 총 20자리의 랜덤한 숫자를 만들기 때문에 중복될 일이 거의 없음 (날짜 + 6개의랜덤한숫자)
	}
	
	/**
	 * 문자열을 key를 통해 암호화 하고 base64 로 인코딩
	 * 
	 * @return String
	 * @throws Throwable
	 */
	public static String encryptAES128(String value) throws Throwable {
		// 이것은 2중 암호화 (간단한 사이트 구현시 base64만 해도 됨)
		// SecretKeySpec : 암호화 된 암호화 키를 생성(하겠다)
		SecretKeySpec keySpec 
				= new SecretKeySpec(CommonProperties.SECURE_KEY.getBytes("UTF-8"), "AES");

		// Cipher : 암호화 객체 (암호화를 진행하는 애)
		Cipher cipher = Cipher.getInstance("AES");	// .getInstance(방식) : 암호화 방식 지정
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);	// init(모드,키) : 객체 초기화 (ENCRYPT_MODE : 암호화 모드)
		byte[] encrypted = cipher.doFinal(value.getBytes()); 	// 암호화
		
		Encoder encoder = Base64.getEncoder();	// Encoder : Base64방식의 인코더
		
		String encodeString = encoder.encodeToString(encrypted); // 바이트 타입의 배열을 문자열로 변환

		return encodeString;
	}

	/**
	 * key 를 통해 문자열 base64 디코딩
	 * 
	 * @return String
	 * @throws Throwable
	 */
	public static String decryptAES128(String value) throws Throwable {
		// 암호화 키 생성
		SecretKeySpec keySpec = 
				new SecretKeySpec(CommonProperties.SECURE_KEY.getBytes("UTF-8"), "AES");

		// 복호화모드 암호화ㄴ객체 생성
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		
		// Base64 디코더
		Decoder decoder = Base64.getDecoder();
		// Base64 복호화
		byte[] decodeBytes = decoder.decode(value); //문자열 형태의 파라메터를 배열에 바이트 변환 후 삽입
		// AES128 복호화
		byte[] decryptBytes = cipher.doFinal(decodeBytes); // 복호화

		return new String(decryptBytes);
	}
	
	/**
	 * MAP의 Key를 소문자로 변환
	 * 
	 * @return HashMap<String, String>
	 */
	public static HashMap<String, String> toLowerMapKey(HashMap<String, String> oldMap) throws Throwable {
		Set<String> keySet = oldMap.keySet();
		
		Iterator<String> keys = keySet.iterator();
		
		HashMap<String, String> newMap = new HashMap<String, String>();
		
		while(keys.hasNext()) {
			String key = keys.next();
			newMap.put(key.toLowerCase(), String.valueOf(oldMap.get(key)));
		}
		
		return newMap;
	}
	
	/**
	 * List의 MAP Key를 소문자로 변환
	 * 
	 * @return HashMap<String, String>
	 */
	public static List<HashMap<String, String>> toLowerListMapKey(List<HashMap<String, String>> oldList) {
		List<HashMap<String, String>> newList = new ArrayList<HashMap<String, String>>();
		
		for(HashMap<String, String> oldMap : oldList) {
			Set<String> keySet = oldMap.keySet();
			
			Iterator<String> keys = keySet.iterator();
			
			HashMap<String, String> newMap = new HashMap<String, String>();
			
			while(keys.hasNext()) {
				String key = keys.next();
				newMap.put(key.toLowerCase(), String.valueOf(oldMap.get(key)));
			}
			
			newList.add(newMap);
		}
		
		return newList;
	}
}
