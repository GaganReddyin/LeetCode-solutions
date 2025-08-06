class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplacedFruits = 0;
        int size = baskets.length;
        int segmentLength = (int) Math.sqrt(size) + 1;
        int[] maxSegments = new int[size/segmentLength+1];
        int segmentMax = 0;
        for(int i = 0; i < baskets.length; i++) {
            if(i%segmentLength == 0) {
                segmentMax = 0;
            }
            segmentMax = Math.max(segmentMax, baskets[i]);
            maxSegments[i/segmentLength] = segmentMax;
        }

        for(int i = 0; i < fruits.length; i++) {
            int segmentIndex = 0;
            while(segmentIndex < maxSegments.length && maxSegments[segmentIndex] < fruits[i]) {
                segmentIndex++;
            }
            if(segmentIndex == maxSegments.length) {
                unplacedFruits++;
                continue;
            }
            int startIndex;
            for(startIndex = segmentIndex*segmentLength; startIndex < size && startIndex < (segmentIndex + 1)*segmentLength; startIndex++) {
                if(baskets[startIndex] >= fruits[i]) {
                    if(maxSegments[segmentIndex] == baskets[startIndex]) {
                        baskets[startIndex] = 0;
                        int newSegmentMax = 0;
                        for (int j = segmentIndex*segmentLength; j < size && j < (segmentIndex + 1)*segmentLength; j++) {
                            newSegmentMax = Math.max(newSegmentMax, baskets[j]);
                        }
                        maxSegments[segmentIndex] = newSegmentMax;
                    }
                    baskets[startIndex] = 0;
                    break;
                }
            }
            if(startIndex >= (segmentIndex + 1)*segmentLength) {
                unplacedFruits++;
            }
        }
        return unplacedFruits;
    }
}