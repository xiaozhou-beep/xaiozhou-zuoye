package com.fh.model;

public enum ResponseEnum {
    OK(200,"操作成功"),
    ERROR(500,"操作失败"),
    PHONE_NUMBER_IS_NULL(505,"手机号为空"),
    MEMBER_INFO_IS_NULL(506,"会员信息为空"),
    MEMBER_USERNAME_IS_NULL(507,"会员用户名为空"),
    MEMBER_PASSWORD_IS_NULL(508,"会员密码为空"),
    MEMBER_PHONE_NUMBER_IS_NULL(509,"会员手机号为空"),
    MEMBER_PHONE_NUMBER_IS_ILLEGAL(510,"会员手机号不合法"),
    VERIFY_CODE_IS_NULL(511,"验证码为空"),
    VERIFY_CODE_IS_EXPIRED(512,"验证码无效"),
    VERIFY_CODE_IS_ERROR(513,"验证码错误"),
    MEMBER_USERNAME_IS_EXISTED(514,"用户名已存在"),
    MEMBER_PHONE_NUMBER_IS_USED(515,"手机号已注册"),
    MEMBER_LOGINNAME_IS_NULL(516,"会员登录名为空"),
    MEMBER_NOT_EXISTED(517,"会员不存在"),
    MEMBER_PASSWORD_ERROR(518,"密码错误"),
    TOKEN_IS_NULL(519,"请求头中token信息为空"),
    TOKEN_IS_SHORT_OF(520,"请求头中token信息不完整"),
    TOKEN_IS_CHANGED(521,"请求头中token信息被篡改"),
    TOKEN_IS_EXPIRED(522,"登录信息已过期"),
    TOKEN_VERIFY_ERROR(523,"验证token失败"),
    TOKEN_IS_PRODUCT_NULL(525,"商品id为空"),
    PRODUCT_IS_Cart_NULL(526,"购物车不存在"),
    PRODUCT_IS_NULL(527,"商品不存在购物车"),
    PRODUCT_IS__sockt_NULL(528,"购物车中选中的商品库存都不足"),
    PRODUCT_checked__sockt_NULL(529,"你还没选中商品"),
    ORDER_PAYLOG_IS_NULL(530,"商品的支付日志为空"),
    UUID_REDIS_IS_NULL(531,"订单幂等性token为空"),
    UUID_ORDER_PRODUCT(532,"订单已经提交过了"),
    PWD_ERROR(403,"密码");


    private int code;

    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
