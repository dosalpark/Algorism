package Ex;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("정렬 전 배열:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("\n정렬 후 배열:");
        printArray(arr);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 버블 정렬을 이 부분에 구현해주세요!
    }

    // 배열 출력
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
