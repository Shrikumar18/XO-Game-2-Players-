import java.util.Scanner;

class Game {

	public static String isOver() {
		// TODO Auto-generated method stub
		int flag1 = 0, flag2 = 0;
		String[][] arr = Matrix.getMat();
		if (arr[0][0].equals("X") && arr[0][1].equals("X")
				&& arr[0][2].equals("X"))
			flag1 = 1;
		else if (arr[0][0].equals("X") && arr[1][0].equals("X")
				&& arr[2][0].equals("X"))
			flag1 = 1;
		else if (arr[2][0].equals("X") && arr[2][1].equals("X")
				&& arr[2][2].equals("X"))
			flag1 = 1;
		else if (arr[0][2].equals("X") && arr[1][2].equals("X")
				&& arr[2][2].equals("X"))
			flag1 = 1;
		else if (arr[0][0].equals("X") && arr[1][1].equals("X")
				&& arr[2][2].equals("X"))
			flag1 = 1;
		else if (arr[2][0].equals("X") && arr[1][1].equals("X")
				&& arr[0][2].equals("X"))
			flag1 = 1;
		else if (arr[0][0].equals("Y") && arr[0][1].equals("Y")
				&& arr[0][2].equals("Y"))
			flag2 = 1;
		else if (arr[0][0].equals("Y") && arr[1][0].equals("Y")
				&& arr[2][0].equals("Y"))
			flag2 = 1;
		else if (arr[2][0].equals("Y") && arr[2][1].equals("Y")
				&& arr[2][2].equals("Y"))
			flag2 = 1;
		else if (arr[0][2].equals("Y") && arr[1][2].equals("Y")
				&& arr[2][2].equals("Y"))
			flag2 = 1;
		else if (arr[0][0].equals("Y") && arr[1][1].equals("Y")
				&& arr[2][2].equals("Y"))
			flag2 = 1;
		else if (arr[2][0].equals("Y") && arr[1][1].equals("Y")
				&& arr[0][2].equals("Y"))
			flag2 = 1;
		if (flag1 == 0 && flag2 == 0)
			return "Draw";
		else if (flag1 == 1)
			return "X Wins";
		else if (flag2 == 1)
			return "Y Wins";
		return null;
	}
}

class Matrix {
	private static String[][] mat = { { "-", "-", "-" }, { "-", "-", "-" },
			{ "-", "-", "-" } };

	public static String[][] getMat() {
		return mat;
	}

	public static void setMat(int a, int b, String player) {
		Matrix.mat[a][b] = player;
	}

	public static void dispMatrix() {
		int i, j;
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				System.out.print(Matrix.getMat()[i][j]+"	");
			}
			System.out.println("");
		}
	}
}

class Player1 {
	public static void move(int a, int b) {
		Matrix.setMat(a, b, "X");
	}
}

class Player2 {
	public static void move(int a, int b) {
		Matrix.setMat(a, b, "Y");
	}
}

public class XO {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b;
		for (int i = 0; i < 9; i++) {
			a = scan.nextInt();
			b = scan.nextInt();
			Player1.move(a, b);
			Matrix.dispMatrix();
			if (Game.isOver().equals("X Wins")) {
				System.out.println("X Wins!!");
				break;
			}
			a = scan.nextInt();
			b = scan.nextInt();
			Player2.move(a, b);
			Matrix.dispMatrix();
			if (Game.isOver().equals("Y Wins")) {
				System.out.println("Y Wins");
				break;
			}
		}
		if(Game.isOver().equals("Draw"))
		System.out.println(Game.isOver());
		scan.close();
	}
}
