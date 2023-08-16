import java.util.*;

public class main {

    private static void insertion(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > current) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }

    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(left, right, list);
    }

    private static void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> list) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }

    private static void bubble(ArrayList<Integer> list){
  
        while(true){
            int number = list.get(0);
            boolean stop = true;
            for (int i = 1; i < list.size(); i++){
                System.out.println(list.get(i));
                if (number > list.get(i)){
                    Collections.swap(list, i, i-1);
                    System.out.println(list);
                    stop = false;
                } 
                else{
                    number = list.get(i);
                    System.out.println(list);
                }
            }
            if (stop == true){
                break;
            }
        }

    }


    public static void selectionSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static void pancakeSort(ArrayList<Integer> list) {
        int n = list.size();

        for (int i = n - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (list.get(j) > list.get(maxIndex)) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                reverse(list, 0, maxIndex);
                reverse(list, 0, i);
            }
        }
    }

    private static void reverse(ArrayList<Integer> list, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static void quickSort(ArrayList<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return (i + 1);
    }


    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        Collections.shuffle(list);
        System.out.println(list);
        selectionSort(list);
        System.out.println(list);
    }
}
