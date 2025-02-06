package org.mives2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
		List<Integer> array = new ArrayList<>();
		array.add(10);
		array.add(1);
		array.add(8);
		array.add(7);
		array.add(5);
		array.add(1);

		List<Integer> newArray = mergeSort(array);
		System.out.println(newArray);
    }

	private static List<Integer> mergeSort(List<Integer> a) {
		System.out.println("New array: " + a);

		if (a.size() <= 1) {
			return a;
		}

		List<Integer> b = a.subList(0, (a.size() / 2));
		List<Integer> c = a.subList((a.size() / 2), a.size());

		b = mergeSort(b);
		c = mergeSort(c);

		List<Integer> newList = new ArrayList<>();
		int b_i = 0;
		int c_i = 0;

		while (b_i < b.size() || c_i < c.size()) {
			if (b_i >= b.size()) {
				newList.addAll(c.subList(c_i, c.size()));
				System.out.println("New list: " + newList);
				return newList;
			} else if (c_i >= c.size()) {
				newList.addAll(b.subList(b_i, b.size()));
				System.out.println("New list: " + newList);
				return newList;
			} else if (b.get(b_i) <= c.get(c_i)) {
				newList.add(b.get(b_i));
				b_i++;
			} else {
				newList.add(c.get(c_i));
				c_i++;
			}
		}

		System.out.println("New list: " + newList);
		return newList;
	}
}