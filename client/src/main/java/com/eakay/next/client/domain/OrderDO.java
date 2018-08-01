package com.eakay.next.client.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "`order`")
public class OrderDO {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联用户ID
     */
    @Column(name = "customerId")
    private Integer customerid;

    /**
     * 租赁车辆ID
     */
    @Column(name = "carId")
    private Integer carid;

    /**
     * 商户ID
     */
    @Column(name = "merchantId")
    private Integer merchantid;

    /**
     * 关联套餐表id(merchant_price表id)
     */
    @Column(name = "priceTypeId")
    private Integer pricetypeid;

    @Column(name = "priceTypeTableName")
    private String pricetypetablename;

    /**
     * 订单状态（已付费、已取消、已取车、已还车, 已预约）
     */
    @Column(name = "orderStatus")
    private String orderstatus;

    /**
     * 订单子状态（正常）
     */
    @Column(name = "subOrderStatus")
    private String suborderstatus;

    @Column(name = "createdTime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdtime;

    /**
     * 取车公里数
     */
    @Column(name = "kmsForGet")
    private Float kmsforget;

    @Column(name = "imgForGet")
    private String imgforget;

    @Column(name = "socForGet")
    private BigDecimal socforget;

    /**
     * 还车公里数
     */
    @Column(name = "kmsForReturn")
    private Float kmsforreturn;

    @Column(name = "imgForReturn")
    private String imgforreturn;

    /**
     * 租赁费用
     */
    @Column(name = "useCost")
    private BigDecimal usecost;

    /**
     * 总费用
     */
    @Column(name = "totalCost")
    private BigDecimal totalcost;

    @Column(name = "backCost")
    private BigDecimal backcost;

    @Column(name = "backDescribe")
    private String backdescribe;

    @Column(name = "socForReturn")
    private BigDecimal socforreturn;

    /**
     * 计划取车时间
     */
    @Column(name = "schemingGetTime")
    private Date scheminggettime;

    /**
     * 计划还车时间
     */
    @Column(name = "schemingReturnTime")
    private Date schemingreturntime;

    /**
     * 实际取车时间
     */
    @Column(name = "realityGetTime")
    private Date realitygettime;

    /**
     * 实际还车时间
     */
    @Column(name = "realityReturnTime")
    private Date realityreturntime;

    /**
     * 计划取车租赁点
     */
    @Column(name = "schemingGetSiteId")
    private Integer scheminggetsiteid;

    /**
     * 计划还车租赁点
     */
    @Column(name = "schemingReturnSiteId")
    private Integer schemingreturnsiteid;

    /**
     * 实际取车租赁点
     */
    @Column(name = "relityGetSiteId")
    private Integer relitygetsiteid;

    /**
     * 实际还车租赁点
     */
    @Column(name = "relityReturnSiteId")
    private Integer relityreturnsiteid;

    @Column(name = "earlyGetCost")
    private BigDecimal earlygetcost;

    @Column(name = "earlyReturnCost")
    private BigDecimal earlyreturncost;

    @Column(name = "laterGetCost")
    private BigDecimal latergetcost;

    @Column(name = "laterReturnCost")
    private BigDecimal laterreturncost;

    /**
     * 其他收费
     */
    @Column(name = "otherCost")
    private BigDecimal othercost;

    /**
     * 保险费用
     */
    @Column(name = "insuranceCost")
    private BigDecimal insurancecost;

    /**
     * 套餐名称
     */
    @Column(name = "priceTypeName")
    private String pricetypename;

    /**
     * 取车状态
     */
    @Column(name = "getCarStatus")
    private String getcarstatus;

    /**
     * 还车状态
     */
    @Column(name = "returnCarStatus")
    private String returncarstatus;

    /**
     * 客户同意,只有一种状态.
     */
    @Column(name = "fetchCarConfirm")
    private String fetchcarconfirm;

    /**
     * 超出公里数
     */
    @Column(name = "perKms")
    private Float perkms;

    /**
     * 超出公里数费用
     */
    @Column(name = "perKmsCost")
    private BigDecimal perkmscost;

    /**
     * 取车经办人
     */
    @Column(name = "menForGet")
    private String menforget;

    /**
     * 还车经办人
     */
    @Column(name = "menForReturn")
    private String menforreturn;

    /**
     * 收费经办人
     */
    @Column(name = "menForCharge")
    private String menforcharge;

    /**
     * 等待审查/已审查
     */
    @Column(name = "returnCarConfirm")
    private String returncarconfirm;

    @Column(name = "oldId")
    private Integer oldid;

    @Column(name = "otherDescribe")
    private String otherdescribe;

    /**
     * 保证金
     */
    @Column(name = "moneyOfassure")
    private BigDecimal moneyofassure;

    /**
     * 付款商家账户id
     */
    @Column(name = "merchantAccountId")
    private Integer merchantaccountid;

    /**
     * 客户表名
     */
    @Column(name = "customerTable")
    private String customertable;

    /**
     * 订单类型（1：普通用户租车，2：个人长租，3：车辆调度，4：公务用车，5：政企分时）
     */
    @Column(name = "orderType")
    private Integer ordertype;

    /**
     * 订单描述
     */
    @Column(name = "orderDescribe")
    private String orderdescribe;

    /**
     * 取车续航里程
     */
    @Column(name = "surplusKmsForGet")
    private Float surpluskmsforget;

    /**
     * 还车续航里程
     */
    @Column(name = "surplusKmsForReturn")
    private Float surpluskmsforreturn;

    /**
     * 交易记录小票
     */
    private String ticket;

    /**
     * 支付方式
     */
    private String payment;

    /**
     * 核对人
     */
    @Column(name = "checkUser")
    private String checkuser;

    /**
     * 核对描述
     */
    @Column(name = "checkDescribe")
    private String checkdescribe;

    /**
     * 维修费用
     */
    @Column(name = "maintenanceCost")
    private BigDecimal maintenancecost;

    /**
     * 优惠卷Id
     */
    @Column(name = "couponId")
    private Integer couponid;

    /**
     * 优惠费用
     */
    @Column(name = "couponCost")
    private BigDecimal couponcost;

    /**
     * 审核还车时间
     */
    @Column(name = "checkReturnTime")
    private Date checkreturntime;

    /**
     * 审核员工ID
     */
    @Column(name = "checkUserId")
    private Integer checkuserid;

    /**
     * 是否已开发票（0 未开 1 已开）
     */
    @Column(name = "isFp")
    private Integer isfp;

    /**
     * 合同编号
     */
    @Column(name = "orderNO")
    private String orderno;

    private Integer cs;

    /**
     * 2小时内未发送为0，2小时内发送过为1,24小时内发送过为2
     */
    @Column(name = "UnpayMsg")
    private Integer unpaymsg;

    /**
     * 是否可以使用优惠卷（1：可以 0：不可以）
     */
    @Column(name = "isUseCoupon")
    private Byte isusecoupon;

    /**
     * 使用易开币付费金额
     */
    @Column(name = "eakayMoney")
    private BigDecimal eakaymoney;

    /**
     * 线上支付金额
     */
    @Column(name = "payMoney")
    private BigDecimal paymoney;

    /**
     * 是否购买保险（0:没有购买，1:购买过保险）
     */
    private Integer insurance;

    /**
     * 付费时间
     */
    @Column(name = "paymentTime")
    private Date paymenttime;

    /**
     * 过路费
     */
    @Column(name = "highwayCost")
    private BigDecimal highwaycost;

    /**
     * 保险费用
     */
    @Column(name = "suranceCost")
    private BigDecimal surancecost;

    /**
     * 是否有充电线和行驶证
     */
    private String memo;

    /**
     * 是否删除   0-未删除  1-已删除
     */
    private Byte deleted;

    /**
     * 政企平台 或 其他平台 外部ID
     */
    @Column(name = "companyId")
    private Long companyid;

    /**
     * 惩罚费用
     */
    @Column(name = "penalty_cost")
    private BigDecimal penaltyCost;

    /**
     * 是否为低价调度
     */
    @Column(name = "calFlag")
    private Integer calflag;

    /**
     * 定单标记0:老订单 1:新订单
     */
    @Column(name = "orderFlag")
    private Byte orderflag;

    /**
     * 是否免审订单0、否 1、是
     */
    @Column(name = "isFreeOrder")
    private Integer isfreeorder;

    /**
     * 是否自助还车 1是，0否,2免审还车
     */
    @Column(name = "isSelfReturnCar")
    private Byte isselfreturncar;

    /**
     * 备注(用于客服还车审核 备注信息)
     */
    private String remark;

    /**
     * 订单来源：1正常用户，3预授权，4小程序，5:h5
     */
    private Byte source;

    /**
     * 客服订单处理状态： 0 未处理 1 被忽略 2 处理中 3 已处理
     */
    @Column(name = "workOperateStatus")
    private Integer workoperatestatus;

    /**
     * 客服备注
     */
    @Column(name = "customerServerComments")
    private String customerservercomments;

    /**
     * 自助订单退回标签
     */
    @Column(name = "autoSelfOrderTagContent")
    private String autoselfordertagcontent;

    /**
     * 自助还车  客服忽略的标签
     */
    @Column(name = "workOrderSetId")
    private Integer workordersetid;

    /**
     * 客服在merchantUser表的id
     */
    @Column(name = "merchantUserId")
    @JsonIgnore
    private Integer merchantuserid;

    /**
     * scs_user表主键  客服记录表
     */
    @Column(name = "scsUserId")
    @JsonIgnore
    private Integer scsuserid;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关联用户ID
     *
     * @return customerId - 关联用户ID
     */
    public Integer getCustomerid() {
        return customerid;
    }

    /**
     * 设置关联用户ID
     *
     * @param customerid 关联用户ID
     */
    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    /**
     * 获取租赁车辆ID
     *
     * @return carId - 租赁车辆ID
     */
    public Integer getCarid() {
        return carid;
    }

    /**
     * 设置租赁车辆ID
     *
     * @param carid 租赁车辆ID
     */
    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    /**
     * 获取商户ID
     *
     * @return merchantId - 商户ID
     */
    public Integer getMerchantid() {
        return merchantid;
    }

    /**
     * 设置商户ID
     *
     * @param merchantid 商户ID
     */
    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * 获取关联套餐表id(merchant_price表id)
     *
     * @return priceTypeId - 关联套餐表id(merchant_price表id)
     */
    public Integer getPricetypeid() {
        return pricetypeid;
    }

    /**
     * 设置关联套餐表id(merchant_price表id)
     *
     * @param pricetypeid 关联套餐表id(merchant_price表id)
     */
    public void setPricetypeid(Integer pricetypeid) {
        this.pricetypeid = pricetypeid;
    }

    /**
     * @return priceTypeTableName
     */
    public String getPricetypetablename() {
        return pricetypetablename;
    }

    /**
     * @param pricetypetablename
     */
    public void setPricetypetablename(String pricetypetablename) {
        this.pricetypetablename = pricetypetablename;
    }

    /**
     * 获取订单状态（已付费、已取消、已取车、已还车, 已预约）
     *
     * @return orderStatus - 订单状态（已付费、已取消、已取车、已还车, 已预约）
     */
    public String getOrderstatus() {
        return orderstatus;
    }

    /**
     * 设置订单状态（已付费、已取消、已取车、已还车, 已预约）
     *
     * @param orderstatus 订单状态（已付费、已取消、已取车、已还车, 已预约）
     */
    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    /**
     * 获取订单子状态（正常）
     *
     * @return subOrderStatus - 订单子状态（正常）
     */
    public String getSuborderstatus() {
        return suborderstatus;
    }

    /**
     * 设置订单子状态（正常）
     *
     * @param suborderstatus 订单子状态（正常）
     */
    public void setSuborderstatus(String suborderstatus) {
        this.suborderstatus = suborderstatus;
    }

    /**
     * @return createdTime
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * @param createdtime
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * 获取取车公里数
     *
     * @return kmsForGet - 取车公里数
     */
    public Float getKmsforget() {
        return kmsforget;
    }

    /**
     * 设置取车公里数
     *
     * @param kmsforget 取车公里数
     */
    public void setKmsforget(Float kmsforget) {
        this.kmsforget = kmsforget;
    }

    /**
     * @return imgForGet
     */
    public String getImgforget() {
        return imgforget;
    }

    /**
     * @param imgforget
     */
    public void setImgforget(String imgforget) {
        this.imgforget = imgforget;
    }

    /**
     * @return socForGet
     */
    public BigDecimal getSocforget() {
        return socforget;
    }

    /**
     * @param socforget
     */
    public void setSocforget(BigDecimal socforget) {
        this.socforget = socforget;
    }

    /**
     * 获取还车公里数
     *
     * @return kmsForReturn - 还车公里数
     */
    public Float getKmsforreturn() {
        return kmsforreturn;
    }

    /**
     * 设置还车公里数
     *
     * @param kmsforreturn 还车公里数
     */
    public void setKmsforreturn(Float kmsforreturn) {
        this.kmsforreturn = kmsforreturn;
    }

    /**
     * @return imgForReturn
     */
    public String getImgforreturn() {
        return imgforreturn;
    }

    /**
     * @param imgforreturn
     */
    public void setImgforreturn(String imgforreturn) {
        this.imgforreturn = imgforreturn;
    }

    /**
     * 获取租赁费用
     *
     * @return useCost - 租赁费用
     */
    public BigDecimal getUsecost() {
        return usecost;
    }

    /**
     * 设置租赁费用
     *
     * @param usecost 租赁费用
     */
    public void setUsecost(BigDecimal usecost) {
        this.usecost = usecost;
    }

    /**
     * 获取总费用
     *
     * @return totalCost - 总费用
     */
    public BigDecimal getTotalcost() {
        return totalcost;
    }

    /**
     * 设置总费用
     *
     * @param totalcost 总费用
     */
    public void setTotalcost(BigDecimal totalcost) {
        this.totalcost = totalcost;
    }

    /**
     * @return backCost
     */
    public BigDecimal getBackcost() {
        return backcost;
    }

    /**
     * @param backcost
     */
    public void setBackcost(BigDecimal backcost) {
        this.backcost = backcost;
    }

    /**
     * @return backDescribe
     */
    public String getBackdescribe() {
        return backdescribe;
    }

    /**
     * @param backdescribe
     */
    public void setBackdescribe(String backdescribe) {
        this.backdescribe = backdescribe;
    }

    /**
     * @return socForReturn
     */
    public BigDecimal getSocforreturn() {
        return socforreturn;
    }

    /**
     * @param socforreturn
     */
    public void setSocforreturn(BigDecimal socforreturn) {
        this.socforreturn = socforreturn;
    }

    /**
     * 获取计划取车时间
     *
     * @return schemingGetTime - 计划取车时间
     */
    public Date getScheminggettime() {
        return scheminggettime;
    }

    /**
     * 设置计划取车时间
     *
     * @param scheminggettime 计划取车时间
     */
    public void setScheminggettime(Date scheminggettime) {
        this.scheminggettime = scheminggettime;
    }

    /**
     * 获取计划还车时间
     *
     * @return schemingReturnTime - 计划还车时间
     */
    public Date getSchemingreturntime() {
        return schemingreturntime;
    }

    /**
     * 设置计划还车时间
     *
     * @param schemingreturntime 计划还车时间
     */
    public void setSchemingreturntime(Date schemingreturntime) {
        this.schemingreturntime = schemingreturntime;
    }

    /**
     * 获取实际取车时间
     *
     * @return realityGetTime - 实际取车时间
     */
    public Date getRealitygettime() {
        return realitygettime;
    }

    /**
     * 设置实际取车时间
     *
     * @param realitygettime 实际取车时间
     */
    public void setRealitygettime(Date realitygettime) {
        this.realitygettime = realitygettime;
    }

    /**
     * 获取实际还车时间
     *
     * @return realityReturnTime - 实际还车时间
     */
    public Date getRealityreturntime() {
        return realityreturntime;
    }

    /**
     * 设置实际还车时间
     *
     * @param realityreturntime 实际还车时间
     */
    public void setRealityreturntime(Date realityreturntime) {
        this.realityreturntime = realityreturntime;
    }

    /**
     * 获取计划取车租赁点
     *
     * @return schemingGetSiteId - 计划取车租赁点
     */
    public Integer getScheminggetsiteid() {
        return scheminggetsiteid;
    }

    /**
     * 设置计划取车租赁点
     *
     * @param scheminggetsiteid 计划取车租赁点
     */
    public void setScheminggetsiteid(Integer scheminggetsiteid) {
        this.scheminggetsiteid = scheminggetsiteid;
    }

    /**
     * 获取计划还车租赁点
     *
     * @return schemingReturnSiteId - 计划还车租赁点
     */
    public Integer getSchemingreturnsiteid() {
        return schemingreturnsiteid;
    }

    /**
     * 设置计划还车租赁点
     *
     * @param schemingreturnsiteid 计划还车租赁点
     */
    public void setSchemingreturnsiteid(Integer schemingreturnsiteid) {
        this.schemingreturnsiteid = schemingreturnsiteid;
    }

    /**
     * 获取实际取车租赁点
     *
     * @return relityGetSiteId - 实际取车租赁点
     */
    public Integer getRelitygetsiteid() {
        return relitygetsiteid;
    }

    /**
     * 设置实际取车租赁点
     *
     * @param relitygetsiteid 实际取车租赁点
     */
    public void setRelitygetsiteid(Integer relitygetsiteid) {
        this.relitygetsiteid = relitygetsiteid;
    }

    /**
     * 获取实际还车租赁点
     *
     * @return relityReturnSiteId - 实际还车租赁点
     */
    public Integer getRelityreturnsiteid() {
        return relityreturnsiteid;
    }

    /**
     * 设置实际还车租赁点
     *
     * @param relityreturnsiteid 实际还车租赁点
     */
    public void setRelityreturnsiteid(Integer relityreturnsiteid) {
        this.relityreturnsiteid = relityreturnsiteid;
    }

    /**
     * @return earlyGetCost
     */
    public BigDecimal getEarlygetcost() {
        return earlygetcost;
    }

    /**
     * @param earlygetcost
     */
    public void setEarlygetcost(BigDecimal earlygetcost) {
        this.earlygetcost = earlygetcost;
    }

    /**
     * @return earlyReturnCost
     */
    public BigDecimal getEarlyreturncost() {
        return earlyreturncost;
    }

    /**
     * @param earlyreturncost
     */
    public void setEarlyreturncost(BigDecimal earlyreturncost) {
        this.earlyreturncost = earlyreturncost;
    }

    /**
     * @return laterGetCost
     */
    public BigDecimal getLatergetcost() {
        return latergetcost;
    }

    /**
     * @param latergetcost
     */
    public void setLatergetcost(BigDecimal latergetcost) {
        this.latergetcost = latergetcost;
    }

    /**
     * @return laterReturnCost
     */
    public BigDecimal getLaterreturncost() {
        return laterreturncost;
    }

    /**
     * @param laterreturncost
     */
    public void setLaterreturncost(BigDecimal laterreturncost) {
        this.laterreturncost = laterreturncost;
    }

    /**
     * 获取其他收费
     *
     * @return otherCost - 其他收费
     */
    public BigDecimal getOthercost() {
        return othercost;
    }

    /**
     * 设置其他收费
     *
     * @param othercost 其他收费
     */
    public void setOthercost(BigDecimal othercost) {
        this.othercost = othercost;
    }

    /**
     * 获取保险费用
     *
     * @return insuranceCost - 保险费用
     */
    public BigDecimal getInsurancecost() {
        return insurancecost;
    }

    /**
     * 设置保险费用
     *
     * @param insurancecost 保险费用
     */
    public void setInsurancecost(BigDecimal insurancecost) {
        this.insurancecost = insurancecost;
    }

    /**
     * 获取套餐名称
     *
     * @return priceTypeName - 套餐名称
     */
    public String getPricetypename() {
        return pricetypename;
    }

    /**
     * 设置套餐名称
     *
     * @param pricetypename 套餐名称
     */
    public void setPricetypename(String pricetypename) {
        this.pricetypename = pricetypename;
    }

    /**
     * 获取取车状态
     *
     * @return getCarStatus - 取车状态
     */
    public String getGetcarstatus() {
        return getcarstatus;
    }

    /**
     * 设置取车状态
     *
     * @param getcarstatus 取车状态
     */
    public void setGetcarstatus(String getcarstatus) {
        this.getcarstatus = getcarstatus;
    }

    /**
     * 获取还车状态
     *
     * @return returnCarStatus - 还车状态
     */
    public String getReturncarstatus() {
        return returncarstatus;
    }

    /**
     * 设置还车状态
     *
     * @param returncarstatus 还车状态
     */
    public void setReturncarstatus(String returncarstatus) {
        this.returncarstatus = returncarstatus;
    }

    /**
     * 获取客户同意,只有一种状态.
     *
     * @return fetchCarConfirm - 客户同意,只有一种状态.
     */
    public String getFetchcarconfirm() {
        return fetchcarconfirm;
    }

    /**
     * 设置客户同意,只有一种状态.
     *
     * @param fetchcarconfirm 客户同意,只有一种状态.
     */
    public void setFetchcarconfirm(String fetchcarconfirm) {
        this.fetchcarconfirm = fetchcarconfirm;
    }

    /**
     * 获取超出公里数
     *
     * @return perKms - 超出公里数
     */
    public Float getPerkms() {
        return perkms;
    }

    /**
     * 设置超出公里数
     *
     * @param perkms 超出公里数
     */
    public void setPerkms(Float perkms) {
        this.perkms = perkms;
    }

    /**
     * 获取超出公里数费用
     *
     * @return perKmsCost - 超出公里数费用
     */
    public BigDecimal getPerkmscost() {
        return perkmscost;
    }

    /**
     * 设置超出公里数费用
     *
     * @param perkmscost 超出公里数费用
     */
    public void setPerkmscost(BigDecimal perkmscost) {
        this.perkmscost = perkmscost;
    }

    /**
     * 获取取车经办人
     *
     * @return menForGet - 取车经办人
     */
    public String getMenforget() {
        return menforget;
    }

    /**
     * 设置取车经办人
     *
     * @param menforget 取车经办人
     */
    public void setMenforget(String menforget) {
        this.menforget = menforget;
    }

    /**
     * 获取还车经办人
     *
     * @return menForReturn - 还车经办人
     */
    public String getMenforreturn() {
        return menforreturn;
    }

    /**
     * 设置还车经办人
     *
     * @param menforreturn 还车经办人
     */
    public void setMenforreturn(String menforreturn) {
        this.menforreturn = menforreturn;
    }

    /**
     * 获取收费经办人
     *
     * @return menForCharge - 收费经办人
     */
    public String getMenforcharge() {
        return menforcharge;
    }

    /**
     * 设置收费经办人
     *
     * @param menforcharge 收费经办人
     */
    public void setMenforcharge(String menforcharge) {
        this.menforcharge = menforcharge;
    }

    /**
     * 获取等待审查/已审查
     *
     * @return returnCarConfirm - 等待审查/已审查
     */
    public String getReturncarconfirm() {
        return returncarconfirm;
    }

    /**
     * 设置等待审查/已审查
     *
     * @param returncarconfirm 等待审查/已审查
     */
    public void setReturncarconfirm(String returncarconfirm) {
        this.returncarconfirm = returncarconfirm;
    }

    /**
     * @return oldId
     */
    public Integer getOldid() {
        return oldid;
    }

    /**
     * @param oldid
     */
    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    /**
     * @return otherDescribe
     */
    public String getOtherdescribe() {
        return otherdescribe;
    }

    /**
     * @param otherdescribe
     */
    public void setOtherdescribe(String otherdescribe) {
        this.otherdescribe = otherdescribe;
    }

    /**
     * 获取保证金
     *
     * @return moneyOfassure - 保证金
     */
    public BigDecimal getMoneyofassure() {
        return moneyofassure;
    }

    /**
     * 设置保证金
     *
     * @param moneyofassure 保证金
     */
    public void setMoneyofassure(BigDecimal moneyofassure) {
        this.moneyofassure = moneyofassure;
    }

    /**
     * 获取付款商家账户id
     *
     * @return merchantAccountId - 付款商家账户id
     */
    public Integer getMerchantaccountid() {
        return merchantaccountid;
    }

    /**
     * 设置付款商家账户id
     *
     * @param merchantaccountid 付款商家账户id
     */
    public void setMerchantaccountid(Integer merchantaccountid) {
        this.merchantaccountid = merchantaccountid;
    }

    /**
     * 获取客户表名
     *
     * @return customerTable - 客户表名
     */
    public String getCustomertable() {
        return customertable;
    }

    /**
     * 设置客户表名
     *
     * @param customertable 客户表名
     */
    public void setCustomertable(String customertable) {
        this.customertable = customertable;
    }

    /**
     * 获取订单类型（1：普通用户租车，2：个人长租，3：车辆调度，4：公务用车，5：政企分时）
     *
     * @return orderType - 订单类型（1：普通用户租车，2：个人长租，3：车辆调度，4：公务用车，5：政企分时）
     */
    public Integer getOrdertype() {
        return ordertype;
    }

    /**
     * 设置订单类型（1：普通用户租车，2：个人长租，3：车辆调度，4：公务用车，5：政企分时）
     *
     * @param ordertype 订单类型（1：普通用户租车，2：个人长租，3：车辆调度，4：公务用车，5：政企分时）
     */
    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    /**
     * 获取订单描述
     *
     * @return orderDescribe - 订单描述
     */
    public String getOrderdescribe() {
        return orderdescribe;
    }

    /**
     * 设置订单描述
     *
     * @param orderdescribe 订单描述
     */
    public void setOrderdescribe(String orderdescribe) {
        this.orderdescribe = orderdescribe;
    }

    /**
     * 获取取车续航里程
     *
     * @return surplusKmsForGet - 取车续航里程
     */
    public Float getSurpluskmsforget() {
        return surpluskmsforget;
    }

    /**
     * 设置取车续航里程
     *
     * @param surpluskmsforget 取车续航里程
     */
    public void setSurpluskmsforget(Float surpluskmsforget) {
        this.surpluskmsforget = surpluskmsforget;
    }

    /**
     * 获取还车续航里程
     *
     * @return surplusKmsForReturn - 还车续航里程
     */
    public Float getSurpluskmsforreturn() {
        return surpluskmsforreturn;
    }

    /**
     * 设置还车续航里程
     *
     * @param surpluskmsforreturn 还车续航里程
     */
    public void setSurpluskmsforreturn(Float surpluskmsforreturn) {
        this.surpluskmsforreturn = surpluskmsforreturn;
    }

    /**
     * 获取交易记录小票
     *
     * @return ticket - 交易记录小票
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * 设置交易记录小票
     *
     * @param ticket 交易记录小票
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * 获取支付方式
     *
     * @return payment - 支付方式
     */
    public String getPayment() {
        return payment;
    }

    /**
     * 设置支付方式
     *
     * @param payment 支付方式
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * 获取核对人
     *
     * @return checkUser - 核对人
     */
    public String getCheckuser() {
        return checkuser;
    }

    /**
     * 设置核对人
     *
     * @param checkuser 核对人
     */
    public void setCheckuser(String checkuser) {
        this.checkuser = checkuser;
    }

    /**
     * 获取核对描述
     *
     * @return checkDescribe - 核对描述
     */
    public String getCheckdescribe() {
        return checkdescribe;
    }

    /**
     * 设置核对描述
     *
     * @param checkdescribe 核对描述
     */
    public void setCheckdescribe(String checkdescribe) {
        this.checkdescribe = checkdescribe;
    }

    /**
     * 获取维修费用
     *
     * @return maintenanceCost - 维修费用
     */
    public BigDecimal getMaintenancecost() {
        return maintenancecost;
    }

    /**
     * 设置维修费用
     *
     * @param maintenancecost 维修费用
     */
    public void setMaintenancecost(BigDecimal maintenancecost) {
        this.maintenancecost = maintenancecost;
    }

    /**
     * 获取优惠卷Id
     *
     * @return couponId - 优惠卷Id
     */
    public Integer getCouponid() {
        return couponid;
    }

    /**
     * 设置优惠卷Id
     *
     * @param couponid 优惠卷Id
     */
    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    /**
     * 获取优惠费用
     *
     * @return couponCost - 优惠费用
     */
    public BigDecimal getCouponcost() {
        return couponcost;
    }

    /**
     * 设置优惠费用
     *
     * @param couponcost 优惠费用
     */
    public void setCouponcost(BigDecimal couponcost) {
        this.couponcost = couponcost;
    }

    /**
     * 获取审核还车时间
     *
     * @return checkReturnTime - 审核还车时间
     */
    public Date getCheckreturntime() {
        return checkreturntime;
    }

    /**
     * 设置审核还车时间
     *
     * @param checkreturntime 审核还车时间
     */
    public void setCheckreturntime(Date checkreturntime) {
        this.checkreturntime = checkreturntime;
    }

    /**
     * 获取审核员工ID
     *
     * @return checkUserId - 审核员工ID
     */
    public Integer getCheckuserid() {
        return checkuserid;
    }

    /**
     * 设置审核员工ID
     *
     * @param checkuserid 审核员工ID
     */
    public void setCheckuserid(Integer checkuserid) {
        this.checkuserid = checkuserid;
    }

    /**
     * 获取是否已开发票（0 未开 1 已开）
     *
     * @return isFp - 是否已开发票（0 未开 1 已开）
     */
    public Integer getIsfp() {
        return isfp;
    }

    /**
     * 设置是否已开发票（0 未开 1 已开）
     *
     * @param isfp 是否已开发票（0 未开 1 已开）
     */
    public void setIsfp(Integer isfp) {
        this.isfp = isfp;
    }

    /**
     * 获取合同编号
     *
     * @return orderNO - 合同编号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置合同编号
     *
     * @param orderno 合同编号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    /**
     * @return cs
     */
    public Integer getCs() {
        return cs;
    }

    /**
     * @param cs
     */
    public void setCs(Integer cs) {
        this.cs = cs;
    }

    /**
     * 获取2小时内未发送为0，2小时内发送过为1,24小时内发送过为2
     *
     * @return UnpayMsg - 2小时内未发送为0，2小时内发送过为1,24小时内发送过为2
     */
    public Integer getUnpaymsg() {
        return unpaymsg;
    }

    /**
     * 设置2小时内未发送为0，2小时内发送过为1,24小时内发送过为2
     *
     * @param unpaymsg 2小时内未发送为0，2小时内发送过为1,24小时内发送过为2
     */
    public void setUnpaymsg(Integer unpaymsg) {
        this.unpaymsg = unpaymsg;
    }

    /**
     * 获取是否可以使用优惠卷（1：可以 0：不可以）
     *
     * @return isUseCoupon - 是否可以使用优惠卷（1：可以 0：不可以）
     */
    public Byte getIsusecoupon() {
        return isusecoupon;
    }

    /**
     * 设置是否可以使用优惠卷（1：可以 0：不可以）
     *
     * @param isusecoupon 是否可以使用优惠卷（1：可以 0：不可以）
     */
    public void setIsusecoupon(Byte isusecoupon) {
        this.isusecoupon = isusecoupon;
    }

    /**
     * 获取使用易开币付费金额
     *
     * @return eakayMoney - 使用易开币付费金额
     */
    public BigDecimal getEakaymoney() {
        return eakaymoney;
    }

    /**
     * 设置使用易开币付费金额
     *
     * @param eakaymoney 使用易开币付费金额
     */
    public void setEakaymoney(BigDecimal eakaymoney) {
        this.eakaymoney = eakaymoney;
    }

    /**
     * 获取线上支付金额
     *
     * @return payMoney - 线上支付金额
     */
    public BigDecimal getPaymoney() {
        return paymoney;
    }

    /**
     * 设置线上支付金额
     *
     * @param paymoney 线上支付金额
     */
    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    /**
     * 获取是否购买保险（0:没有购买，1:购买过保险）
     *
     * @return insurance - 是否购买保险（0:没有购买，1:购买过保险）
     */
    public Integer getInsurance() {
        return insurance;
    }

    /**
     * 设置是否购买保险（0:没有购买，1:购买过保险）
     *
     * @param insurance 是否购买保险（0:没有购买，1:购买过保险）
     */
    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    /**
     * 获取付费时间
     *
     * @return paymentTime - 付费时间
     */
    public Date getPaymenttime() {
        return paymenttime;
    }

    /**
     * 设置付费时间
     *
     * @param paymenttime 付费时间
     */
    public void setPaymenttime(Date paymenttime) {
        this.paymenttime = paymenttime;
    }

    /**
     * 获取过路费
     *
     * @return highwayCost - 过路费
     */
    public BigDecimal getHighwaycost() {
        return highwaycost;
    }

    /**
     * 设置过路费
     *
     * @param highwaycost 过路费
     */
    public void setHighwaycost(BigDecimal highwaycost) {
        this.highwaycost = highwaycost;
    }

    /**
     * 获取保险费用
     *
     * @return suranceCost - 保险费用
     */
    public BigDecimal getSurancecost() {
        return surancecost;
    }

    /**
     * 设置保险费用
     *
     * @param surancecost 保险费用
     */
    public void setSurancecost(BigDecimal surancecost) {
        this.surancecost = surancecost;
    }

    /**
     * 获取是否有充电线和行驶证
     *
     * @return memo - 是否有充电线和行驶证
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置是否有充电线和行驶证
     *
     * @param memo 是否有充电线和行驶证
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取是否删除   0-未删除  1-已删除
     *
     * @return deleted - 是否删除   0-未删除  1-已删除
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除   0-未删除  1-已删除
     *
     * @param deleted 是否删除   0-未删除  1-已删除
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取政企平台 或 其他平台 外部ID
     *
     * @return companyId - 政企平台 或 其他平台 外部ID
     */
    public Long getCompanyid() {
        return companyid;
    }

    /**
     * 设置政企平台 或 其他平台 外部ID
     *
     * @param companyid 政企平台 或 其他平台 外部ID
     */
    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    /**
     * 获取惩罚费用
     *
     * @return penalty_cost - 惩罚费用
     */
    public BigDecimal getPenaltyCost() {
        return penaltyCost;
    }

    /**
     * 设置惩罚费用
     *
     * @param penaltyCost 惩罚费用
     */
    public void setPenaltyCost(BigDecimal penaltyCost) {
        this.penaltyCost = penaltyCost;
    }

    /**
     * 获取是否为低价调度
     *
     * @return calFlag - 是否为低价调度
     */
    public Integer getCalflag() {
        return calflag;
    }

    /**
     * 设置是否为低价调度
     *
     * @param calflag 是否为低价调度
     */
    public void setCalflag(Integer calflag) {
        this.calflag = calflag;
    }

    /**
     * 获取定单标记0:老订单 1:新订单
     *
     * @return orderFlag - 定单标记0:老订单 1:新订单
     */
    public Byte getOrderflag() {
        return orderflag;
    }

    /**
     * 设置定单标记0:老订单 1:新订单
     *
     * @param orderflag 定单标记0:老订单 1:新订单
     */
    public void setOrderflag(Byte orderflag) {
        this.orderflag = orderflag;
    }

    /**
     * 获取是否免审订单0、否 1、是
     *
     * @return isFreeOrder - 是否免审订单0、否 1、是
     */
    public Integer getIsfreeorder() {
        return isfreeorder;
    }

    /**
     * 设置是否免审订单0、否 1、是
     *
     * @param isfreeorder 是否免审订单0、否 1、是
     */
    public void setIsfreeorder(Integer isfreeorder) {
        this.isfreeorder = isfreeorder;
    }

    /**
     * 获取是否自助还车 1是，0否,2免审还车
     *
     * @return isSelfReturnCar - 是否自助还车 1是，0否,2免审还车
     */
    public Byte getIsselfreturncar() {
        return isselfreturncar;
    }

    /**
     * 设置是否自助还车 1是，0否,2免审还车
     *
     * @param isselfreturncar 是否自助还车 1是，0否,2免审还车
     */
    public void setIsselfreturncar(Byte isselfreturncar) {
        this.isselfreturncar = isselfreturncar;
    }

    /**
     * 获取备注(用于客服还车审核 备注信息)
     *
     * @return remark - 备注(用于客服还车审核 备注信息)
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注(用于客服还车审核 备注信息)
     *
     * @param remark 备注(用于客服还车审核 备注信息)
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取订单来源：1正常用户，3预授权，4小程序，5:h5
     *
     * @return source - 订单来源：1正常用户，3预授权，4小程序，5:h5
     */
    public Byte getSource() {
        return source;
    }

    /**
     * 设置订单来源：1正常用户，3预授权，4小程序，5:h5
     *
     * @param source 订单来源：1正常用户，3预授权，4小程序，5:h5
     */
    public void setSource(Byte source) {
        this.source = source;
    }

    /**
     * 获取客服订单处理状态： 0 未处理 1 被忽略 2 处理中 3 已处理
     *
     * @return workOperateStatus - 客服订单处理状态： 0 未处理 1 被忽略 2 处理中 3 已处理
     */
    public Integer getWorkoperatestatus() {
        return workoperatestatus;
    }

    /**
     * 设置客服订单处理状态： 0 未处理 1 被忽略 2 处理中 3 已处理
     *
     * @param workoperatestatus 客服订单处理状态： 0 未处理 1 被忽略 2 处理中 3 已处理
     */
    public void setWorkoperatestatus(Integer workoperatestatus) {
        this.workoperatestatus = workoperatestatus;
    }

    /**
     * 获取客服备注
     *
     * @return customerServerComments - 客服备注
     */
    public String getCustomerservercomments() {
        return customerservercomments;
    }

    /**
     * 设置客服备注
     *
     * @param customerservercomments 客服备注
     */
    public void setCustomerservercomments(String customerservercomments) {
        this.customerservercomments = customerservercomments;
    }

    /**
     * 获取自助订单退回标签
     *
     * @return autoSelfOrderTagContent - 自助订单退回标签
     */
    public String getAutoselfordertagcontent() {
        return autoselfordertagcontent;
    }

    /**
     * 设置自助订单退回标签
     *
     * @param autoselfordertagcontent 自助订单退回标签
     */
    public void setAutoselfordertagcontent(String autoselfordertagcontent) {
        this.autoselfordertagcontent = autoselfordertagcontent;
    }

    /**
     * 获取自助还车  客服忽略的标签
     *
     * @return workOrderSetId - 自助还车  客服忽略的标签
     */
    public Integer getWorkordersetid() {
        return workordersetid;
    }

    /**
     * 设置自助还车  客服忽略的标签
     *
     * @param workordersetid 自助还车  客服忽略的标签
     */
    public void setWorkordersetid(Integer workordersetid) {
        this.workordersetid = workordersetid;
    }

    /**
     * 获取客服在merchantUser表的id
     *
     * @return merchantUserId - 客服在merchantUser表的id
     */
    public Integer getMerchantuserid() {
        return merchantuserid;
    }

    /**
     * 设置客服在merchantUser表的id
     *
     * @param merchantuserid 客服在merchantUser表的id
     */
    public void setMerchantuserid(Integer merchantuserid) {
        this.merchantuserid = merchantuserid;
    }

    /**
     * 获取scs_user表主键  客服记录表
     *
     * @return scsUserId - scs_user表主键  客服记录表
     */
    public Integer getScsuserid() {
        return scsuserid;
    }

    /**
     * 设置scs_user表主键  客服记录表
     *
     * @param scsuserid scs_user表主键  客服记录表
     */
    public void setScsuserid(Integer scsuserid) {
        this.scsuserid = scsuserid;
    }
}