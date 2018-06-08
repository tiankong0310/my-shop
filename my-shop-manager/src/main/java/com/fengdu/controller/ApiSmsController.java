package com.fengdu.controller;

import com.fengdu.annotation.IgnoreAuth;
import com.fengdu.entity.SysSmsLogEntity;
import com.fengdu.service.SysSmsLogService;
import com.fengdu.utils.DateUtils;
import com.fengdu.utils.R;
import com.fengdu.utils.RRException;
import com.fengdu.utils.RequestUtil;
import com.fengdu.utils.ResourceUtil;
import com.fengdu.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 名称：ApiSmsController <br>
 * 描述：Api<br>
 *
 * @author 李鹏军
 * @version 1.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("api")
public class ApiSmsController {
    @Autowired
    private SysSmsLogService smsLogService;

    /**
     * 发送短信
     * mobile：电话号码字符串，中间用英文逗号间隔
     * content：内容字符串
     * stime：追加发送时间，可为空，为空为及时发送
     */
    @IgnoreAuth
    @RequestMapping("/sendSms")
    public R sendSms(HttpServletRequest request, @RequestParam Map<String, String> params) {
        SysSmsLogEntity smsLog = new SysSmsLogEntity();
        String validIP = RequestUtil.getIpAddrByRequest(request);
        if (ResourceUtil.getConfigByName("sms.validIp").indexOf(validIP) < 0) {
            throw new RRException("非法IP请求！");
        }
        smsLog.setMobile(params.get("mobile"));
        smsLog.setContent(params.get("content"));
        String stime = params.get("stime");
        if (StringUtils.isNotEmpty(stime)) {
            smsLog.setStime(DateUtils.convertStringToDate(stime));
        }
        SysSmsLogEntity sysSmsLogEntity = smsLogService.sendSms(smsLog);
        return R.ok().put("result", sysSmsLogEntity);
    }
}
