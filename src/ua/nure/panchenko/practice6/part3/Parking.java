package ua.nure.panchenko.practice6.part3;

public class Parking {

    private Integer[] arr;
    private int number;

    public Parking(int number) {
        this.number = number;
        arr = new Integer[number];
        fillArray();
    }

    private final void fillArray() {
        for (int i = 0; i < number; i++) {
           arr[i] = 0;
        }
    }

    private boolean arrivePast(int n) {
        boolean flag = false;
        for (int i = n + 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean arriveBefore(int n) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean arrive(int k) {
        if (k > arr.length - 1) {
            throw new IllegalArgumentException();
        }
        boolean isArrive;

        if (arr[k] == 0) {
            arr[k] = 1;
            isArrive = true;
        } else {
            isArrive = arrivePast(k);
        }
        if (!isArrive) {
            isArrive = arriveBefore(k);
        }
        return isArrive;
    }

    public boolean depart(int k) {
        if (k > arr.length -1) {
            throw new IllegalArgumentException();
        }
        boolean isDepart = false;

        if (arr[k] == 1) {
            arr[k] = 0;
            isDepart = true;
        }
        return isDepart;
    }

    public void print() {
        for (Integer sing: arr) {
            System.out.print(sing);
        }
        System.out.println();
    }
}
