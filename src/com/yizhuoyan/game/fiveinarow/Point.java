package com.yizhuoyan.game.fiveinarow;

/**
 * 下棋的点
 */
public class Point {

	int color;//1黑棋，2白棋，0未落子
	int x;
	int y;
	int score;//分值，用于AI算法
	
	/**
	 * 让点绘制自己
	 */
	void paint() {
		if(color==0) {
			System.out.print("╋");//v9
		}else if(color==1) {
			System.out.print("●");//
		}else if(color==2) {
			System.out.print("○");//v1
		}
	}
	
}
