package com.lxw.dnf;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DNFCommon {
	
	private int[] arr = {71, 72, 89, 85, 73, 86, 66, 70, 78, 81, 69, 84};
	private volatile List<Integer> skills = new ArrayList<>();
	
	//过门的方法
	public void findMen(int men, int ren) throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		int y=0;
		
		//先往下走
		robot.keyPress(KeyEvent.VK_S);
		robot.delay(random.nextInt(500)+2000);
		robot.keyRelease(KeyEvent.VK_S);
		
		//找人物位置
		do {
			wai: for(int i=335; i<490; i+=5) {
				for(int j=0; j<800; j+=random.nextInt(4)+16) {
					Color pixelColor = robot.getPixelColor(j, i);
					if(pixelColor.getRGB() == -336796) {
						System.out.println(j+" "+i);
						y=i+100;
						break wai;
					}
				}
			}
		}while(y == 0);

		if(y>men && y-men >= 18) {
			robot.keyPress(KeyEvent.VK_W);
			robot.delay((y-men)*8+random.nextInt(50));
			robot.keyRelease(KeyEvent.VK_W);
			robot.delay(random.nextInt(300)+300);
		}
//		else if(y < men && men-y >= 18) {
//			robot.keyPress(KeyEvent.VK_S);
//			robot.delay((men-y)*8);
//			robot.keyRelease(KeyEvent.VK_S);
//			robot.delay(random.nextInt(300)+300);
//		}
		
		//x轴对齐后开始往后走
		robot.keyPress(KeyEvent.VK_D);
		robot.delay(random.nextInt(100)+100);
		robot.keyRelease(KeyEvent.VK_D);
		robot.delay(random.nextInt(50)+100);
		robot.keyPress(KeyEvent.VK_D);
		for(int i=0; i<1000; i++) {
			//过图后停止
			if(ren == 780) {
				Color pixelColor = robot.getPixelColor(767, 60);
				if(pixelColor.getRGB() != -3407685) {
					robot.keyRelease(KeyEvent.VK_D);
					break;
				}
			}else {
				Color pixelColor = robot.getPixelColor(ren, 60);
				if(pixelColor.getRGB() == -3407685 || pixelColor.getRGB() == -2228224) {
					robot.keyRelease(KeyEvent.VK_D);
					break;
				}
			}
			robot.delay(random.nextInt(300)+300);
		}
	}
	
	//捡物品的方法
	public void findWupin() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		int renX=0;
		int renY=0;
		int wuX=0;
		int wuY=0;
		wai: for(int i=260; i<490; i+=6) {
			for(int j=0; j<800; j+=30) {
				Color pixelColor = robot.getPixelColor(j, i);
				if(pixelColor.getRGB() == -336796) {
					renX=j;
					renY=i+100;
					System.out.println(j+" "+i);
					break wai;
				}
			}
		}

		wai2: for(int i=260; i<490; i+=4) {
			for(int j=0; j<800; j+=12) {
				Color pixelColor = robot.getPixelColor(j, i);
				if(pixelColor.getRGB() == -65339 || pixelColor.getRGB() == -55040 || pixelColor.getRGB() == -56832) {
					wuX=j;
					wuY=i;
					System.out.println(j+" "+i);
					break wai2;
				}
			}
		}
		if(renX < wuX) {
			robot.keyPress(KeyEvent.VK_D);
			robot.delay((wuX-renX)*6);
			robot.keyRelease(KeyEvent.VK_D);
			robot.delay(random.nextInt(200)+200);
		}else if(renX > wuX && wuX != 0) {
			robot.keyPress(KeyEvent.VK_A);
			robot.delay((renX-wuX)*6);
			robot.keyRelease(KeyEvent.VK_A);
			robot.delay(random.nextInt(200)+200);
		}

		if(renY < wuY) {
			robot.keyPress(KeyEvent.VK_S);
			robot.delay((wuY-renY)*8);
			robot.keyRelease(KeyEvent.VK_S);
			robot.delay(random.nextInt(200)+200);
		}else if(renY > wuY && wuX != 0) {
			robot.keyPress(KeyEvent.VK_W);
			robot.delay((renY-wuY)*8);
			robot.keyRelease(KeyEvent.VK_W);
			robot.delay(random.nextInt(200)+200);
		}
		
		if(wuX != 0) {
			robot.keyPress(KeyEvent.VK_H);
			robot.delay(random.nextInt(300)+500);
			robot.keyRelease(KeyEvent.VK_H);
			robot.delay(random.nextInt(200)+200);
		}
	}

	//找怪的方法
	public void findGuai() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		int renX=0;
		int renY=0;
		int wuX=0;
		int wuY=0;
		int count=0;
		
		do {
			wai: for(int i=260; i<490; i+=5) {
				for(int j=0; j<800; j+=30) {
					Color pixelColor = robot.getPixelColor(j, i);
					if(pixelColor.getRGB() == -336796) {
						renX=j;
						renY=i+100;
						System.out.println(j+" "+i);
						break wai;
					}
				}
			}
			
			wai2: for(int i=260; i<530; i+=30) {
				for(int j=0; j<800; j+=20) {
					Color pixelColor = robot.getPixelColor(j, i);
					if(pixelColor.getRGB() == -65536) {
						wuX=j;
						wuY=i+60;
						System.out.println(j+" "+i);
						break wai2;
					}
				}
			}
			if(renX < wuX && wuX != 0) {
				if(wuX-renX > 40) {
					robot.keyPress(KeyEvent.VK_D);
					robot.delay((wuX-renX)*5);
					robot.keyRelease(KeyEvent.VK_D);
					robot.delay(random.nextInt(200)+200);
				}
			}else if(renX > wuX && wuX != 0) {
				if(renX-wuX > 40) {
					robot.keyPress(KeyEvent.VK_A);
					robot.delay((renX-wuX)*5);
					robot.keyRelease(KeyEvent.VK_A);
					robot.delay(random.nextInt(200)+200);
				}
			}
			
			if(renY < wuY && wuY != 0) {
				if(wuY-renY > 30) {
					robot.keyPress(KeyEvent.VK_S);
					robot.delay((wuY-renY)*7);
					robot.keyRelease(KeyEvent.VK_S);
					robot.delay(random.nextInt(200)+200);
				}
			}else if(renY > wuY && wuY != 0) {
				if(renY-wuY > 30) {
					robot.keyPress(KeyEvent.VK_W);
					robot.delay((renY-wuY)*7);
					robot.keyRelease(KeyEvent.VK_W);
					robot.delay(random.nextInt(200)+200);
				}
			}
			
			//如果找不到怪就往前下走一点
			if(wuX == 0) {
				if(random.nextInt(2) == 1) {
					robot.keyPress(KeyEvent.VK_D);
					robot.delay(random.nextInt(800)+900);
					robot.keyRelease(KeyEvent.VK_D);
					robot.delay(random.nextInt(200)+200);
				}else {
					robot.keyPress(KeyEvent.VK_S);
					robot.delay(random.nextInt(300)+300);
					robot.keyRelease(KeyEvent.VK_S);
					robot.delay(random.nextInt(200)+200);
				}
			}
			count++;
		}while(wuX == 0 && count < 2);
	}
	
	//放技能的方法
	public void skills() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		
		for(int x : skills) {
			System.out.print(x+"\t");
		}
		int x = random.nextInt(skills.size());
		System.out.println(skills.get(x));
		robot.keyPress(skills.get(x));
		robot.delay(random.nextInt(280) + 200);
		robot.keyRelease(skills.get(x));

		if(skills.get(x) != 72) {
			switch(skills.get(x)) {
			case 71:
				skillTime(x, 4);
				break;
			case 89:
				skillTime(x, 8);
				break;
			case 85:
				skillTime(x, 33);
				break;
			case 73:
				skillTime(x, 10);
				break;
			case 86:
				skillTime(x, 19);
				break;
			case 66:
				skillTime(x, 37);
				break;
			case 70:
				skillTime(x, 42);
				break;
			case 78:
				skillTime(x, 55);
				break;
			case 81:
				skillTime(x, 15);
				break;
			case 69:
				skillTime(x, 8);
				break;
			case 84:
				skillTime(x, 90);
				break;
			}
		}	
		robot.delay(random.nextInt(500) + 700);	
		eat();
	}
	
	//技能冷却的方法
	public void skillTime(int index, int time) {
		Random random = new Random();
		new Thread(() -> {
			int skill = skills.get(index);
			skills.remove(index);
			try {
				TimeUnit.SECONDS.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			skills.add(skill);
		}, String.valueOf(random.nextInt(888888))).start();
	}
	
	//吃药的方法
	public void eat() throws AWTException {
		Robot robot = new Robot();
		Random random = new Random();
		Color pixelColor = robot.getPixelColor(253, 560);
		if(pixelColor.getRGB() != -65536) {
			robot.keyPress(KeyEvent.VK_3);
			robot.delay(random.nextInt(200)+200);
			robot.keyRelease(KeyEvent.VK_3);
			robot.delay(random.nextInt(200)+100);
		}
	}
	
	// 鼠标移到某坐标的方法
	public void mouseMove(int x, int y) throws AWTException {

		Point mousepoint = MouseInfo.getPointerInfo().getLocation();
		Robot robot = new Robot();
		Random random = new Random();

		if (mousepoint.x < x) {
			for (int i = mousepoint.x; i < x; i += random.nextInt(6)) {
				if (mousepoint.y < y) {
					robot.mouseMove(i, mousepoint.y += random.nextInt(5));
				} else if (mousepoint.y > y) {
					robot.mouseMove(i, mousepoint.y -= random.nextInt(7));
				} else {
					robot.mouseMove(i, y);
				}
				robot.delay(random.nextInt(9));
			}
			if (mousepoint.y < y) {
				for (int i = mousepoint.y; i < y; i += random.nextInt(6)) {
					robot.mouseMove(x, i);
					robot.delay(random.nextInt(9));
				}
			} else {
				for (int i = mousepoint.y; i > y; i -= random.nextInt(7)) {
					robot.mouseMove(x, i);
					robot.delay(random.nextInt(9));
				}
			}
		} else {
			for (int i = mousepoint.x; i > x; i -= random.nextInt(7)) {
				if (mousepoint.y < y) {
					robot.mouseMove(i, mousepoint.y += random.nextInt(5));
				} else if (mousepoint.y > y) {
					robot.mouseMove(i, mousepoint.y -= random.nextInt(6));
				} else {
					robot.mouseMove(i, y);
				}
				robot.delay(random.nextInt(8));
			}
			if (mousepoint.y < y) {
				for (int i = mousepoint.y; i < y; i += random.nextInt(6)) {
					robot.mouseMove(x, i);
					robot.delay(random.nextInt(8));
				}
			} else {
				for (int i = mousepoint.y; i > y; i -= random.nextInt(7)) {
					robot.mouseMove(x, i);
					robot.delay(random.nextInt(7));
				}
			}
		}
		robot.delay(random.nextInt(350) + 200);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(random.nextInt(350) + 200);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	//把技能数组都放到列表里
	public DNFCommon() {
		for(int i=0; i<arr.length; i++) {
			skills.add(arr[i]);
		}
	}
}
