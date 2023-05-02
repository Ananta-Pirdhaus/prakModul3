/**
 * @author anant
 * @created 09/04/2023 - 21:49
 * @project Modul3
 */
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;

    public Queue() {
        front = rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " berhasil dimasukkan ke dalam antrian");
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong");
            return;
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println(data + " berhasil dikeluarkan dari antrian");
    }

    public int peek() {
        if (front == null) {
            System.out.println("Antrian kosong");
            return 0;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class kegiatan2 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        int choice, data;
        do {
            System.out.println("Menu Rekening Bersama");
            System.out.println("1. Setor tunai");
            System.out.println("2. Tarik tunai");
            System.out.println("3. Saldo terakhir");
            System.out.println("4. Keluar");
            System.out.print("Pilihan anda: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan jumlah setoran: ");
                    data = scanner.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah penarikan: ");
                    data = scanner.nextInt();
                    if (data > queue.peek()) {
                        System.out.println("Penarikan melebihi saldo tersedia");
                    } else {
                        queue.dequeue();
                        System.out.println(data + " berhasil ditarik");
                    }
                    break;
                case 3:
                    System.out.println("Saldo terakhir: " + queue.peek());
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (choice != 4);
    }
}
