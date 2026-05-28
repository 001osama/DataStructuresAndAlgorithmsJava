package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class TypicalProblems {

    //933. Number of Recent Calls
    class RecentCounter {
        Queue<Integer> repo;

        public RecentCounter() {
            repo = new LinkedList<>();
        }

        public int ping(int t) {
            while(repo.size() > 0 && repo.peek() > t - 3000)
                repo.poll();

            repo.offer(t);
            return repo.size();
        }
    }
}
