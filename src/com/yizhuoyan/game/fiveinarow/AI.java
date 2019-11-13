package com.yizhuoyan.game.fiveinarow;

import java.util.Random;

/**
 */
public class AI {
	String name;
	int color;// 1黑方，2白方

	void play(Qipan qp) {
		// 1 玩家输入X坐标
		int x = getX();
		// 2 玩家输入Y坐标
		int y = getY();
		
		try {
			//模拟电脑思考
			Thread.sleep(500);
		}catch(Exception e) {}
		// 3 下子
		Point p = qp.points[x][y];
		// 说明已有棋子，不能方
		if (p.color != 0) {
			// 递归(再下)
			play(qp);
			return;
		}
		// 改变放置点状态
		p.color = color;
		// 4 重新绘制棋盘
		qp.draw();
	}

	int getX() {
		
		Random random=new Random();
		return random.nextInt(15);
	}
	int getY() {
		return getX();
	}
	
	public static void main(String[] args) {
		Random random=new Random();
		for(int i=100;i-->0;) {
			System.out.println(random.nextInt(500));
		}
	}
}
