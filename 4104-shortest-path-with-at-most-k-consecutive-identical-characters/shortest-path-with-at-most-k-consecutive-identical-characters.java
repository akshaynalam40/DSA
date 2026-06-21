import java.util.*;

class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class State {
    int node;
    long dist;
    int streak;

    State(int node, long dist, int streak) {
        this.node = node;
        this.dist = dist;
        this.streak = streak;
    }
}

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
        }

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0][1] = 0;
        pq.offer(new State(0, 0, 1));

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            int node = cur.node;
            long d = cur.dist;
            int streak = cur.streak;

            if (d > dist[node][streak]) {
                continue;
            }

            if (node == n - 1) {
                return (int) d;
            }

            for (Pair nxt : adj.get(node)) {

                int nextNode = nxt.node;
                int w = nxt.weight;

                int newStreak;

                if (labels.charAt(nextNode) == labels.charAt(node)) {
                    newStreak = streak + 1;
                } else {
                    newStreak = 1;
                }

                if (newStreak > k) {
                    continue;
                }

                long newDist = d + w;

                if (newDist < dist[nextNode][newStreak]) {
                    dist[nextNode][newStreak] = newDist;
                    pq.offer(new State(nextNode, newDist, newStreak));
                }
            }
        }

        return -1;
    }
}