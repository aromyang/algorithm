package non_leanear_search.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestDistance {
    static int count;

    public static void main(String[] args) {
        FindShortestDistance f = new FindShortestDistance();
        int[][] map = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        boolean[][] visited = new boolean[map.length][map[0].length];

    }

    //못 풀었다
    public int solution(int[][] maps) {
        final int mapSizeX = maps.length;
        final int mapSizeY = maps[0].length;
        final Location target = new Location(maps.length, maps[0].length);

        boolean[][] visited = new boolean[mapSizeX][mapSizeY];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(new Location(0, 0), 1));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            //길 막히거나 맵 끝
            if(now.location.x < 0) continue;
            if(now.location.x >= mapSizeX) continue;
            if(now.location.y < 0) continue;
            if(now.location.y >= mapSizeY) continue;
            if(maps[now.location.x][now.location.y]==0) continue;
            //방문했다면
            if(visited[now.location.x][now.location.y]) continue;

            visited[now.location.x][now.location.y] = true;

            if (now.location.equals(target)) {
                return now.steps;
            }

            queue.offer(new Position(now.location.left(), now.steps + 1));
            queue.offer(new Position(now.location.right(), now.steps + 1));
            queue.offer(new Position(now.location.up(), now.steps + 1));
            queue.offer(new Position(now.location.down(), now.steps + 1));

        }
        return -1;
    }

    class Position {
        int steps;
        Location location;

        public Position(Location location, int steps) {
            this.location = location;
            this.steps = steps;
        }
    }

    //좌표 잡기
    class Location {
        int x, y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Location other) {
            return this.x == other.x && this.y == other.y;
        }

        Location left() {
            return new Location(x - 1, y);
        }
        Location right() {
            return new Location(x + 1, y);
        }
        Location up() {
            return new Location(x, y - 1);
        }
        Location down() {
            return new Location(x, y + 1);
        }

    }


}
