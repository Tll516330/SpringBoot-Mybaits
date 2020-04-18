package cn.tll.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串类型转日期类型
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * 传来的字符串
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断传来的字符串是否为空
        if (source == null){
            //运行时异常
            throw new RuntimeException("请输入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return df.parse(source);
        } catch (Exception e) {
           throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
