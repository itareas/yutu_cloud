/**
 * 
 */
package com.yutu.entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Author: zhaobc
* @Date: 2020/1/12 12:12
* @Description: 验证码处理器
**/
public interface ValidateCodeProcessor {

	/**
	* @Author: zhaobc
	* @Date: 2020/1/12 12:13
	* @Description: 验证码放入session时的前缀
	**/
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

	/**
	* @Author: zhaobc
	* @Date: 2020/1/12 12:13
	* @Description: 创建校验码
	**/
	void create(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	* @Author: zhaobc
	* @Date: 2020/1/12 12:13
	* @Description: 校验验证码
	**/
	void validate(HttpServletRequest request);
	/**
	 * 生成验证码
	 * @return
	 */
	ValidateCode generator(HttpServletRequest request);
	/**
	* @Author: zhaobc
	* @Date: 2020/1/12 12:13
	* @Description: 保存验证码
	**/
	void save(HttpServletRequest request, ValidateCode validateCode);

	/**
	* @Author: zhaobc
	* @Date: 2020/1/12 12:13
	* @Description: 发送验证码
	**/
	void send(HttpServletResponse response, ValidateCode validateCode)throws Exception ;
}
