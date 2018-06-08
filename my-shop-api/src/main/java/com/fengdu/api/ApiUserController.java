package com.fengdu.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fengdu.annotation.IgnoreAuth;
import com.fengdu.annotation.LoginUser;
import com.fengdu.constant.MyshopConstants;
import com.fengdu.entity.SmsLogVo;
import com.fengdu.entity.UserVo;
import com.fengdu.service.ApiUserService;
import com.fengdu.util.ApiBaseAction;
import com.fengdu.utils.CharUtil;
import com.fengdu.utils.RedisUtils;
import com.fengdu.utils.sms.SmsAlidayu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@RestController
@RequestMapping("/api/user")
@Api(tags="API获取用户信息Controller")
public class ApiUserController extends ApiBaseAction {
    @Autowired
    private ApiUserService userService;
    
    @Autowired  
  	private RedisUtils redisUtils;
   
    /**
     */
    @IgnoreAuth
    @RequestMapping("info")
    @ApiOperation(value = "获取用户信息接口" ,response=UserVo.class, notes = "获取用户信息接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="query")
    })
    public Object info(@LoginUser UserVo loginUser, String mobile) {
        Map param = new HashMap();
        param.put("mobile", mobile);
        UserVo user = userService.queryByMobile(mobile);
        user.setPassword("");
        redisUtils.set("user",user,MyshopConstants.EXPIRE_TIME);
        return user;
    }

    /**
     * 保存用户头像
     */
    @RequestMapping("saveAvatar")
    public Object saveAvatar(@LoginUser UserVo loginUser, String avatar) {
        return null;
    }

    /**
     * 发送短信
     */
    @RequestMapping("smscode")
    public Object smscode(@LoginUser UserVo loginUser) {
        JSONObject jsonParams = getJsonRequest();
        String phone = jsonParams.getString("phone");
        // 一分钟之内不能重复发送短信
        SmsLogVo smsLogVo = userService.querySmsCodeByUserId(loginUser.getUserId());
        if (null != smsLogVo && (System.currentTimeMillis() / 1000 - smsLogVo.getLog_date()) < 1 * 60) {
            return toResponsFail("短信已发送");
        }
        //生成验证码
        String sms_code = CharUtil.getRandomNum(4);
        String smsTemplateCode = "SMS_94340007";
        String msgContent = "您的验证码是：" + sms_code + "，请在页面中提交验证码完成验证。";
        String param = "{\"code\":\"" + sms_code + "\"}";
        // 发送短信
//        String rpt = "0";
        String rpt = SmsAlidayu.sendTplShortMessage(param, phone, smsTemplateCode);
        if (rpt == null || rpt.equals("0") == false) {
            return toResponsFail("短信发送失败");
        } else {
            smsLogVo = new SmsLogVo();
            smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
            smsLogVo.setUser_id(loginUser.getUserId());
            smsLogVo.setPhone(phone);
            smsLogVo.setSms_code(sms_code);
            smsLogVo.setSms_text(msgContent);
            userService.saveSmsCodeLog(smsLogVo);
            return toResponsSuccess("短信发送成功");
        }
    }

    /**
     * 获取当前会员等级
     *
     * @param loginUser
     * @return
     */
    @RequestMapping("getUserLevel")
    public Object getUserLevel(@LoginUser UserVo loginUser) {
        String userLevel = userService.getUserLevel(loginUser);
        return toResponsSuccess(userLevel);
    }
}