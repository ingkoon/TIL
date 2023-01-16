package com.ssafy;

import java.util.Arrays;

public class fenwick_tree {
    public static class FenwickTree {
        int[] inputList;
        int inputListLength;
        int[] resultList;

        public FenwickTree(int[] inputList) {

            this.inputListLength = inputList.length;
            this.inputList = new int[this.inputListLength];
            this.resultList = new int[this.inputListLength];

            for(int i = 0; i < this.inputListLength; i++) {
                this.inputList[i] = inputList[i];
            }

            int inputIndex = 1;
            for(int inputValue : this.inputList) {
                this.update(inputIndex, inputValue);
                inputIndex += 1;
            }
        }

        public void update(int inputIndex, int inputValue) {
            while(inputIndex < this.resultList.length) {
                this.resultList[inputIndex] += inputValue;
                inputIndex += (inputIndex & -inputIndex);
            }
        }

        public int getIndexRange(int index) {
            int result = 0;

            while (index > 0) {
                result += this.resultList[index];
                index -= (index &  -index);
            }

            return result;
        }

        public int getRange(int rangeStartIndex, int rangeEndIndex) {
            int leftResult = this.getIndexRange(rangeStartIndex-1);
            int rightResult = this.getIndexRange(rangeEndIndex);

            return rightResult - leftResult;
        }
    }

    public static void main(String[] args) {
        int[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        FenwickTree fenwickTree = new FenwickTree(numberList);
        System.out.println(Arrays.toString(fenwickTree.resultList));
        System.out.println(fenwickTree.getRange(3, 5));

        fenwickTree.update(4, 3);
        System.out.println(Arrays.toString(fenwickTree.resultList));
        System.out.println(fenwickTree.getRange(3, 5));

    }
}
