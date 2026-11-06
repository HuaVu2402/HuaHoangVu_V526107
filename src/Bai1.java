import java.util.ArrayList;
import java.util.Scanner;

class Nguoi {
    protected String hoTen;
    protected int tuoi;

    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        this.tuoi = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.print("Ho ten: " + hoTen + ", Tuoi: " + tuoi);
    }
}

class Nhanvien extends Nguoi {
    private int snct;
    private double hsl;

    public int getSnct() {
        return snct;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap so nam cong tac: ");
        this.snct = sc.nextInt();
        System.out.print("Nhap he so luong: ");
        this.hsl = sc.nextDouble();
        sc.nextLine();
    }

    public double tinhTienLuong() {
        return 1.5 * hsl + 0.2 * snct;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(", So nam cong tac: %d, He so luong: %.2f, Tien luong: %.2f trieu\n",
                snct, hsl, tinhTienLuong());
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap vao so luong nhan vien (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Nhanvien> danhSachNV = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin nhan vien thu " + (i + 1) + ":");
            Nhanvien nv = new Nhanvien();
            nv.nhap(scanner);
            danhSachNV.add(nv);
        }

        if (!danhSachNV.isEmpty()) {
            int maxSnct = danhSachNV.get(0).getSnct();
            for (Nhanvien nv : danhSachNV) {
                if (nv.getSnct() > maxSnct) maxSnct = nv.getSnct();
            }

            System.out.println("\n--- NHAN VIEN CO SO NAM CONG TAC NHIEU NHAT (" + maxSnct + " nam) ---");
            for (Nhanvien nv : danhSachNV) {
                if (nv.getSnct() == maxSnct) nv.xuat();
            }
        }

        danhSachNV.sort((o1, o2) -> Double.compare(o2.tinhTienLuong(), o1.tinhTienLuong()));

        System.out.println("\n--- DANH SACH NHAN VIEN SAU KHI SAP XEP LUONG GIAM DAN ---");
        for (Nhanvien nv : danhSachNV) {
            nv.xuat();
        }
        
        scanner.close();
    }
}