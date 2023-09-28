import java.util.ArrayList;
import java.util.List;

public class MergeSort {//<T extends Comparable<T>> {

    public static <T extends Comparable<T>> List<T>  sort(List<T> list) {

        return splitAndMerge(list, 0, list.size() - 1, 0);

    }



    private static <T extends Comparable<T>> List<T> splitAndMerge(List<T> list, int start, int end, int level) {

        List<T> newList = null;



        for (int i = 0; i < level; i++)

            System.out.print('-');



        System.out.println("start: "+start+", end: "+end);



        int diff = end - start;



        if (diff == 0) {

            newList = new ArrayList<>();



            newList.add(list.get(start));

        }

        else {

            int middle = start + diff / 2;



            List<T> left = splitAndMerge(list, start, middle, level + 1);

            List<T> right = splitAndMerge(list,middle + 1, end, level + 1);



            int length = 0;



            if (left != null)

                length += left.size();



            if (right != null)

                length += right.size();



            if (length > 0) {

                newList = new ArrayList<>();



                int indexLeft = 0;

                int indexRight = 0;



                for (int i = 0; i < length; i++) {

                    if (left == null)

                        newList.add(right.get(indexRight++));



                    else if (right == null)

                        newList.add(left.get(indexLeft++));



                    else {

                        if (indexLeft >= left.size())

                            newList.add(right.get(indexRight++));



                        else if (indexRight >= right.size())

                            newList.add(left.get(indexLeft++));



                        else

                            newList.add(left.get(indexLeft).compareTo(right.get(indexRight)) < 0

                                    ? left.get(indexLeft++)

                                    : right.get(indexRight++));

                    }

                }

            }

        }



        return newList;

    }

}