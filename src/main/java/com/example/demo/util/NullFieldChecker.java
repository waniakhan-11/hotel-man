package com.example.demo.util;

import java.lang.reflect.Field;

public class NullFieldChecker {

	public static void copyNonNullFields(Object source, Object target, String skipField) {

		if (source == null || target == null)
			return;

		Field[] sourcFields = source.getClass().getDeclaredFields();
		Field[] targetFields = source.getClass().getDeclaredFields();
//
//        for (Field field : sourcFields) {
//            try {
//                field.setAccessible(true);
//                Object value = field.get(source);
//                if (value != null ) {
//                    field.set(target, value);
//                }
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException("Failed to copy field: " + field.getName(), e);
//            }
//        }

		for (int i = 0; i < sourcFields.length; i++) {
			Field sourceField = sourcFields[i];
			Field targetField = sourcFields[i];

			try {
				sourceField.setAccessible(true);
				targetField.setAccessible(true);
				Object valueSource = sourceField.get(source);
				Object valueTarget = targetField.get(target);
				if (sourceField.getName().equals(skipField) || valueSource == null) {
					continue;
				}

				if (valueSource instanceof Boolean
						&& (valueSource.equals(Boolean.FALSE) && valueTarget.equals(Boolean.FALSE))) {
					continue;
				}

				if (!valueSource.equals(valueTarget)) {
					sourceField.set(target, valueSource);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Failed to copy field: " + sourceField.getName(), e);
			}
		}
	}
}
