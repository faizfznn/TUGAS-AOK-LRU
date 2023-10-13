package AOK;

import java.util.*;

public class LRUCacheSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kapasitas cache LRU: ");
        int capacity = 0;

         // Menangani eksepsi jika pengguna memasukkan nilai bukan integer
         try {
            capacity = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input yang Anda masukkan tidak valid. Program berhenti.");
            scanner.close();
            System.exit(1);
        }

        scanner.nextLine(); // Membersihkan newline
        
        LRUCache<Integer, String> cache = new LRUCache<>(capacity);

        //pilihan aksi
        boolean running = true;
        while (running) {
            System.out.println("Pilihan:");
            System.out.println("1. Simpan data");
            System.out.println("2. Ambil data");
            System.out.println("3. Keluar");
            System.out.print("Pilih tindakan: ");

            int choice = 0;

            // Menangani eksepsi jika pengguna memasukkan nilai bukan integer
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input yang Anda masukkan tidak valid. Silakan coba lagi.");
                System.out.println();
                scanner.nextLine(); // Membersihkan newline
                continue; // Lanjut ke iterasi berikutnya
            }

            scanner.nextLine(); // Membersihkan newline

            switch (choice) {
                //penyimpanan data
                case 1:
                    System.out.print("Masukkan kunci (integer): ");
                    int key = scanner.nextInt();
                    System.out.print("Masukkan nilai (string): ");
                    String value = scanner.next();
                    cache.put(key, value);
                    System.out.println();
                    break;
                //pemgambilan data
                case 2:
                    System.out.print("Masukkan kunci untuk mengambil data: ");
                    int searchKey = scanner.nextInt();
                    String result = cache.get(searchKey);
                    if (result != null) {
                        System.out.println("Nilai yang ditemukan: " + result);
                    } else {
                        System.out.println("Data tidak ditemukan.");
                        System.out.println();
                    }
                    break;
                //tutup program
                case 3:
                    scanner.close();
                    System.out.println("Program selesai.");
                    running = false;
                    break;
                //pilihan angka tidak valid
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    System.out.println();
            }
        }
    }
}