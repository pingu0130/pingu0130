package 백준;

import java.util.ArrayList;
import java.util.Scanner;

public class 사다리3 {
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
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 1; j < 101; j++) { // 첫째줄 100개 볼거야
				if (arr[0][j] == 1) {
					list.add(j);
				}
			}

			int ans = 0;
			int idx = 0;

			for (int j = 1; j < 101; j++) { // 마지막줄 100개 볼거야
				if (arr[99][j] == 2) { // 2를찾아
					idx = j; // 2의 기둥번호
				}
			}
			int jj = 0;
			for (int a = 0; a < list.size(); a++) {
				if (idx == list.get(a)) { // 2의 위치
					jj = a; // idx는 list(a)에 있음
				}
			}
			int i = 98;

			while (i != 0) {
				if (arr[i][idx + 1] == 1) { // 오른쪽이 1이면
					idx = list.get(list.indexOf(idx) + 1); // 한칸 옆줄로 옮겨
					jj++;
					i--; // 그리고올라가
				} else if (arr[i][idx - 1] == 1) { // 왼쪽이 1이면
					idx = list.get(jj - 1);
					jj--;
					i--;
				} else { // 0이면 그냥올라가
					i--;
				}
			}
			ans = idx - 1;
			System.out.printf("#%d %d\n", tc, ans);

		}
	}
}
