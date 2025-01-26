class Solution {

    int totalRows, totalCols;
    int[][] memoization;

    public int maxStudents(char[][] classroom) {
        totalRows = classroom.length;
        totalCols = classroom[0].length;
        memoization = new int[totalRows][1 << totalCols];
        
        for (int i = 0; i < totalRows; i++) {
            Arrays.fill(memoization[i], -1);
        }

        return calculateMax(classroom, 0, 0);
    }

    private int calculateMax(char[][] classroom, int currentRow, int prevRowMask) {
        if (currentRow == totalRows) {
            return 0;
        }
        
        if (memoization[currentRow][prevRowMask] != -1) {
            return memoization[currentRow][prevRowMask];
        }
        
        int optimalSeats = 0;
        List<Integer> validRowMasks = new ArrayList<>();
        generateRowMasks(classroom[currentRow], 0, prevRowMask, 0, validRowMasks);

        for (int mask : validRowMasks) {
            optimalSeats = Math.max(optimalSeats, Integer.bitCount(mask) + calculateMax(classroom, currentRow + 1, mask));
        }

        memoization[currentRow][prevRowMask] = optimalSeats;
        return optimalSeats;
    }

    private void generateRowMasks(char[] row, int index, int prevMask, int currentMask, List<Integer> validMasks) {
        if (index == totalCols) {
            validMasks.add(currentMask);
            return;
        }

        generateRowMasks(row, index + 1, prevMask, currentMask, validMasks);

        if (row[index] != '#' && isValidSeat(index, prevMask, currentMask)) {
            currentMask |= (1 << index);
            generateRowMasks(row, index + 1, prevMask, currentMask, validMasks);
            currentMask ^= (1 << index);
        }
    }

    private boolean isValidSeat(int index, int prevMask, int currentMask) {
        if (index > 0 && ((currentMask & (1 << (index - 1))) != 0 || (prevMask & (1 << (index - 1))) != 0)) {
            return false;
        }
        if (index < totalCols - 1 && (prevMask & (1 << (index + 1))) != 0) {
            return false;
        }
        return true;
    }
}