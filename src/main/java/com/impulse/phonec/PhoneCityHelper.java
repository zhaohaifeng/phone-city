package com.impulse.phonec;

/**
 * @author zhaohaifeng
 * @since 2015-03-10
 */
public class PhoneCityHelper {

    private static final String DEFAULT_STR = "未找到城市，请将该手机号手动添加到资源文件里";

    private static final String PHONE_ILLEGAL_STR = "请输入正确的手机号码";

    public static String getCityByPhone(String phone) {

        if (!Utils.isPhone(phone)) {
            return PHONE_ILLEGAL_STR;
        }

        //对手机号做了一系列优化，减小资源文件，但查询需要多次
        String num = phone.substring(0, 7);
        String num2 = phone.substring(0, 6);

        String city= PhoneCityResource.getInstance().getValueByKey(num2);
        if (Utils.isBlank(city)) {
            city = PhoneCityResource.getInstance().getValueByKey(num);
        }

        if (Utils.isBlank(city)) {
            return DEFAULT_STR;
        }
        return city;
    }
}
