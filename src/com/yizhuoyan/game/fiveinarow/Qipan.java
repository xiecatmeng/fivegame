package com.yizhuoyan.game.fiveinarow;

/**
 * 棋盘
 */
public class Qipan {

	Point[][] points;//存放棋子的二维数组
	
	public Qipan() {
		//棋盘是15X15，设置为20X20是为了数组越界，简化AI部分及判断胜负等代码
		points=new Point[20][20];
		
		//创建所有放置点对象
		for(int y=0;y<points.length;y++) {
			Point[] row=points[y];
			for(int x=0;x<row.length;x++) {
				Point p=new Point();
				p.x=x;
				p.y=y;
				p.color=0;
				row[x]=p;
			}			
		}
	}
	
	//绘制棋盘
	void draw() {
		System.out.println();
		System.out.println();
		System.out.println();
		for(int y=0;y<15;y++) {
			Point[] row=points[y];
			for(int x=0;x<15;x++) {
				Point p=row[x];
				p.paint();
			}
			System.out.println();
		}
	}
	
	//棋盘是否已经由棋子填满，没有任何落子的位置了
	boolean isFull() {
		for(int y=0;y<15;y++) {
			Point[] row=points[y];
			for(int x=0;x<15;x++) {
				Point p=row[x];
				//如果还有放置点可用
				if(p.color==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	//坐标(x,y)是否已经有棋子占用
	boolean isExist(int x,int y) {
		return false;
	}
	
	public static void main(String[] args) {
		Qipan qp=new Qipan();
		qp.draw();
	}
}
