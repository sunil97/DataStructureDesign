package ltcd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Sunil.Yadav
 * 		   Design a data structure that supports all following
 *         operations in average O(1) time.
 * 
 *         Note: Duplicate elements are allowed. insert(val): Inserts an item
 *         val to the collection. remove(val): Removes an item val from the
 *         collection if present. getRandom: Returns a random element from
 *         current collection of elements. The probability of each element being
 *         returned is linearly related to the number of same value the
 *         collection contains
 */
public class InsertDeleteGetRandom_DesignDataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedCollection coll = new RandomizedCollection();
		coll.insert(1);
		coll.insert(1);
		coll.insert(2);
		coll.insert(2);
		coll.insert(2);
		coll.remove(1);
		coll.remove(1);
		coll.remove(2);
		coll.insert(1);
		coll.remove(2);coll.insert(1);
		System.out.println(" rand "+coll.getRandom());
		
	}

	static class RandomizedCollection {

		private Map<Integer, ArrayList<Integer>> map;
		private ArrayList<int []> list;
		private Random rand;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<>();
			list = new ArrayList<>();
			rand = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not
		 * already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean result = false;
			if (!map.containsKey(val)) {
				result = true;
				map.put(val, new ArrayList<>());
			}
			map.get(val).add(list.size());
			list.add(new int [] {val,map.get(val).size()-1});
			return result;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained
		 * the specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val))
				return false;
			int idx = map.get(val).get(map.get(val).size() - 1);
			System.out.println(map+" ");
			if (idx != list.size() - 1) {
				int []v = list.get(list.size() - 1);
				map.get(v[0]).set(v[1], idx);
				
			}
			map.get(val).remove(idx);
			if (map.get(val).isEmpty())
				map.remove(val);
			list.remove(list.size() - 1);
			return true;
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return list.get(rand.nextInt(list.size()))[0];
		}
	}

	/**
	 * Your RandomizedCollection object will be instantiated and called as such:
	 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
	 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
	 * obj.getRandom();
	 */

}
