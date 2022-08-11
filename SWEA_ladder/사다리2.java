package 백준;

import java.util.Scanner;

public class 사다리2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int q = 0; q < 10; q++) {
			int tc = sc.nextInt();
			int[][] arr = new int[100][102]; // 앞뒤에 0넣어주기위해서
			for (int i = 0; i < 100; i++) { // 배열채우기
				for (int j = 1; j < 101; j++) { // 앞뒤 0빼고 채우기
					arr[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			int idx = 0;
			for (int j = 0; j < 102; j++) { // 마지막줄 100개 볼거야
				if (arr[99][j] == 2) { // 2를찾아
					idx = j;
				}
			}
			int jj = idx;
			int i = 98;
			while (i != 0) {
				if (arr[i][jj + 1] == 1) {// 오른쪽이 1이면 1이 끝날때까지 옆으로가야해
					while (arr[i][jj + 1] != 0) {
						jj++;
					}
					i--; // 끝나면 밑으로 내려가

				} else if (arr[i][jj - 1] == 1) {// 왼쪽이 1이면
					while (arr[i][jj - 1] != 0) {
						jj--;
					}
					i--; // 밑으로내려가
				} else {
					i--; // 내려감
				} // while문이 깨졌다는건 첫줄에 도착했다는 것
				ans = jj - 1;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}