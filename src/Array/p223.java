package Array;

/**
 * @ClassName: p223
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/30
 * @Time: 22:30
 */
public class p223 {


    /**
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {


        //第一个框的左上角 右下角坐标
        int aLeftX1 = ax1;
        int aLeftY1 = ay2;
        int aRightX2 = ax2;
        int aRightY2 = ay1;

        //第二个框的左上角 右下角坐标
        int bLeftX1 = bx1;
        int bLeftY1 = by2;
        int bRightX2 = bx2;
        int bRightY2 = by1;

        int areaA = (aRightX2 - aLeftX1) * (aLeftY1 - aRightY2);
        int areaB = (bRightX2 - bLeftX1) * (bLeftY1 - bRightY2);
        int sumU = areaA + areaB;//并集

        //判断是否有交集 交集的条件通过 左上角的最大值 是否小于右下角的最小值
        int maxLeftX = Math.max(aLeftX1, bLeftX1);
        int minLeftY = Math.min(aLeftY1, bLeftY1);
        int minRightX = Math.min(aRightX2, bRightX2);
        int maxRightY = Math.max(aRightY2, bRightY2);


        int w = minRightX - maxLeftX;//交集的宽 通过右下角的最小值x 左上角的最大值x
        int h = minLeftY - maxRightY;//交集的高 通过左上角的最小值y-右下角的最大值y
        if (w > 0 && h > 0) {
            //说明有交集
            return sumU - w * h;
        }
        //无交集
        return sumU;

    }
}
