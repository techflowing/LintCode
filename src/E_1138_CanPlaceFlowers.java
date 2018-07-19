/**
 * Can Place Flowers
 */
public class E_1138_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int max = 0;
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                max++;
                if (max >= n) {
                    return true;
                }
            }
        }
        return false;
    }
}
