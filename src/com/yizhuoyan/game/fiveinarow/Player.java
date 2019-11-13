package com.yizhuoyan.game.fiveinarow;

import java.util.Scanner;

/**
 *  人类玩家
 */
public class Player {

	String name;//玩家姓名
	int color;//1黑方，2白方
	
	
	//人类下棋
	void play(Qipan qp) {
		//1 玩家输入X坐标
		int x=getX();
		//2 玩家输入Y坐标
		int y=getY();
		//3 下子
		Point p=qp.points[x][y];
		//说明已有棋子，不能方
		if(p.color!=0) {
			System.out.println("对应位置已有棋子，请重新放置");
			//递归(再下)
			play(qp);
			return;
		}
		
		//改变放置点状态
		p.color=color;
		//4 重新绘制棋盘
		qp.draw();
		
	}
	int getX() {
		Scanner scanner=new Scanner(System.in);
		System.out.println(name+",请输入X坐标>");
		int x=0;
		while(true) {
			//判断是否输入了整数
			if(scanner.hasNextInt()) {
				//开始读取整数
				x=scanner.nextInt();
				//判断是否符合要求
				if(0<=x&&x<15) {
					//退出循环
					break;
				}
				System.out.println("您输入的X坐标超出范围请重新输入");
			}else {
				System.out.println("请输入正整数");
				//扔掉不是整数的输入
				scanner.next();
			}
		}
			
		
		
		return x;
	}
	
	int getY() {
		Scanner scanner=new Scanner(System.in);
		System.out.println(name+",请输入Y坐标>");
		int y=0;
		while(true) {
			//判断是否输入了整数
			if(scanner.hasNextInt()) {
				//开始读取整数
				y=scanner.nextInt();
				//判断是否符合要求
				if(0<=y&&y<15) {
					//退出循环
					break;
				}
				System.out.println("您输入的Y坐标超出范围请重新输入");
			}else {
				System.out.println("请输入正整数");
				//扔掉不是整数的输入
				scanner.next();
			}
		}
			
		
		
		return y;
	}
	public static void main(String[] args) {
		Player p=new Player();
		p.name="张飞";
		p.color=1;
		int x=p.getX();
		System.out.println("x="+x);
	}
	
}
