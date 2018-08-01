package com.eakay.next.client.formbean.wiki;

import javax.validation.constraints.NotNull;

/**
 * Created by 张亚鹏 on 2018/6/21.
 */
public class WikiCategory4ListFormBean {


    @NotNull
    private Integer merchantId;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}
