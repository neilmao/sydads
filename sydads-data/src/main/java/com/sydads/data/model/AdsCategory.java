package com.sydads.data.model;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 12/05/15
 */
public enum AdsCategory {

    RealEstate,
    Beauty,
    Other;

    public String getName() {

        String name;

        switch (this) {
            case RealEstate:
                name = "地产";
                break;
            case Beauty:
                name = "衣服/饰品/化妆品";
                break;
            case Other:
                name = "其它";
                break;
            default:
                name = "未分类";
        }
        return name;
    }
}
