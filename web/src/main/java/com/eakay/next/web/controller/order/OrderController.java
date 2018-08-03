package com.eakay.next.web.controller.order;

import com.eakay.next.biz.service.order.OrderService;
import com.eakay.next.biz.service.wiki.WikiCategoryService;
import com.eakay.next.client.domain.OrderDO;
import com.eakay.next.client.mongodb.order.OrderHistoryMongo;
import com.eakay.next.client.util.response.ResponseObject;
import com.eakay.next.client.util.response.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WikiCategoryService wikiCategoryService;

    /**
     * 新增订单
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseObject add(@RequestParam("customerId") Integer customerId,
                              @RequestParam("carId") Integer carId) {
            OrderDO orderDO = new OrderDO();
            orderDO.setCustomerid(customerId);
            orderDO.setCarid(carId);
            orderDO.setMerchantid(11);
            orderDO.setPricetypeid(140);
            orderDO.setPricetypename("merchant_price");
            orderDO.setOrderstatus("已预约");
            orderDO.setSuborderstatus("正常");
            orderDO.setCreatedtime(new Date());
            orderDO.setKmsforget((float) 56789);
            orderDO.setImgforget("123");
            orderDO.setSocforget(new BigDecimal("75.00"));
            orderDO.setKmsforreturn((float) 676767);
            orderDO.setImgforreturn("789");
            orderDO.setUsecost(new BigDecimal("0"));
            orderDO.setTotalcost(new BigDecimal("15"));
            orderDO.setBackcost(new BigDecimal("0"));
            orderDO.setBackdescribe("未知");
            orderDO.setSocforreturn(new BigDecimal("0"));
            orderDO.setScheminggettime(new Date());
            orderDO.setSchemingreturntime(new Date());
            orderDO.setRealitygettime(new Date());
            orderDO.setRealityreturntime(new Date());
            orderDO.setScheminggetsiteid(267);
            orderDO.setSchemingreturnsiteid(789);
            orderDO.setRelitygetsiteid(267);
            orderDO.setRelityreturnsiteid(789);
            orderDO.setEarlygetcost(BigDecimal.ZERO);
            orderDO.setEarlyreturncost(BigDecimal.ZERO);
            orderDO.setLatergetcost(BigDecimal.ZERO);
            orderDO.setLaterreturncost(BigDecimal.ZERO);
            orderDO.setOthercost(BigDecimal.ZERO);
            orderDO.setInsurancecost(BigDecimal.ZERO);
            orderDO.setPricetypename("芜湖");
            orderDO.setFetchcarconfirm("客户统一");
            orderDO.setPerkms((float) 0);
            orderDO.setPerkmscost(BigDecimal.ZERO);
            orderDO.setMenforget("小小明");
            orderDO.setMenforget("阿三");
            orderDO.setReturncarconfirm("已开门");
            orderDO.setMoneyofassure(BigDecimal.ZERO);
            orderDO.setCustomertable("customer");
            orderDO.setOrdertype(1);
            orderDO.setOrderdescribe("");
            orderDO.setSurpluskmsforget((float) 80);
            orderDO.setSurpluskmsforreturn((float) 0);
            orderDO.setPayment("网络付费");
            orderDO.setMaintenancecost(BigDecimal.ZERO);
            orderDO.setCouponcost(BigDecimal.ZERO);
            orderDO.setIsfp(0);
            orderDO.setUnpaymsg(1);
            orderDO.setIsusecoupon((byte) 1);
            orderDO.setInsurancecost(new BigDecimal("1"));
            orderDO.setHighwaycost(BigDecimal.ZERO);
            orderDO.setSurancecost(BigDecimal.ZERO);
            orderDO.setDeleted((byte) 0);
            orderDO.setPenaltyCost(BigDecimal.ZERO);
            orderDO.setCalflag(0);
            orderDO.setIsfreeorder(0);
            orderDO.setIsselfreturncar((byte) 0);
            orderDO.setRemark("阿三开饭店了");
            orderDO.setSource((byte) 1);
            orderDO.setWorkoperatestatus(3);
            orderDO.setAutoselfordertagcontent("刚好九块九");
            orderDO.setWorkordersetid(0);
            orderDO.setScsuserid(55);

            orderService.add(orderDO);

            return ResponseUtil.getOK(orderDO.getId());


    }

    /**
     * 取消订单
     * @return
     */
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    public ResponseObject cancelOrder(@RequestParam("orderId") Integer orderId,
                                      @RequestParam("flag") Integer flag) {

            orderService.cancelOrder(orderId, flag);

            orderService.putDataToMongo(orderId);
            return ResponseUtil.getOK();

    }

    /**
     * 申请还车
     * @return
     */
    @RequestMapping(value = "/returnCar", method = RequestMethod.POST)
    public ResponseObject returnCar(@RequestParam("orderId") Integer orderId) {
            orderService.returnCar(orderId);

            return ResponseUtil.getOK();

    }

    /**
     * 订单已支付
     * @return
     */
    @RequestMapping(value = "/hasPayed", method = RequestMethod.POST)
    public ResponseObject hasPayed(@RequestParam("orderId") Integer orderId,
                                   @RequestParam(value = "flag", defaultValue = "1") Integer flag) {
            orderService.hasPayed(orderId, flag);

            orderService.putDataToMongo(orderId);
            return ResponseUtil.getOK();

    }


    /**
     * 当前订单
     * @return
     */
    @RequestMapping(value = "/currentOrder", method = RequestMethod.POST)
    public ResponseObject<OrderDO> currentOrder(@RequestParam("customerId") Integer customerId) {
            OrderDO orderDO = orderService.currentOrder(customerId);
            return ResponseUtil.getOK(orderDO);
    }

    /**
     * 根据id查订单
     * @param customerId
     * @param request
     * @return
     */
    @RequestMapping(value = "/orderDetail", method = RequestMethod.POST)
    public ResponseObject<OrderDO> orderDetail(@RequestParam("orderId") Integer orderId) {
            OrderDO orderDO = orderService.orderDetail(orderId);
            return ResponseUtil.getOK(orderDO);

    }

    /**
     * 历史订单
     * @return
     */
    @RequestMapping(value = "/historyList", method = RequestMethod.POST)
    public ResponseObject<OrderHistoryMongo> historyList(Integer customerId) {

            List<OrderHistoryMongo> list = orderService.historyList(customerId);

            return ResponseUtil.getOK(list);

    }

    @GetMapping(value = "/testPool")
    public ResponseObject testPool(Integer type) {
        if ( type != null && type == 1 ) {
            orderService.testType();
        } else {
            wikiCategoryService.testType2(type);
        }

        return ResponseUtil.getOK();
    }


}
