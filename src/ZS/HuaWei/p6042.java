package ZS.HuaWei;

import java.util.*;

/**
 * @ClassName: p6042
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/24
 * @Time: 10:39
 */
public class p6042 {

    public int countLatticePoints(int[][] circles) {

        List<List<Map<Integer,Integer>>> all=new ArrayList();
        for (int i=0;i<circles.length;i++){
            List<Map<Integer, Integer>> list = getAll(circles[i][0], circles[i][1], circles[i][2]);
            all.add(list);
        }
        //此时all中已经包含了所有的点 此时进行去除
        Set<Map<Integer,Integer>> set=new HashSet<>();

        for (List<Map<Integer,Integer>> maps:all){

            for (Map<Integer,Integer> map:maps){
                set.add(map);
            }
        }

        return set.size();

    }

    /**
     * 传入圆心+半径  求出在次范围内的所有点
     * @param x
     * @param y
     * @param r
     * @return
     */
    public List<Map<Integer,Integer>> getAll(int x,int y,int r){

        List<Map<Integer,Integer>> res=new ArrayList<>();
        //比如坐标(3,4)半径为1

        //最左边的横坐标为 x-r=3-1=2  纵坐标为y-r=4-1=3
        int X=x-r;
        int Y=y-r;

        for (int i=X;i<X+r;i++){
            for (int j=Y;j<Y+r;j++){

                //求出这个点为圆心的距离是否小于r
                double distance=Math.sqrt((x-i)*(x-i)+(y-j)*(y-j));
                if (distance<=(double) r){

                    Map map=new HashMap();
                    map.put(i,j);
                    res.add(map);

                    Map right=new HashMap();
                    right.put(i+r,j);
                    res.add(right);
                    Map top=new HashMap();
                    top.put(i,j+r);
                    res.add(top);
                    Map rightTop=new HashMap();
                    rightTop.put(i+r,j+r);
                    res.add(rightTop);


                }
            }
        }

        //加上横轴线上的点
        for (int i=X;i<=X+2*r;i++){
            Map temp=new HashMap();
            temp.put(i,y);
            res.add(temp);
        }
        //加上纵轴线上单独点
        for (int j=Y;j<=Y+2*r;j++){
            if (j==y) continue;
            Map temp=new HashMap();
            temp.put(x,j);
            res.add(temp);
        }

      return res;
    }
    //[[8,9,6],[9,8,4],[4,1,1],[8,5,1],[7,1,1],[6,7,5],[7,1,1],[7,1,1],[5,5,3]]
    public static void main(String[] args) {
        int arr[][]={
                {8,9,6},
                {9,8,4},
                {4,1,1},
                {8,5,1},
                {6,7,5},
                {5,5,3},
                {7,1,1},
                {7,1,1},
                {7,1,1}};
        p6042 t=new p6042();
        int res = t.countLatticePoints(arr);
        System.out.println(res);
    }

}
