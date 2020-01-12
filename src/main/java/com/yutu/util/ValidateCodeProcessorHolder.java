/**
 * 
 */
package com.yutu.util;

import java.util.Map;

import com.yutu.entity.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
* @Author: zhaobc
* @Date: 2020/1/12 12:14
* @Description: 验证码句柄
**/
@Component
public class ValidateCodeProcessorHolder {


	private Map<String, ValidateCodeProcessor> validateCodeProcessors;


	public ValidateCodeProcessor findValidateCodeProcessor(String type) {
		String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
		ValidateCodeProcessor processor = validateCodeProcessors.get(name);
		if (processor == null) {
			throw new RuntimeException("验证码处理器" + type + "不存在");
		}
		return processor;
	}

}
