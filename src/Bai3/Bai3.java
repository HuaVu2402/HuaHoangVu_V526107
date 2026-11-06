package Bai3;

import java.util.ArrayList;
import java.util.List;



public class Bai3 {
    public static void main(String[] args) {
        List<Diem2D> danhSachDiem = new ArrayList<>();

        danhSachDiem.add(new Diem2D(1, 2));
        danhSachDiem.add(new Diem2D(3, 4));
        danhSachDiem.add(new Diem3D(1, 2, 3));
        danhSachDiem.add(new Diem3D(2, 4, 6));

        System.out.println("--- DANH SACH CAC DIEM BAN DAU ---");
        for (int i = 0; i < danhSachDiem.size(); i++) {
            System.out.println("Diem " + (i + 1) + ": " + danhSachDiem.get(i));
        }

        double tongKC2D = 0;
        List<Diem2D> ds2D = new ArrayList<>();
        List<Diem3D> ds3D = new ArrayList<>();

        for (Diem2D d : danhSachDiem) {
            if (d instanceof Diem3D) {
                ds3D.add((Diem3D) d);
            } else {
                ds2D.add(d);
            }
        }

        for (int i = 0; i < ds2D.size() - 1; i++) {
            tongKC2D += ds2D.get(i).tinhKhoangCach(ds2D.get(i + 1));
        }

        double tongKC3D = 0;
        for (int i = 0; i < ds3D.size() - 1; i++) {
            tongKC3D += ds3D.get(i).tinhKhoangCach3D(ds3D.get(i + 1));
        }

        System.out.println("\nTong khoang cach giua cac diem 2D: " + tongKC2D);
        System.out.println("Tong khoang cach giua cac diem 3D: " + tongKC3D);

        List<Diem2D> danhSachDoiXung = new ArrayList<>();
        for (Diem2D d : danhSachDiem) {
            danhSachDoiXung.add(d.doiXungGoc());
        }

        System.out.println("\n--- DANH SACH CAC DIEM DOI XUNG QUA GOC TOA DO ---");
        for (int i = 0; i < danhSachDoiXung.size(); i++) {
            System.out.println("Diem doi xung " + (i + 1) + ": " + danhSachDoiXung.get(i));
        }
    }
}