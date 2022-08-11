package 백준;

import java.util.Scanner;

public class 사다리 {
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
			for (int j = 1; j < 101; j++) { // 첫째줄 100개 볼거야
				if (arr[0][j] == 1) {
					int jj = j;
					int i = 1; // 첫째줄이 1이면 밑칸도 당연히 1이니까 관념적으로 내려왔다고 생각하면됨
					while (i != 100) {
						if (arr[i][jj + 1] == 1) {// 오른쪽이 1이면 1이 끝날때까지 옆으로가야해
							while (arr[i][jj + 1] != 0) {
								jj++;
							}
							i++; // 끝나면 밑으로 내려가

						} else if (arr[i][jj - 1] == 1) {// 왼쪽이 1이면
							while (arr[i][jj - 1] != 0) {
								jj--;
							}
							i++; // 밑으로내려가
						} else {
							i++; // 내려감
							if (i == 99 && arr[i][jj] == 2) { // 맨마지막 줄에서 2가 나오면
								ans = j - 1; // 맨 첫칸 저장
							}
						}
					}

				} else { // 첫째줄이 0이면 지나가요
				}

			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
