package com.ssafy;

import java.util.Arrays;

public class segment_tree_recursive_lazy_propagation {
    public static class SegmentTree {
        int level = 0;
        int length = 0;
        int[] inputList;
        int inputListLength;
        int inputStartIndex = 0;
        int inputEndIndex = 0;
        int treeIndex = 1;
        String calculationMethod;
        int[] resultList;
        boolean[] lazyCheckList;
        int[] lazyValueList;
        int defaultValue = 0;

        public SegmentTree(int[] inputList, String calculationMethod) {
            switch (calculationMethod) {
                case "sum":
                    this.defaultValue = 0;
                    break;
                case "max":
                    this.defaultValue = -1;
                    break;
                case "gcd":
                    this.defaultValue = 1;
                    break;
            }

            this.calculationMethod = calculationMethod;
            this.inputListLength = inputList.length;
            this.inputEndIndex = this.inputListLength - 1;
            this.inputList = new int[this.inputListLength];

            for(int i = 0; i < this.inputListLength; i++) {
                this.inputList[i] = inputList[i];
            }

            this.level = (int) Math.ceil(Math.log(this.inputListLength) / Math.log(2)) + 1;
            this.length = (int) Math.pow(2, this.level);
            this.resultList = new int[this.length];
            this.lazyCheckList = new boolean[this.length];
            this.lazyValueList = new int[this.length];

            this.make(0, this.inputListLength-1, 1);

        }

        public int gcd(int leftResult, int rightResult) {
            if (rightResult == 0) {
                return leftResult;
            }

            return this.gcd(rightResult, leftResult % rightResult);
        }

        public int method(int leftResult, int rightResult) {
            switch (this.calculationMethod) {
                case "sum":
                    return leftResult + rightResult;
                case "max":
                    return Math.max(leftResult, rightResult);
                case "gcd":
                    return this.gcd(leftResult, rightResult);
            }

            return leftResult + rightResult;
        }

        public int updateProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int updateIndex, int updateValue) {
            if ((updateIndex < inputStartIndex) || (updateIndex > inputEndIndex)) {
                return this.resultList[treeIndex];
            }

            if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = updateValue;
                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;
            int leftResult = this.updateProcess(inputStartIndex, inputMidIndex, treeIndex * 2, updateIndex, updateValue);
            int rightResult = this.updateProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, updateIndex, updateValue);

            this.resultList[treeIndex] = this.method(leftResult, rightResult);

            return this.resultList[treeIndex];
        }

        public void update(int updateIndex, int updateValue) {
            this.treeIndex = 1;
            this.inputList[updateIndex] = updateValue;

            this.updateProcess(this.inputStartIndex, this.inputEndIndex, this.treeIndex, updateIndex, updateValue);
        }

        public int getRangeProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int rangeStartIndex, int rangeEndIndex) {
            if ((inputEndIndex < rangeStartIndex) || (inputStartIndex > rangeEndIndex)) {
                return 0;
            }

            if ((inputStartIndex >= rangeStartIndex) && (inputEndIndex <= rangeEndIndex)) {
                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;

            int leftResult = this.getRangeProcess(inputStartIndex, inputMidIndex, treeIndex * 2, rangeStartIndex, rangeEndIndex);
            int rightResult = this.getRangeProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, rangeStartIndex, rangeEndIndex);

            return this.method(leftResult, rightResult);
        }

        public int getRange(int rangeStartIndex, int rangeEndIndex) {
            return this.getRangeProcess(this.inputStartIndex, this.inputEndIndex, this.treeIndex, rangeStartIndex, rangeEndIndex);
        }

        public int rangeNode(int updateValue, int updateRange) {
            if (this.calculationMethod.equals("sum")) {
                return updateValue * updateRange;
            }

            return updateValue;
        }

        public int pushDown(int updateValue, int treeIndex, int inputStartIndex, int inputEndIndex) {
            if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = updateValue;

                return this.resultList[treeIndex];
            }

            this.lazyCheckList[treeIndex] = true;
            this.lazyValueList[treeIndex] = updateValue;

            this.resultList[treeIndex] = this.rangeNode(updateValue, inputEndIndex - inputStartIndex + 1);

            return this.resultList[treeIndex];
        }

        public int updateProcess(int updateStartIndex, int updateEndIndex, int updateValue, int inputStartIndex, int inputEndIndex, int treeIndex) {
            if ((updateEndIndex < inputStartIndex) || (updateStartIndex > inputEndIndex)) {
                return this.resultList[treeIndex];
            }

            if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = updateValue;

                return this.resultList[treeIndex];
            }

            if ((updateStartIndex <= inputStartIndex) && (inputEndIndex <= updateEndIndex)) {
                this.lazyCheckList[treeIndex] = true;
                this.lazyValueList[treeIndex] = updateValue;

                this.resultList[treeIndex] = this.rangeNode(updateValue, inputEndIndex - inputStartIndex + 1);

                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;

            if (this.lazyCheckList[treeIndex]) {
                this.lazyCheckList[treeIndex] = false;

                this.pushDown(this.lazyValueList[treeIndex], treeIndex * 2, inputStartIndex, inputMidIndex);
                this.pushDown(this.lazyValueList[treeIndex], treeIndex * 2 + 1, inputMidIndex + 1, inputEndIndex);
                this.lazyValueList[treeIndex] = this.defaultValue;
            }

            int leftResult = this.updateProcess(updateStartIndex, updateEndIndex, updateValue, inputStartIndex, inputMidIndex, treeIndex * 2);
            int rightResult = this.updateProcess(updateStartIndex, updateEndIndex, updateValue, inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1);

            this.resultList[treeIndex] = this.method(leftResult, rightResult);

            return this.resultList[treeIndex];
        }

        public void updateRange(int updateStartIndex, int updateEndIndex, int updateValue) {
            this.treeIndex = 1;

            for(int updateIndex = updateStartIndex; updateIndex <= updateEndIndex; updateIndex++) {
                this.inputList[updateIndex] = updateValue;
            }

            this.updateProcess(updateStartIndex, updateEndIndex, updateValue, this.inputStartIndex, this.inputEndIndex, this.treeIndex);
        }

        public int make(int inputStartIndex, int inputEndIndex, int treeIndex) {
            if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = this.inputList[inputStartIndex];
                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;
            int left_result = this.make(inputStartIndex, inputMidIndex, treeIndex * 2);
            int right_result = this.make(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1);

            this.resultList[treeIndex] = this.method(left_result, right_result);

            return this.resultList[treeIndex];
        }

    }

    public static void main(String[] args) {
        int[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        SegmentTree segmentTree = new SegmentTree(numberList, "sum");
        System.out.println(Arrays.toString(segmentTree.resultList));
        System.out.println(segmentTree.getRange(3, 5));

        segmentTree.updateRange(2, 7, 5);
        System.out.println(Arrays.toString(segmentTree.resultList));

        segmentTree.updateRange(2, 5, 6);
        System.out.println(Arrays.toString(segmentTree.resultList));
    }
}
