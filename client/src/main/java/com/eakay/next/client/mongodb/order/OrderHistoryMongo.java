package com.eakay.next.client.mongodb.order;

import java.math.BigDecimal;
import java.util.Date;


public class OrderHistoryMongo {

    private Integer id;

    private Integer customerid;

    private Integer carid;

    private Integer merchantid;

    private Integer pricetypeid;

    private String pricetypetablename;

    private String orderstatus;

    private String suborderstatus;

    private Date createdtime;

    private BigDecimal totalcost;

    private String returncarconfirm;

    /**
     * 是否删除   0-未删除  1-已删除
     */
    private Byte deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Integer getPricetypeid() {
        return pricetypeid;
    }

    public void setPricetypeid(Integer pricetypeid) {
        this.pricetypeid = pricetypeid;
    }

    public String getPricetypetablename() {
        return pricetypetablename;
    }

    public void setPricetypetablename(String pricetypetablename) {
        this.pricetypetablename = pricetypetablename;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getSuborderstatus() {
        return suborderstatus;
    }

    public void setSuborderstatus(String suborderstatus) {
        this.suborderstatus = suborderstatus;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public BigDecimal getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(BigDecimal totalcost) {
        this.totalcost = totalcost;
    }

    public String getReturncarconfirm() {
        return returncarconfirm;
    }

    public void setReturncarconfirm(String returncarconfirm) {
        this.returncarconfirm = returncarconfirm;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}