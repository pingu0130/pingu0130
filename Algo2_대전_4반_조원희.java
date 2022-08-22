import java.util.Scanner;

public class Algo2_대전_4반_조원희 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케
		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) { // 2차원배열에 영양분 입력
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int S = sc.nextInt(); // 마법사용횟수
			for (int i = 0; i < S; i++) { // 횟수만큼 마법사용
				int a = sc.nextInt(); // 행
				int b = sc.nextInt(); // 열
				int r = sc.nextInt(); // 범위
				int m = sc.nextInt(); // 종류
				switch (m) {
				case 0: // 백마법인경우
					if (arr[a][b] == 0) { // 영양분이 0이면 1로 바꿔준다.
						arr[a][b] = 1;
					} else {
						arr[a][b] *= 2; // 원점에 마법을 써준다.
					}
					for (int k = 1; k <= r; k++) { // +모양으로 사방탐색
						int[] dx = { -k, k }; // 1부터 범위r까지
						for (int x = 0; x < 2; x++) { // 세로범위 마법쓰기
							// 인덱스범위를 벗어나면 효력이 없어지도록 if문으로 설정
							if (b + dx[x] < N && b + dx[x] >= 0) {
								if (arr[a][b + dx[x]] == 0) { // 영양분이 0이면 1로 바꿔줌
									arr[a][b + dx[x]] = 1;
								} else {
									arr[a][b + dx[x]] *= 2; // 0이 아니면 마법사용
								}
							}
						}
						for (int x = 0; x < 2; x++) { // 가로범위 마법쓰기
							if (a + dx[x] < N && a + dx[x] >= 0) {
								if (arr[a + dx[x]][b] == 0) {
									arr[a + dx[x]][b] = 1;
								} else {
									arr[a + dx[x]][b] *= 2;
								}
							}
						}
					}
					break;
				case 1: // 흑마법인경우
					arr[a][b] /= 2; // 원점에 마법사용
					for (int k = 1; k <= r; k++) {
						int[] dx = { -k, k };
						int[] dy = { k, -k };
						for (int x = 0; x < 2; x++) {
							for (int y = 0; y < 2; y++) {
								// 인덱스범위를 벗어나면 효력이 없어지도록 if문으로 설정
								if (a + dx[x] < N && a + dx[x] >= 0 && b + dy[y] < N && b + dy[y] >= 0)
									arr[a + dx[x]][b + dy[y]] /= 2;
							}
						}

					} // for
					break;
				}// switch
			} // 마법사용
			int sum = 0;
			for (int i = 0; i < N; i++) { // 배열을 돌며 전체 땅의 에너지를 더한다
				for (int j = 0; j < N; j++) {
					sum += arr[i][j];
				}
			}
			System.out.printf("#%d %d\n", tc, sum);

		} // 테케
		sc.close();

	}

}
