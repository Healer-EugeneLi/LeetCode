package DFS;

/**
 * @ClassName: Formula
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/6
 * @Time: 16:12
 */
public class Formula {

    public int total=0;
    public int arr[]=new int[10];

    public boolean used[]=new boolean[10];

    public boolean isEqual(int arr[]){

        int a=arr[1]*100+arr[2]*10+arr[3];
        int b=arr[4]*100+arr[5]*10+arr[6];
        int c=arr[7]*100+arr[8]*10+arr[9];
        if (a+b==c) return true;
        return false;
    }

    public void show(int arr[]){

        System.out.format("%d%d%d+%d%d%d=%d%d%d",arr[1],arr[2],arr[3],
                arr[4],arr[5],arr[6],arr[7],arr[8],arr[9]);
        System.out.println();
    }

    public void  dfs(int step){


        if (step==10){
            //边界条件 且满足
            if (isEqual(arr)){
                total++;
                show(arr);//输出
            }
            return;
        }

        for (int i=1;i<=9;i++){

            if (used[i]==false){
                //还没被用过
                arr[step]=i;//这一步放了这个数
                used[i]=true;//标记 用过
                dfs(step+1);
                used[i]=false;//取消标记
            }
        }

        return;

    }

    public static void main(String[] args) {

        Formula formula=new Formula();
        formula.dfs(1);
        System.out.println(formula.total);



    }

}
