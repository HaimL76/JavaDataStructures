import java.util.ArrayList;
import java.util.List;

class BinaryTree {
    public static <TKey extends Comparable<TKey>> List<TKey> addKey(List<TKey> list, TKey key) {
        if (list == null)
            return null;

        List<MyPair<TKey, TKey>> list0 = new ArrayList<>(list.size());

        List<TKey> list1 = null;

        for (int i = 0; i < list.size(); i++) {
            TKey k = list.get(i);
            list0.add(new MyPair<TKey, TKey>(k, k));
        }

        list0 = add(list0, new MyPair<TKey, TKey>(key, key));

        if (list0 != null && list0.size() > 0) {
            list1 = new ArrayList<TKey>(list0.size());

            for (int i = 0; i < list0.size(); i++)
                list1.add(list0.get(i).key);
        }

        return list1;
    }

    public static <TKey extends Comparable<TKey>> Boolean findKey(List<TKey> list, TKey key) {
        List<MyPair<TKey, TKey>> list0 = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            TKey k = list.get(i);

            list0.add(new MyPair<TKey, TKey>(k, k));
        }

        MyPair<MyPair<TKey, TKey>, List<MyPair<TKey, TKey>>> pair = findOrAdd(list0, key, null);

        return pair == null
                ? false
                : pair.key != null;
    }

    public static <TKey extends Comparable<TKey>, TVal>

    List<MyPair<TKey, TVal>> add(List<MyPair<TKey, TVal>> list, MyPair<TKey, TVal> addedValue) {
        List<MyPair<TKey, TVal>> list0 = null;

        MyPair<MyPair<TKey, TVal>, List<MyPair<TKey, TVal>>> pair0 = findOrAdd(list, addedValue.key,
                new MyPair<Boolean,TVal>(true, addedValue.value));

        if (pair0 != null)
            list0 = pair0.value;

        return list0;
    }

    public static <TKey extends Comparable<TKey>, TVal>
    MyPair<TKey, TVal> find(List<MyPair<TKey, TVal>> list, TKey key, MyPair<Boolean, TVal> addedValue) {
        MyPair<TKey, TVal> pair = null;

        MyPair<MyPair<TKey, TVal>, List<MyPair<TKey, TVal>>> pair0 = findOrAdd(list, key, addedValue);

        if (pair0 != null)
            pair = pair0.key;

        return pair;
    }



    private static <TKey extends Comparable<TKey>, TVal>

    MyPair<MyPair<TKey, TVal>, List<MyPair<TKey, TVal>>> findOrAdd(List<MyPair<TKey, TVal>> list, TKey key, MyPair<Boolean, TVal> addedValue) {
        int end = 0;

        if (list.size() > 0)
            end = list.size() - 1;

        return findOrAdd(list, key, 0, end, 0, addedValue);
    }

    private static <TKey extends Comparable<TKey>, TVal>

    MyPair<MyPair<TKey, TVal>, List<MyPair<TKey, TVal>>> findOrAdd(List<MyPair<TKey, TVal>> list, TKey key, int start, int end,
                                                                   int level, MyPair<Boolean, TVal> addedValue) {
        for (int i = 0; i < level; i++)
            System.out.print('-');

        int diff = end - start;

        int middle = start + diff / 2;

        System.out.print("size: "+list.size()+", start: "+start+", end: "+end+", diff: "+diff+", middle: "+middle);

        MyPair<TKey, TVal> pair = null;

        int comp = 0;

        if (middle < list.size()) {
            pair = list.get(middle);

            comp = key.compareTo(pair.key);

            System.out.print(", key: "+key+", pair.key: "+pair.key+", comp: "+comp);

            if (comp == 0)
                return new MyPair<MyPair<TKey, TVal>, List<MyPair<TKey, TVal>>>(pair, null);

            if (diff > 0) {
                System.out.println();

                return comp < 0
                        ? findOrAdd(list, key, start, diff > 1 ? middle - 1 : start, level + 1, addedValue)
                        : findOrAdd(list, key, diff > 1 ? middle + 1 : end, end, level + 1, addedValue);
            }
        }

        List<MyPair<TKey, TVal>> newList = null;

        if (addedValue != null && addedValue.key) {
            newList = new ArrayList<>();

            MyPair<TKey, TVal> pair0 = new MyPair<>(key, addedValue.value);

            int index = 0;

            int end0 = comp < 0
                    ? middle - 1
                    : middle;

            while (index <= end0 && index < list.size())
                newList.add(list.get(index++));

            newList.add(pair0);

            while (index < list.size())
                newList.add(list.get(index++));
        }

        System.out.println();

        return new MyPair<MyPair<TKey, TVal>, List<MyPair<TKey, TVal>>>(null, newList);
    }
}

 

 





