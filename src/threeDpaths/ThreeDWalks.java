package threeDpaths;

public class ThreeDWalks {

	/**
	 * 
	 * @param l
	 *            >= 0
	 * @param m
	 *            >= 0
	 * @param n
	 *            >= 0
	 * @return The number of paths from (0,0,0) to (l,m,n) using the rules
	 *         specified in the problem statement. (Return -1 only if recursion doesn't return anything)
	 */
	public static long numPaths(int l, int m, int n) {

		// TODO: change this
		// You do not have to worry about overflows.

        int sum = l + m + n;
        int remainderBySix = sum % 6;

        if(l >= 0 && m >= 0 && n >= 0){
            if(l == 0 && m == 0 && n == 0){
                return 1;
            }else{
                switch (remainderBySix) {
                    case 0: return numPaths(l-3, m , n) + numPaths(l, m-3 , n) + numPaths(l, m , n-3);
                    case 1:  return numPaths(l-1, m , n) + numPaths(l, m-1 , n) + numPaths(l, m , n-1);
                    case 2:  return numPaths(l-1, m , n) + numPaths(l, m-1 , n) + numPaths(l, m , n-1); // this case only appears at the last step
                    case 3:  return numPaths(l-2, m , n) + numPaths(l, m-2 , n) + numPaths(l, m , n-2);
                    case 4:  return numPaths(l-1, m , n) + numPaths(l, m-1 , n) + numPaths(l, m , n-1); // this case only appears at the last step
                    case 5:  return numPaths(l-2, m , n) + numPaths(l, m-2 , n) + numPaths(l, m , n-2); // this case only appears at the last step

                }
            }
        }else{
            return 0;
        }


        return -1;
    }

}
