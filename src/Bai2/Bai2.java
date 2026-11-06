package Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soLuong;
        do {
            System.out.print("Nhap so luong phan so: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Vui long nhap mot so nguyen: ");
                scanner.next();
            }
            soLuong = scanner.nextInt();
            if (soLuong <= 0) {
                System.out.println("So luong phai lon hon 0.");
            }
        } while (soLuong <= 0);

        List<PhanSo> cacPhanSo = new ArrayList<>();
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap phan so thu " + (i + 1) + ":");
            int tuSo = nhapSoNguyen(scanner, "  Tu so: ");
            int mauSo;
            do {
                mauSo = nhapSoNguyen(scanner, "  Mau so (khac 0): ");
                if (mauSo == 0) {
                    System.out.println("Mau so khong duoc bang 0, vui long nhap lai.");
                }
            } while (mauSo == 0);
            cacPhanSo.add(new PhanSo(tuSo, mauSo));
        }

        PhanSo tong = new PhanSo();
        PhanSo lonNhat = cacPhanSo.get(0);
        int soPhanSoKhongNguyen = 0;

        for (PhanSo phanSo : cacPhanSo) {
            tong = tong.cong(phanSo);
            if (phanSo.compareTo(lonNhat) > 0) {
                lonNhat = phanSo;
            }
            if (!phanSo.laSoNguyen()) {
                soPhanSoKhongNguyen++;
            }
        }

        System.out.println("Tap phan so: " + cacPhanSo);
        System.out.println("Phan so lon nhat: " + lonNhat);
        System.out.println("Tong cac phan so: " + tong);
        System.out.println("So phan so khong phai so nguyen: " + soPhanSoKhongNguyen);
    }

    private static int nhapSoNguyen(Scanner scanner, String loiNhac) {
        System.out.print(loiNhac);
        while (!scanner.hasNextInt()) {
            System.out.print("Vui long nhap mot so nguyen: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}