package com.peng.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
	private static final SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	//定义每过3秒执行此任务
	//@Scheduled(fixedRate=3000)
	public void reportCurrentTime() {
		System.out.println("当前时间："+sdf.format(new Date()));
	}
	

}
