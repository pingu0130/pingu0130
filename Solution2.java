import java.util.Scanner;

class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) { // 테케
			int N = sc.nextInt(); // 사람수
			int Kmin = sc.nextInt(); // 최소인원
			int Kmax = sc.nextInt(); // 최대인원
			int cnt = 999;
			int ans = 0;
			int[] score = new int[N];
			for (int i = 0; i < N; i++) // 점수를 score배열에 입력받기
				score[i] = sc.nextInt();
			for (int i = 0; i < N - 1; i++) {
				loop: for (int j = i + 1; j < N; j++) {
					int A = 0;
					int B = 0;
					int C = 0;
					int T1 = 0;
					int T2 = 0;
					if (score[i] > score[j]) {
						T2 = score[i];
						T1 = score[j];
					} else if (score[i] == score[j]) {
						break loop;
					} else {
						T1 = score[i];
						T2 = score[j];
					}
					for (int k = N - 1; k >= 0; k--) { // score배열을 돌면서 점수에 맞는 반 배정
						if (score[k] >= T2) {
							A++;
							if (A > Kmax) {
								continue loop;
							}
							continue;
						} else if (score[k] >= T1 && score[k] < T2) {
							B++;
							if (B > Kmax) {
								continue loop;
							}
							continue;
						} else {
							C++;
							if (C > Kmax) {
								continue loop;
							}
						}
					}
					if (A < Kmin || B < Kmin || C < Kmin) {
						continue;
					} else { // 조건만족하면
						int max = Math.max(Math.max(A, B), C); // 최대인원과
						int min = Math.min(Math.min(A, B), C); // 최소인원을 찾아서
						cnt = Math.min((max - min), cnt); // 차이를 구해서 저장

					}
				}
			}
			if (cnt == 999) {
				ans = -1;
			} else {
				ans = cnt;
			}

			System.out.printf("#%d %d\n", tc, ans);
		} // 테케
		sc.close();
	}
}