package com.jetty.homolo.security.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-27  上午10:52
 */
public class ObjectUtil {
	private static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

	/**
	 * 根据属性名获取属性值
	 *
	 */
	public static <T>T getFieldValueByName(String fieldName, Object o, Class<T> tClass) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[]{});
			Object obj = method.invoke(o, new Object[]{});
			if (tClass == String.class && obj instanceof String) {
				obj = String.valueOf(obj);
			}
			if (tClass == Integer.class && obj instanceof Integer) {
				obj = Integer.parseInt(String.valueOf(obj));
			}
			return tClass.cast(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 将对象转换为json字符串.
	 * @param object  object
	 * @return String
	 * @throws Exception String
	 */
	public static String writeValueAsString(Object object) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
				String fieldName = field.getName();
				Class<?> type = field.getType();
				Object fieldValueByName = getFieldValueByName(fieldName, object, type);
				jsonObject.put(fieldName, fieldValueByName);
			}
		}
		return jsonObject.toJSONString();
	}
}
