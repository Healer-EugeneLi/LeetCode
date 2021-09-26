package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: InterComparator
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 10:04
 */
public class CompareTool{
    static class InterComparator implements Comparator<Integer> {
        /**
         * 返回负数，第一个数放前，堆是第一个数放上面
         * 返回正数，第二个数在前，堆是第二个数放上面
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    static class Student{
        int id;
        int age;
        String name;
        public Student(int id,int age,String name){
            this.age = age;
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class StudentComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5,1,3,7,3,4,5,1,3,5,1};
        Arrays.sort(nums,new InterComparator());    //降序
        System.out.println(Arrays.toString(nums));

        Student student1 = new Student(1,4,"x");
        Student student2 = new Student(3,1,"y");
        Student student3 = new Student(2,5,"z");
        Student[] students = new Student[]{student1,student2,student3}; //年龄升序
        Arrays.sort(students,new StudentComparator());
        System.out.println(Arrays.toString(students));

        PriorityQueue<Integer> queue = new PriorityQueue<>(new InterComparator()); //默认小根堆
        queue.add(5);
        queue.add(4);
        queue.add(6);
        queue.add(8);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

}
