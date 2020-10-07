package com.alan.beans;

import java.io.Serializable;
import java.util.HashMap;

public class JsonResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//不支持流式录像下载
	public static final String CAPABILITY_TYPE_DOWNLOAD_TS_REC ="CAPABILITY_TYPE_DOWNLOAD_TS_REC";
	public static final String RESULT_SUCCESS = "ok";
	public static final String RESULT_FAILED = "FAILED";
	public static final String RESULT_INVALID_USERID = "INVALID_USERID";
	public static final String RESULT_INVALID_TOKEN = "INVALID_TOKEN";
	public static final String RESULT_INVALID_FILE_FORMAT = "INVALID_FILE_FORMAT";
	public static final String RESULT_INVALID_MAC = "INVALID_MAC";
	public static final String RESULT_INVALID_EMAIL_FORMAT = "INVALID_EMAIL_FORMAT";
	public static final String RESULT_INVALID_EMAIL = "INVALID_EMAIL";
	public static final String RESULT_EMAIL_REGISTERED = "EMAIL_REGISTERED";
	public static final String RESULT_INVALID_PHONE_FORMAT = "INVALID_PHONE_FORMAT";
	public static final String RESULT_DEVICE_OFFLINE = "DEVICE_OFFLINE";
	public static final String RESULT_INVALID_PARENT = "INVALID_PARENT";
	public static final String RESULT_DEVICE_REGISTERED = "DEVICE_REGISTERED";
	public static final String RESULT_NO_DATA = "NO_DATA";
	public static final String RESULT_NO_PHONE = "NO_PHONE";
	public static final String RESULT_EXCEPTION = "EXCEPTION";
	public static final String RESULT_INVALID_PARAMETER = "INVALID_PARAMETER";
	public static final String RESULT_NO_PERMISSION = "NO_PERMISSION";
	public static final String RESULT_USERNAME_REGISTERED = "USERNAME_REGISTERED";
	public static final String RESULT_PHONE_REGISTERED = "PHONE_REGISTERED";
	public static final String RESULT_PHONE_NULL = "PHONE_NULL";
	public static final String RESULT_CHANLLENGE_NULL="CHANLLENGE_NULL";
	public static final String RESULT_INVALID_CHANLLENGE="INVALID_CHANLLENGE";
	public static final String RESULT_UNKNOWN_EMAIL = "UNKNOWN_EMAIL";
	public static final String RESULT_GEETEST_CHECK_FAILIURE="RESULT_GEETEST_CHECK_FAILIURE";
	public static final String RESULT_GEETEST_SEND_MESSAGE_OK="RESULT_GEETEST_SEND_MESSAGE_OK";
	public static final String RESULT_PASSWD_ERROR = "PASSWD_ERROR";
	public static final String RESULT_PASSWD_MODIFIED = "PASSWD_MODIFIED";
	public static final String RESULT_TOKEN_EXPIRED = "TOKEN_EXPIRED";
	public static final String RESULT_USER_EXPIRED = "USER_EXPIRED";
	public static final String RESULT_CHANNEL_FULL = "CHANNEL_FULL";
	public static final String RESULT_INPUT_FAILED = "INPUT_FAILED";
	public static final String RESULT_NOT_SUPPORTED = "NOT_SUPPORTED";
	public static final String RESULT_DUPLICATE = "DUPLICATE";
	public static final String RESULT_EXPIRE = "EXPIRE";
	public static final String RESULT_DEVICE_INITIALIZED = "DEVICE_INITIALIZED";
	public static final String RESULT_NEVER_FIRED = "NEVER_FIRED";
	public static final String RESULT_DUPLICATE_SUBMIT = "DUPLICATE_SUBMIT";
	public static final String RESULT_BALANCE_INSUFFICIENT = "RESULT_BALANCE_INSUFFICIENT";
	public static final String RESULT_CODE_OVERDUE = "CODE_OVERDUE";
	public static final String RESULT_USER_OVERDUE = "USER_OVERDUE";
	public static final String RESULT_USER_DEL = "USER_DEL";
	public static final String RESULT_DEPT_DEL = "DEPT_DEL";
	public static final String RESULT_CODE_ERROR = "CODE_ERROR";
	public static final String RESULT_INVALID_DEVICE_LOGIN = "INVALID_DEVICE_LOGIN";
	public static final String RESULT_EXCEED_LIMIT = "EXCEED_LIMIT";
	public static final String RESULT_ILLEGAL_DATA = "ILLEGAL_DATA";
	public static final String RESULT_HAND_CAPTURE_SCENE = "HAND_CAPTURE_SCENE";
	public static final String RESULT_DELETED_SCENE = "DELETED_SCENE";
	public static final String RESULT_DISABLED_SCENE = "DISABLED_SCENE";
	public static final String RESULT_DEVICE_LOW_MEMORY = "DEVICE_LOW_MEMORY";
	public static final String RESULT_DEVICE_BUSY = "DEVICE_BUSY";
	public static final String RESULT_EXIST_DATA = "EXIST_DATA";
	public static final String RESULT_EXIST_STATUS = "FAILED_ON_OPEN";
	public static final String RESULT_PHONE_NUMBER_ALREADY_EXIST = "PHONE_NUMBER_ALREADY_EXIST";
	public static final String RESULT_ID_NUMBER_ALREADY_EXIST = "ID_NUMBER_ALREADY_EXIST";
	public static final String RESULT_PHONE_AND_ID_NUMBER_ALREADY_EXIST = "PHONE_AND_ID_NUMBER_ALREADY_EXIST";
	public static final String RESULT_FACE_RECOGNIZE_FAILED = "FACE_RECOGNIZE_FAILED";
	public static final String RESULT_SIGN_CHECK_FAILED = "SIGN_CHECK_FAILED";
	public static final String RESULT_ALL_CLOSE = "RESULT_ALL_CLOSE";
	public static final String ACTIVITY_NAME_EXISTING = "ACTIVITY_NAME_EXISTING";
	public static final String RESOURCE_NAME_EXISTING = "RESOURCE_NAME_EXISTING";
	public static final String DEVICE_NAME_EXISTING = "DEVICE_NAME_EXISTING";
	public static final String SAVE_FAILED = "SAVE_FAILED";
	public static final String RESULT_QUERRY_REDIS_ERROR = "RESULT_QUERRY_REDIS_ERROR";
	public static final String RESULT_EMPLOYEE_NUMBER_EXISTING = "EMPLOYEE_NUMBER_EXISTING";
	public static final String RESULT_NO_PRIVILEGE = "NO_PRIVILEGE";
	public static final String QRCODE_IS_INVALID = "QRCODE_INVALID";
	public static final String QRCODE_IS_NOTUSE = "QRCODE_NOTUSE";
	//人脸不符合入库要求
	public static final String RESULT_FACE_LOW_QUALITY = "FACE_LOW_QUALITY";
    //快捷登陆，手机号未注册
	public static final String RESULT_PHONE_NUMBER_NOT_REGISTER ="PHONE_NUMBER_NOT_REGISTER";
	//快捷登陆，手机号格式错误
	public static final String RESULT_PHONE_NUMBER_ERROR = "PHONE_NUMBER_ERROR";
	//常用语，非正常企业用户
	public static final String RESULT_NOT_NORMAL_USER = "NOT_NORMAL_USER";
	//常用语，企业不存在
	public static final String RESULT_ENTERPRISE_NOT_EXIST = "ENTERPRISE_NOT_EXIST";
	//常用语，内容或者类型为空
	public static final String RESULT_PARAMATER_IS_NULL = "PARAMATER_IS_NULL";
	
	//微信登陆，用户拒绝微信登陆
	public static final String RESULT_USER_DENY = "USER_DENY";

	//微信登陆，用户不存在
	public static final String RESULT_USER_NOT_EXIST = "USER_NOT_EXIST";
	
	// 用户冻结
	public static final String RESULT_USER_FROZEN = "USER_FROZEN";
	
	//微信登陆，用户已存在
	public static final String RESULT_USER_ALREADY_EXIST = "USER_ALREADY_EXIST";
	
	//报表历史查询，历史条件不存在
	public static final String RESULT_SEARCHINFO_NOT_EXIST = "SEARCHINFO_NOT_EXIST";
	
	
	public static final String RESULT_NUMBER_MORE = "NUMBER_MORE";
	/**
	 * 该用户不属于任何企业
	 */
	public static final String RESULT_NOT_BELONG_TO_ANY_COMPANY = "NOT_BELONG_TO_ANY_COMPANY";
	/**
	 * 未登录
	 */
	public static final String RESULT_NOT_LOGIN = "LOGIN_OUT";
	/**
	 * 巡店任务不存在
	 */
	public static final String RESULT_TASK_NOT_EXIST = "TASK_NOT_EXIST";
	/**
	 * 设备版本不存在
	 */
	public static final String RESULT_VERSION_NOT_EXIST = "VERSION_NOT_EXIST";
	/**
	 * 门店不存在
	 */
	public static final String RESULT_SHOP_NOT_EXIST = "SHOP_NOT_EXIST";

	/**
	 * 导出数据大于一定值后，抛出异常
	 */
	public static final String RESULT_NUMBER_TOO_LONG="RESULT_NUMBER_TOO_LONG";
	//当前有相同的下载设备 -6
	public static final String START_REC_DOWN_ERR_NVR_DOWNOPP_EXIST ="START_REC_DOWN_ERR_NVR_DOWNOPP_EXIST";
	//当前NVR  CPU 使用较高，无法下载 -5
	public static final String START_REC_DOWN_ERR_PER_LACK_CPU ="START_REC_DOWN_ERR_PER_LACK_CPU";
	//当前NVR 录像播放通道已经满了  -4
	public static final String START_REC_DOWN_NOPLYER_ERR ="START_REC_DOWN_NOPLYER_ERR";
	//当前录像机有录像正在下载 -3
	public static final String START_REC_DOWN_IPC_IS_PALYING ="START_REC_DOWN_IPC_IS_PALYING";
	//IPC 不在NVR下   -2
	public static final String START_REC_DOWN_IPC_NOT_EXIST ="START_REC_DOWN_IPC_NOT_EXIST";
	//录像无法下载  -1
	public static final String START_REC_DOWN_FAIL ="START_REC_DOWN_FAIL";
	//不存在该录像
	public static final String NO_VIDEO ="NO_VIDEO";
	//设备不存在
	public static final String DEVICE_NOT_EXIST ="DEVICE_NOT_EXIST";
	//平台不存在
	public static final String PLATFORM_NOT_EXIST ="PLATFORM_NOT_EXIST";
	//不支持
	public static final String NOT_SUPPORT ="NOT_SUPPORT";
	//nvr返回错误
	public static final String NVR_EXCEPTION ="NVR_EXCEPTION";
	//nvr没数据
	public static final String NVR_NO_DATA ="NVR_NO_DATA";
	/**
	 * 申请流程不唯一跑出异常
	 */
	public static final String RESULT_JUST_ONE="JUST_ONE";
	//可調休時間不足
	public static final String NO_OVOTIME="NO_OVOTIME";
	
	//可请假時間不足
	public static final String NO_LEAVETIME="NO_LEAVETIME";
	
	//请假时间冲突
	public static final String TIME_CONFLICT="TIME_CONFLICT";
	
	//签到没有图片
	public static final String NO_SIGN_PICTURE="NO_SIGN_PICTURE";
	
	//验证码错误
	public static final String VALIDATE_CODE_ERROR="VALIDATE_CODE_ERROR";
	
	//发送错误
	public static final String SEND_FAILED="SEND_FAILED";
	/**
	 * excel导入数据异常
	 */
	public static final String DATA_ERROR="DATA_ERROR";
	
	/**
	 * 数量超过上限
	 */
	public static final String RESULT_OVER_TOO_MANY="OVER_TOO_MANY";
	public static final String TIME_REPEAT="TIME_REPEAT";
	public static final String TIME_ERRER="TIME_ERRER";

	/**
	 * 没有模板权限
	 */
	public static final String NO_TEMPLATE_PRIVILEGE = "NO_TEMPLATE_PRIVILEGE";

	public static final String DATA_NOT_EXIST = "DATA_NOT_EXIST";

	public static final String CRON_ERROR = "CRON_ERROR";
	
	/**
	 * dms错误
	 */
	
	/**
	 * dms设备解析参数出错
	 */
	public static final String DMS_CODE_DEVICE_PARAMETER_ERR = "resp_create_channel_device_say_parameter_err";
	/**
	 * dms设备处理业务失败
	 */
	public static final String DMS_CODE_DEVICE_REQUEST_FAILED = "resp_create_channel_device_say_request_processing_failed";
	/**
	 * dms科达设备回放出错,可提示重启解决
	 */
	public static final String DMS_CODE_DEVICE_EQP_ERR = "resp_create_channel_device_say_eqp_unknown_err";
	/**
	 * dms未知错误
	 */
	public static final String DMS_CODE_DEVICE_UNKNOWN_ERR = "resp_create_channel_device_unknown_err";
	/**
	 * dmsRTSP推流通道新建失败
	 */
	public static final String DMS_CODE_DEVICE_RTSP_ERR = "resp_create_channel_rtsp_er";
	/**
	 * dmsRTMP推流通道新建失败
	 */
	public static final String DMS_CODE_DEVICE_RTMP_ERR = "resp_create_channel_rtmp_Err";
	/**
	 * dmsRTMP回放通道新建失败
	 */
	public static final String DMS_CODE_DEVICE_RTMP_REC_ERR = "resp_create_channel_rtmp_rec_Err";
	/**
	 * dms 流媒体类型不支持
	 */
	public static final String DMS_CODE_DEVICE_MEDIA_NOT_SUPPORTED = "resp_create_channel_media_type_not_supported";
	/**
	 * dms选举DataSwitch失败
	 */
	public static final String DMS_CODE_DEVICE_DATA_SWITCH_ERR = "resp_create_channel_select_data_switch_err";
	/**
	 * dms连接DMS系统超时
	 */
	public static final String DMS_CODE_DEVICE_DMS_TIMEOUT = "resp_create_channel_dial_dms_timeout";
	/**
	 * dms读取指令应答失败
	 */
	public static final String DMS_CODE_DEVICE_DUMP_CMD_RESP_ERR = "resp_create_channel_dump_cmd_resp_body_err";
	/**
	 * dms解析指令应答失败
	 */
	public static final String DMS_CODE_DEVICE_PARSE_CMD_RESP_ERR = "resp_create_channel_parse_cmd_resp_body_err";
	
	private String result;
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public HashMap<String, Object> getData() {
		return data;
	}
	
}
