package com.lxw.dnf;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class DNFMain {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub

		Robot robot = new Robot();
		Random random = new Random();
		DNFRoom testRoom = new DNFRoom();
		DNFCommon testCommon = new DNFCommon();
		//��Ӽ����б�
//		testCommon.skillList();

		robot.delay(2000);

		// ѡ���һ����ɫ
		testCommon.mouseMove(120, 210);
		robot.delay(random.nextInt(1000)+500);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.delay(random.nextInt(450)+200);
		robot.keyRelease(KeyEvent.VK_SPACE);

		// ��һ��ESC
		robot.delay(random.nextInt(4600)+7000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.delay(random.nextInt(500)+200);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		// �������Ƿ���
		robot.delay(random.nextInt(2300)+1000);
		robot.keyPress(KeyEvent.VK_S);
		robot.delay(random.nextInt(1000)+1000);
		robot.keyRelease(KeyEvent.VK_S);

		// ��ѡ��ĵ�ͼ�Ľ���
		robot.delay(random.nextInt(1600)+1000);
		robot.keyPress(KeyEvent.VK_D);
		robot.delay(random.nextInt(2500)+5500);
		robot.keyRelease(KeyEvent.VK_D);
		robot.delay(random.nextInt(1600)+500);
		robot.keyPress(KeyEvent.VK_S);
		robot.delay(random.nextInt(1000)+500);
		robot.keyRelease(KeyEvent.VK_S);
		robot.delay(random.nextInt(1600)+500);
		robot.keyPress(KeyEvent.VK_D);
		robot.delay(random.nextInt(1000)+1000);
		robot.keyRelease(KeyEvent.VK_D);

		// ѡ���ͼ
		robot.delay(random.nextInt(1000)+800);
		testCommon.mouseMove(random.nextInt(83)+490, random.nextInt(20)+140);
		robot.delay(random.nextInt(1000)+500);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.delay(random.nextInt(450)+200);
		robot.keyRelease(KeyEvent.VK_SPACE);
		
		for(int i=0; i<23; i++) {
			//��һ������
			testRoom.room01();
			robot.delay(random.nextInt(500) + 500);
			
			//�ڶ�������
			testRoom.room02();
			robot.delay(random.nextInt(500) + 500);
			
			//����������
			testRoom.room03();
			robot.delay(random.nextInt(500) + 500);
			
			//���ĸ�����
			testRoom.room04();
			robot.delay(random.nextInt(500) + 500);
			
			//���������
			testRoom.room05();
			robot.delay(random.nextInt(500) + 500);
			
			//����������
			testRoom.room06();
			robot.delay(random.nextInt(500) + 500);
			
			//���߸�����
			testRoom.room07();
			robot.delay(random.nextInt(500) + 500);
			
			//�ڰ˸�����
			testRoom.room08();
			robot.delay(random.nextInt(500) + 500);

			//�ھŸ�����
			testRoom.room09();
			robot.delay(random.nextInt(500) + 500);
		}
		
	}

}
