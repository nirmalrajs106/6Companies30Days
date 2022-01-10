class Solution {
    public int longestMountain(int[] array) {
        if(array.length < 3) return 0; 

		int len=0;
		// indexes of first element in ascending and descending sequences corresponding
		int asc = -1, desc = -1;
		for(int i = 1; i < array.length; ++i) {
			// found ascending
			if(array[i-1]< array[i]) {
				//either this is first ever seen ascending seq
				// or there was already descend after previously found ascend
				if(asc == -1 || desc > asc) asc = i-1;
			} else if (array[i-1]> array[i]) {
				desc = i;
			} else { // plateau
				asc =-1;
				desc=-1;
			}
			// both asc and desc were found and they are known in right order
			if(asc>-1 && desc>-1 && desc > asc) {
				len = Math.max(len, desc - asc + 1);
			}
			
		}
        return len;
        
    }
}