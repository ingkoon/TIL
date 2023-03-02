package com.sweab.리스트복사;

import java.util.HashMap;

class UserSolution {
    final int MAX_MAKE_LIST = 10;
    final int MAX_LENGTH = 200000;
    final int MAX_ADDRESS = 6000;
    final int MAX_CHANGE = 110000;
    int initNumber;
    int[][] initValue;

    int addressNumber;
    HashMap<String, Integer> address;

    int changeNumber;
    Pair[] changeLog;
    int[] lastChange;
    int[] prevChange;

    void init() {
        initNumber = 0;
        initValue = new int[MAX_MAKE_LIST + 1][MAX_LENGTH + 1];

        addressNumber = 0;
        address = new HashMap<>();

        changeNumber = 0;
        changeLog = new Pair[MAX_CHANGE + 1];
        lastChange = new int[MAX_ADDRESS + 1];
        prevChange = new int[MAX_CHANGE + 1];
    }
    
    String getName(char[] name) {
        String x = "";
        for (int i=0;name[i]!=0;i++){
            x += name[i];
        }
        return x;
    }

    void makeList(char[] _mName, int mLength, int[] mListValue) {
        String mName = getName(_mName);
        System.arraycopy(mListValue, 0, initValue[initNumber], 0, mLength);
        initNumber++;

        address.put(mName, addressNumber);
        addressNumber++;

        changeLog[changeNumber] = new Pair(-1, initNumber - 1);
        prevChange[changeNumber] = -1;
        lastChange[address.get(mName)] = changeNumber;
        changeNumber++;
    }

    void copyList(char[] _mDest, char[] _mSrc, boolean mCopy) {
        String mDest = getName(_mDest);
        String mSrc = getName(_mSrc);
        if (mCopy) {
            address.put(mDest, addressNumber);
            addressNumber++;

            changeLog[changeNumber] = new Pair(-1, -1);
            prevChange[changeNumber] = lastChange[address.get(mSrc)];
            lastChange[address.get(mDest)] = changeNumber;
            changeNumber++;
        } else {
            address.put(mDest, address.get(mSrc));
        }
    }

    void updateElement(char[] _mName, int mIndex, int mValue) {
        String mName = getName(_mName);
        changeLog[changeNumber] = new Pair(mIndex, mValue);
        prevChange[changeNumber] = lastChange[address.get(mName)];
        lastChange[address.get(mName)] = changeNumber;
        changeNumber++;
    }

    int element(char[] _mName, int mIndex) {
        String mName = getName(_mName);
        int c = lastChange[address.get(mName)];
        while (true) {
            if (prevChange[c] == -1) {
                return initValue[changeLog[c].second][mIndex];
            }
            if (changeLog[c].first == mIndex) {
                return changeLog[c].second;
            }
            c = prevChange[c];
        }
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}