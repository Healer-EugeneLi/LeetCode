package HomeWork;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: lab1_5
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/20
 * @Time: 17:14
 */
public class lab1_5 {



    public static void show(char [][] number){
        for (int i=0;i<5;i++){
            for (int j=0;j<4;j++){
                System.out.print(number[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {

        char base[][]={
                {' ','_','_',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},

        };

        char zero[][]={
                {' ','_','_',' '},
                {'|',' ',' ','|'},
                {' ',' ',' ',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},
        };
        char one[][]={
                {' ',' ',' ',' '},
                {'|',' ',' ',' '},
                {' ',' ',' ',' '},
                {'|',' ',' ',' '},
                {' ',' ',' ',' '},
        };

        char two[][]= {
                {' ', '_', '_', ' '},
                {' ', ' ', ' ', '|'},
                {' ', '_', '_', ' '},
                {'|', ' ', ' ', ' '},
                {' ', '_', '_', ' '},
        };
        char three[][]={
                {' ','_','_',' '},
                {' ',' ',' ','|'},
                {' ','_','_',' '},
                {' ',' ',' ','|'},
                {' ','_','_',' '},
        };

        char four[][]={
                {' ',' ',' ',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},
                {' ',' ',' ','|'},
                {' ',' ',' ',' '},
        };

        char five[][]={
                {' ','_','_',' '},
                {'|',' ',' ',' '},
                {' ','_','_',' '},
                {' ',' ',' ','|'},
                {' ','_','_',' '},
        };

        char six[][]={
                {' ',' ',' ',' '},
                {'|',' ',' ',' '},
                {' ','_','_',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},
        };

        char seven[][]={
                {' ','_','_',' '},
                {' ',' ',' ','|'},
                {' ',' ',' ',' '},
                {' ',' ',' ','|'},
                {' ',' ',' ',' '},
        };

        char eight[][]={
                {' ','_','_',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},
        };

        char nine[][]={
                {' ','_','_',' '},
                {'|',' ',' ','|'},
                {' ','_','_',' '},
                {' ',' ',' ','|'},
                {' ',' ',' ',' '},
        };

        //????????????
        Scanner scanner=new Scanner(System.in);
        int in = scanner.nextInt();

        //stack?????????????????? ???????????????????????????????????????1????????? ??????????????????????????????????????????????????? ??????32 ?????????2 3
        Stack<Integer> stack=new Stack<>();

        //??????????????????1??????  ??????32
        if (in>=10){
            while (in>0){
                stack.push(in%10);//????????????
                in/=10;
            }
        }else
            stack.push(in);

        //????????????
        while (!stack.isEmpty()){

            int number=stack.pop();
            switch (number){

                case 0:
                    show(zero);
                    break;
                case 1:
                    show(one);
                    break;
                case 2:
                    show(two);
                    break;
                case 3:
                    show(three);
                    break;
                case 4:
                    show(four);
                    break;
                case 5:
                    show(five);
                    break;
                case 6:
                    show(six);
                    break;
                case 7:
                    show(seven);
                    break;
                case 8:
                    show(eight);
                    break;
                default://??????9
                    show(nine);
                    break;
            }
            if (stack.size()>1)
                System.out.println("\n");//?????????
        }



    }
}
