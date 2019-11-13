package com.yizhuoyan.game.fiveinarow;

/**
 * 游戏主类
 * 
 */
public class Game {

	Qipan qipan;// 棋盘

	/**
	 * 构造方法
	 */
	public Game() {
		qipan = new Qipan();
	}

	/**
	 * 游戏入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Game g = new Game();

		Player p1 = new Player();
		p1.name = "张飞";
		p1.color = 1;// 黑子

		Player p2 = new Player();
		p2.name = "貂婵";
		p2.color = 2;// 白子

		// 人人对弈
		// g.start(p1, p2);

		AI a1 = new AI();
		a1.name = "小爱";
		a1.color = 2;// 白子
		//人机对战
		//g.start(a2, a1);
		AI a2 = new AI();
		a2.name = "小冰";
		a2.color = 1;// 黑子
		//机机对战
		g.start(a2, a1);
	}

	/**
	 * 人人对弈
	 * 
	 * @param black
	 * @param white
	 */
	void start(Player black, Player white) {
		// 1展示空棋盘
		qipan.draw();
		while (true) {
			// 2黑方下棋
			black.play(qipan);
			// 2.1黑方是否胜利了
			if (isWin(1)) {
				System.out.println("黑方胜利了");
				break;
			}
			// 2.2棋盘是否满了，平局
			if (qipan.isFull()) {
				System.out.println("棋盘满了，平局");
				break;
			}
			// 3让白方下棋
			white.play(qipan);
			// 3.1白方是否胜利了
			if (isWin(2)) {
				System.out.println("白方胜利了");
				break;
			}
			// 3.2棋盘是否满了，平局
			if (qipan.isFull()) {
				System.out.println("棋盘满了，平局");
				break;
			}

		}
	}

	// 人机对弈
	void start(Player black, AI white) {
		// 1展示空棋盘
		qipan.draw();
		while (true) {
			// 2黑方下棋
			black.play(qipan);
			// 2.1黑方是否胜利了
			if (isWin(1)) {
				System.out.println("黑方胜利了");
				break;
			}
			// 2.2棋盘是否满了，平局
			if (qipan.isFull()) {
				System.out.println("棋盘满了，平局");
				break;
			}
			// 3让白方下棋
			white.play(qipan);
			// 3.1白方是否胜利了
			if (isWin(2)) {
				System.out.println("白方胜利了");
				break;
			}
			// 3.2棋盘是否满了，平局
			if (qipan.isFull()) {
				System.out.println("棋盘满了，平局");
				break;
			}

		}
	}

	// 机机对弈
	void start(AI black, AI white) {
		// 1展示空棋盘
		qipan.draw();
		while (true) {
			// 2黑方下棋
			black.play(qipan);
			// 2.1黑方是否胜利了
			if (isWin(1)) {
				System.out.println("黑方胜利了");
				break;
			}
			// 2.2棋盘是否满了，平局
			if (qipan.isFull()) {
				System.out.println("棋盘满了，平局");
				break;
			}
			// 3让白方下棋
			white.play(qipan);
			// 3.1白方是否胜利了
			if (isWin(2)) {
				System.out.println("白方胜利了");
				break;
			}
			// 3.2棋盘是否满了，平局
			if (qipan.isFull()) {
				System.out.println("棋盘满了，平局");
				break;
			}

		}
	}

	/**
	 * 判断指定的一方是否获胜
	 * 
	 * @param color
	 * @return
	 */
	boolean isWin(int color) {

		// 扫描棋盘，横、竖、左斜、右斜，只要连成五颗颜色相同的棋子，游戏结束
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 15; x++) {
				// 横
				if (qipan.points[x][y] != null && qipan.points[x][y].color == color && qipan.points[x + 1][y] != null
						&& qipan.points[x + 1][y].color == color && qipan.points[x + 2][y] != null
						&& qipan.points[x + 2][y].color == color && qipan.points[x + 3][y] != null
						&& qipan.points[x + 3][y].color == color && qipan.points[x + 4][y] != null
						&& qipan.points[x + 4][y].color == color) {
					return true;
				}
				// 竖
				if (qipan.points[x][y] != null && qipan.points[x][y].color == color && qipan.points[x][y + 1] != null
						&& qipan.points[x][y + 1].color == color && qipan.points[x][y + 2] != null
						&& qipan.points[x][y + 2].color == color && qipan.points[x][y + 3] != null
						&& qipan.points[x][y + 3].color == color && qipan.points[x][y + 4] != null
						&& qipan.points[x][y + 4].color == color) {
					return true;
				}

				// 左斜
				if (qipan.points[x][y] != null && qipan.points[x][y].color == color && x - 4 >= 0
						&& qipan.points[x - 1][y + 1] != null && qipan.points[x - 1][y + 1].color == color
						&& qipan.points[x - 2][y + 2] != null && qipan.points[x - 2][y + 2].color == color
						&& qipan.points[x - 3][y + 3] != null && qipan.points[x - 3][y + 3].color == color
						&& qipan.points[x - 4][y + 4] != null && qipan.points[x - 4][y + 4].color == color) {
					return true;
				}

				// 右斜
				if (qipan.points[x][y] != null && qipan.points[x][y].color == color
						&& qipan.points[x + 1][y + 1] != null && qipan.points[x + 1][y + 1].color == color
						&& qipan.points[x + 2][y + 2] != null && qipan.points[x + 2][y + 2].color == color
						&& qipan.points[x + 3][y + 3] != null && qipan.points[x + 3][y + 3].color == color
						&& qipan.points[x + 4][y + 4] != null && qipan.points[x + 4][y + 4].color == color) {
					return true;
				}
			}
		}
		return false;
	}

}
