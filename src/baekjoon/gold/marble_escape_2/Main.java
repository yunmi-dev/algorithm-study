package baekjoon.gold.marble_escape_2;

import java.io.*;
import java.util.*;

/// 문제의 핵심: BFS + 상태관리
public class Main {

    static class State {
        int redX, redY, blueX, blueY, count;

        public State(int redX, int redY, int blueX, int blueY, int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        // 보드 세팅
        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < M; col++) {
                board[row][col] = line.charAt(col);
                if (board[row][col] == 'R') {
                    redX = row;
                    redY = col;
                    board[row][col] = '.';  // R과 B는 . 으로 수정 (이동 시 서로 거슬리니까)
                } else if (board[row][col] == 'B') {
                    blueX = row;
                    blueY = col;
                    board[row][col] = '.';
                }
            }
        }
        // 이후 보드는 수정 X (수정해버리면 백트래킹 불가)

        /// BFS
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] dx = {0, 0, -1, 1}; // 상하좌우 순서
        int[] dy = {1, -1, 0, 0};

        // 시작 상태 큐에 넣기
        queue.offer(new State(redX, redY, blueX, blueY, 0));
        visited.add(redX + "," + redY + "," + blueX + "," + blueY);

        while (!queue.isEmpty()) {

            State current = queue.poll();

            if (current.count >= 10) continue;

            for (int dir = 0; dir < 4; dir++) {

                // 해당 방향으로 굴리기
                int nRedX = current.redX;
                int nRedY = current.redY;
                int nBlueX = current.blueX;
                int nBlueY = current.blueY;
                boolean redInHole = false;
                boolean blueInHole = false;

                // 동시에 이동해야 함. 둘 다 더 이상 움직일 수 없을 때까지
                int moveCount = 0;
                while (true) {
                    if (++moveCount > 20) break;

                    // 현재 턴에서 각 구슬의 이전 위치 저장
                    int prevRedX = nRedX, prevRedY = nRedY;
                    int prevBlueX = nBlueX, prevBlueY = nBlueY;

                    boolean redMoved = false;
                    boolean blueMoved = false;

                    // 빨간 구슬 이동 (벽이나 구멍이 아니고, 파란 구슬 위치가 아니면)
                    int nextRedX = nRedX + dx[dir];
                    int nextRedY = nRedY + dy[dir];
                    if (nextRedX >= 0 && nextRedX < N && nextRedY >= 0 && nextRedY < M &&
                            board[nextRedX][nextRedY] != '#' &&
                            !(nextRedX == prevBlueX && nextRedY == prevBlueY)) {
                        nRedX = nextRedX;
                        nRedY = nextRedY;
                        redMoved = true;
                        if (board[nRedX][nRedY] == 'O') {
                            redInHole = true;
                        }
                    }

                    // 파란 구슬 이동 (벽이나 구멍이 아니고, 빨간 구슬 위치가 아니면)
                    int nextBlueX = nBlueX + dx[dir];
                    int nextBlueY = nBlueY + dy[dir];
                    if (nextBlueX >= 0 && nextBlueX < N && nextBlueY >= 0 && nextBlueY < M &&
                            board[nextBlueX][nextBlueY] != '#' &&
                            !(nextBlueX == prevRedX && nextBlueY == prevRedY)) {
                        nBlueX = nextBlueX;
                        nBlueY = nextBlueY;
                        blueMoved = true;
                        if (board[nBlueX][nBlueY] == 'O') {
                            blueInHole = true;
                        }
                    }

                    // 둘 다 움직이지 않거나, 구멍에 빠지면 종료
                    if ((!redMoved && !blueMoved) || redInHole || blueInHole) {
                        break;
                    }
                }

                // 파란구슬이 구멍에 빠지면 이 방향은 실패
                if (blueInHole) continue;


                // 빨간구슬이 구멍에 빠지면 성공
                if (redInHole) {
                    System.out.println(current.count + 1);
                    return;
                }

                // 두 구슬이 같은 위치에 있으면 조정 (실제로는 위 로직으로 방지되지만 안전장치)
                if (nRedX == nBlueX && nRedY == nBlueY) {
                    int redDist = Math.abs(nRedX - current.redX) + Math.abs(nRedY - current.redY);
                    int blueDist = Math.abs(nBlueX - current.blueX) + Math.abs(nBlueY - current.blueY);

                    if (redDist > blueDist) {
                        nRedX -= dx[dir];
                        nRedY -= dy[dir];
                    } else {
                        nBlueX -= dx[dir];
                        nBlueY -= dy[dir];
                    }
                }


                String stateKey = nRedX + "," + nRedY + "," + nBlueX + "," + nBlueY;
                if (!visited.contains(stateKey)) {
                    visited.add(stateKey);
                    queue.offer(new State(nRedX, nRedY, nBlueX, nBlueY, current.count + 1));
                }
            }
        }

        System.out.println(-1);
    }
}