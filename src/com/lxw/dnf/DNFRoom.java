package com.lxw.dnf;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DNFRoom extends DNFCommon {
	
	public void room01() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		// 等待进图然后开buff -> 右右空格
		robot.delay(random.nextInt(5000) + 12000);
//		robot.keyPress(KeyEvent.VK_D);
//		robot.delay(random.nextInt(80)+80);
//		robot.keyRelease(KeyEvent.VK_D);
//		robot.delay(random.nextInt(50)+90);
//		robot.keyPress(KeyEvent.VK_D);
//		robot.delay(random.nextInt(100)+70);
//		robot.keyRelease(KeyEvent.VK_D);
//		robot.delay(random.nextInt(70)+80);
//		robot.keyPress(KeyEvent.VK_SPACE);
//		robot.delay(random.nextInt(200)+100);
//		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_R);
		robot.delay(random.nextInt(250)+200);
		robot.keyRelease(KeyEvent.VK_R);
		
		//调用过门方法
		robot.delay(random.nextInt(350) + 500);
		super.findMen(452, 659);
	}
	
	public void room02() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//放技能
		for (int i = 0; i < 200; i++) {
			
			//第二个房间判断门
			Color pixelColor = robot.getPixelColor(682, 62);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB()== -15645509) {
				break;
			}
			
			//7个技能找一次怪
			if(i%5 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
		}
		
		// 到第三个房间
		robot.delay(random.nextInt(300) + 500);
		super.findMen(390, 677);
		
	}
	
	public void room03() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//放技能
		for (int i = 0; i < 150; i++) {
			
			//判断门
			Color pixelColor = robot.getPixelColor(700, 62);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB()== -15645509) {
				break;
			}
			
			//十个技能找一次怪
			if(i%5 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
		}
		
		// 到第四个房间
		robot.delay(random.nextInt(300) + 500);
		super.findMen(355, 695);
	}

	public void room04() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//放技能
		for (int i = 0; i < 150; i++) {
			
			//判断门
			Color pixelColor = robot.getPixelColor(676, 60);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB()== -15658531) {
				break;
			}
			
			//十个技能找一次怪
			if(i%6 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
		}
		
		//捡物品
		super.findWupin();
		
		// 到第五个房间
		robot.delay(random.nextInt(300) + 400);
		super.findMen(470, 713);
	}

	public void room05() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//放技能
		for (int i = 0; i < 150; i++) {
			
			//判断门
			Color pixelColor = robot.getPixelColor(736, 62);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB()== -15645509) {
				break;
			}
			
			//十个技能找一次怪
			if(i%5 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
		}
		
		// 到第六个房间
		robot.delay(random.nextInt(300) + 350);
		super.findMen(400, 730);
	}

	public void room06() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//放技能
		for (int i = 0; i < 100; i++) {
			
			//判断门
			Color pixelColor = robot.getPixelColor(753, 62);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB()== -15645509) {
				break;
			}
			
			//十个技能找一次怪
			if(i%5 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
		}
		
		// 到第七个房间
		robot.delay(random.nextInt(300) + 500);
		super.findMen(340, 749);
	}

	public void room07() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//放技能
		for (int i = 0; i < 200; i++) {
			
			//判断门
			Color pixelColor = robot.getPixelColor(772, 62);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB()== -15645509) {
				break;
			}
			
			//十个技能找一次怪
			if(i%6 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
		}
		
		//捡物品
		super.findWupin();
		
		// 到第八个房间
		robot.delay(random.nextInt(300) + 500);
		super.findMen(390, 767);
	}

	public void room08() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//放技能
		for (int i = 0; i < 150; i++) {
			
			//判断门
			Color pixelColor = robot.getPixelColor(749, 60);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB()== -15658531) {
				break;
			}
			
			//十个技能找一次怪
			if(i%5 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
		}
		
		// 到第九个房间
		robot.delay(random.nextInt(300) + 500);
		super.findMen(390, 780);
	}

	public void room09() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		//下前放大招
		robot.keyPress(KeyEvent.VK_D);
		robot.delay(random.nextInt(700)+1300);
		robot.keyRelease(KeyEvent.VK_D);
		robot.delay(random.nextInt(200)+200);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(random.nextInt(250)+250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(random.nextInt(800)+1500);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.delay(random.nextInt(250)+250);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.delay(random.nextInt(1000)+8000);
		robot.keyPress(KeyEvent.VK_T);
		robot.delay(random.nextInt(250)+250);
		robot.keyRelease(KeyEvent.VK_T);
		robot.delay(random.nextInt(150)+100);
		
		//放技能
		for (int i = 0; i < 200; i++) {
			
			//十个技能找一次怪
			if(i%5 == 0) {
				super.findGuai();
			}
			
			super.skills();
			
			//判断是否通关
			Color pixelColor = robot.getPixelColor(676, 178);
			System.out.println(pixelColor.getRGB() );
			if(pixelColor.getRGB() == -8910586) {
				break;
			}
		}
		
		//esc与捡物
		if(random.nextInt(2) == 1) {
			// 按一下ESC
			robot.delay(random.nextInt(1000)+500);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.delay(random.nextInt(200)+300);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			
			robot.delay(random.nextInt(300)+500);
			robot.keyPress(KeyEvent.VK_L);
			robot.delay(random.nextInt(200)+200);
			robot.keyRelease(KeyEvent.VK_L);
			robot.delay(random.nextInt(300)+300);
			robot.keyPress(KeyEvent.VK_H);
			robot.delay(random.nextInt(2000)+2000);
			robot.keyRelease(KeyEvent.VK_H);
		} else {
			robot.delay(random.nextInt(300)+500);
			robot.keyPress(KeyEvent.VK_L);
			robot.delay(random.nextInt(200)+200);
			robot.keyRelease(KeyEvent.VK_L);
			robot.delay(random.nextInt(300)+300);
			robot.keyPress(KeyEvent.VK_H);
			robot.delay(random.nextInt(2000)+2000);
			robot.keyRelease(KeyEvent.VK_H);
			
			robot.delay(random.nextInt(500)+500);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.delay(random.nextInt(200)+300);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		}
		
		
		robot.delay(random.nextInt(300)+300);
		//五分之一的概率分解装备
		if(random.nextInt(5) == 3) {
			robot.keyPress(KeyEvent.VK_C);
			robot.delay(random.nextInt(200)+250);
			robot.keyRelease(KeyEvent.VK_C);
			
			robot.delay(random.nextInt(300)+500);
			
			super.mouseMove(random.nextInt(53)+417, random.nextInt(7)+335);
			robot.delay(random.nextInt(500)+500);
			
			robot.keyPress(KeyEvent.VK_A);
			robot.delay(random.nextInt(200)+200);
			robot.keyRelease(KeyEvent.VK_A);
			robot.delay(random.nextInt(300)+300);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(random.nextInt(200)+200);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.delay(random.nextInt(3000)+4000);

		}
		
		robot.delay(random.nextInt(300)+300);
		robot.keyPress(KeyEvent.VK_F10);
		robot.delay(random.nextInt(200)+300);
		robot.keyRelease(KeyEvent.VK_F10);
	}
	
}
