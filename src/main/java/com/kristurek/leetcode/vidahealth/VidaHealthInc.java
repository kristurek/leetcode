package com.kristurek.leetcode.vidahealth;

import java.util.HashSet;

public class VidaHealthInc {

	public static void main(String[] args) {
		// 0 - water, 1 - land
		int[][]  matrix= {
					{0,1,0,0},
					{1,1,0,0},
					{0,1,0,0},
					{0,0,0,1},
					{0,0,1,1},
					{0,0,1,1},
					{0,0,1,1},
				};
		System.out.println("Max area = " + findMaxArea(matrix));
	}
	
	public static int findMaxArea(int[][] matrix) {
		int gMaxArea = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				int lMaxArea = maxArea(matrix, i, j);
				if (lMaxArea > gMaxArea)
					gMaxArea = lMaxArea;
			}

		return gMaxArea;
	}

	private static int maxArea(int[][] matrix, int i, int j) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == 1) {
			matrix[i][j] = 0;

			return 1 + maxArea(matrix, i + 1, j) + maxArea(matrix, i - 1, j) + maxArea(matrix, i, j + 1)
					+ maxArea(matrix, i, j - 1);

		} else
			return 0;
	}

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		HashSet<Integer> floors = new HashSet<Integer>();

		int sumOfPeople = 0;
		int sumOfWeight = 0;
		int indexOfCurrentPerson = 0;

		int countStops = 0;

		while (indexOfCurrentPerson < A.length) {
			while (indexOfCurrentPerson < A.length) {
				sumOfPeople++;
				sumOfWeight += A[indexOfCurrentPerson];

				if (sumOfPeople > X)
					break;

				if (sumOfWeight > Y)
					break;

				floors.add(B[indexOfCurrentPerson]);
				indexOfCurrentPerson++;
			}
			if (!floors.isEmpty())
				countStops += floors.size() + 1; // +1 go back to ground

			floors.clear();
			sumOfPeople = 0;
			sumOfWeight = 0;
		}

		return countStops;
	}

	public static int solution(int A, int B) {
		char[] aChars = String.valueOf(A).toCharArray();
		char[] bChars = String.valueOf(B).toCharArray();

		char[] cChars = new char[aChars.length + bChars.length];

		int aCharsIndex = 0;
		int bCharsIndex = 0;
		int cCharsIndex = 0;

		while (cCharsIndex < cChars.length) {
			if (cCharsIndex % 2 == 0 && aCharsIndex < aChars.length)
				cChars[cCharsIndex] = aChars[aCharsIndex++];
			else if (cCharsIndex % 2 != 0 && bCharsIndex < bChars.length)
				cChars[cCharsIndex] = bChars[bCharsIndex++];
			else
				break;
			cCharsIndex++;
		}

		while (aCharsIndex < aChars.length)
			cChars[cCharsIndex++] = aChars[aCharsIndex++];

		while (bCharsIndex < bChars.length)
			cChars[cCharsIndex++] = bChars[bCharsIndex++];

		int result = Integer.parseInt(new String(cChars));
		if (result > 100000000)
			return -1;

		return result;
	}

	public static int solution(int[][] A) {
		int counter = 0;

		for (int i = 0; i < A.length; i++) {
			boolean foundInMinRowMaxCol = true;
			boolean foundInMaxRowMinCol = true;

			int minimum = A[i][0];
			int maximum = A[i][0];
			int colIndexOfRowMinimum = 0;
			int colIndexOfRowMaximum = 0;

			// Find minimum in row.
			for (int j = 1; j < A[0].length; j++)
				if (A[i][j] < minimum) {
					minimum = A[i][j];
					colIndexOfRowMinimum = j;
				}

			// Find maximum in same column.
			for (int j = 0; j < A.length; j++)
				if (minimum < A[j][colIndexOfRowMinimum]) {
					foundInMinRowMaxCol = false;
					break;
				}

			if (foundInMinRowMaxCol)
				counter++;

			// Find maximum in row.
			for (int j = 1; j < A[0].length; j++)
				if (A[i][j] > maximum) {
					maximum = A[i][j];
					colIndexOfRowMaximum = j;
				}

			// Find minimum in same column.
			for (int j = 0; j < A.length; j++)
				if (maximum < A[j][colIndexOfRowMaximum]) {
					foundInMaxRowMinCol = false;
					break;
				}

			if (foundInMaxRowMinCol)
				counter++;

		}
		return counter;
	}
}
