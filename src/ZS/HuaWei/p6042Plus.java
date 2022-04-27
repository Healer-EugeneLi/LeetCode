package ZS.HuaWei;

/**
 * @ClassName: p6042Plus
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/24
 * @Time: 12:18
 */
public class p6042Plus {

    public int countLatticePoints(int[][] circles) {

        int count=0;
        int minX=Integer.MAX_VALUE,minY=Integer.MAX_VALUE;
        int maxX=-1,maxY=-1;
        for (int i=0;i<circles.length;i++){

            //获取最左下角的圆的 左下角坐标
            minX=Math.min(minX,circles[i][0]-circles[i][2]);
            minY=Math.min(minY,circles[i][1]-circles[i][2]);
            //获取最右上角的圆的 右上角的坐标
            maxX=Math.max(maxX,circles[i][0]+circles[i][2]);
            maxY=Math.max(maxY,circles[i][1]+circles[i][2]);

        }

        //相当于判断这个范围内的所有点的坐标能不能找到一个圆可以包含它
        for (int x=minX;x<=maxX;x++){
            for (int y=minY;y<=maxY;y++){
                for (int i=0;i<circles.length;i++){

                    int X=circles[i][0];//圆心横坐标
                    int Y=circles[i][1];//圆心纵坐标
                    double R=circles[i][2];
                    double distance=Math.sqrt((x-X)*(x-X)+(y-Y)*(y-Y));
                    if (distance<=R){
                        count++;
                        break;
                    }
                }
            }
        }
       return count;

    }

    public static void main(String[] args) {
        int arr[][]={{2,2,1}};
        p6042Plus t=new p6042Plus();
        int res = t.countLatticePoints(arr);
        System.out.println(res);
    }
}
