package com.ssslinppp.enumConvert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * Created with IntelliJ IDEA.
 * User: liulin
 * Date: 2017/6/30
 * Time: 20:26
 * Description： 将String转换为枚举类型
 * To change this template use File | Settings | File Templates.
 */
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, IBaseEnum> {
    @Override
    public <T extends IBaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        if (!targetType.isEnum()) {
            throw new UnsupportedOperationException("只支持转换到枚举类型");
        }
        return new StringToBaseEnumConverter(targetType);
    }

    private class StringToBaseEnumConverter<T extends IBaseEnum> implements Converter<String, T> {
        private final Class<T> enumType;

        public StringToBaseEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String s) {
            for (T t : enumType.getEnumConstants()) {
                if (s.equals(t.getName())) {
                    return t;
                }
            }
            return null;
        }
    }
}
