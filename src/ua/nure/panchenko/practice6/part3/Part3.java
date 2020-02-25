package ua.nure.panchenko.practice6.part3;

public class Part3 {
    public static void main(String[] args) {
        Parking parking = new Parking(10);

        parking.arrive(5);
        parking.arrive(7);
        parking.arrive(8);
        parking.arrive(9);
        parking.print();
        parking.depart(7);
        parking.print();
        parking.arrive(6);
        parking.print();
        parking.arrive(5);
        parking.print();
        parking.arrive(8);
        parking.print();

    }

}
