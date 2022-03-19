package Code2018;

import java.util.*;

/**
 * @ClassName: ArrangeQ
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/7
 * @Time: 16:18
 */
public class ArrangeQ {


    public static Queue<Machine> queueMachine;
    public static Queue<Task> queueTask;

    public static int n, m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        queueMachine = new PriorityQueue<>(new Comparator<Machine>() {
            @Override
            public int compare(Machine o1, Machine o2) {
                if (o1.time == o2.time)
                    return o1.level - o2.level;
                return o2.time - o2.time;
            }
        });
        queueTask = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.time == o2.time)
                    return o1.level - o2.level;
                return o1.time - o2.time;
            }
        });
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);
        for (int i = 1; i <= n; i++) {

            int mTime = scanner.nextInt();
            int mLevel = scanner.nextInt();
            queueMachine.add(new Machine(mTime, mLevel));
        }
        for (int j = 1; j <= m; j++) {
            int tTime = scanner.nextInt();
            int tLevel = scanner.nextInt();
            queueTask.add(new Task(tTime, tLevel));
        }
        //创建一个List存放 任务队列的数据
        List<Task> allTask = new ArrayList<>();
        while (!queueTask.isEmpty()) {
            Task poll = queueTask.poll();
            allTask.add(poll);
        }
        int sum = 0;
        int num = 0;
        while (!queueMachine.isEmpty()) {
            //机器还有
            Machine poll = queueMachine.poll();//取出一台
            int temp = 0;
            Task satisfy = null;
            for (Task task : allTask) {
                if (poll.time >= task.time && poll.level >= task.level) {

                    temp = Math.max(temp, task.time * 200 + 3 * task.level);
                    satisfy = task;
                }
            }
            //最后这个任务就被安排给了这个机器
            if (satisfy != null) {
                num++;
                sum += temp;
                allTask.remove(satisfy);
            }


        }

        System.out.println(num + " " + sum);

    }
}

class Machine {

    int time;
    int level;


    public Machine(int time, int level) {
        this.time = time;
        this.level = level;
    }

}

class Task {

    int time;
    int level;

    public Task(int time, int level) {
        this.time = time;
        this.level = level;
    }
}