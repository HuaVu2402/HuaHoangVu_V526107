package Bai3;

class Diem3D extends Diem2D {
    private double z;

    public Diem3D() {
        super();
        this.z = 0;
    }

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    public double tinhKhoangCach3D(Diem3D p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2) + Math.pow(this.z - p.z, 2));
    }

    @Override
    public Diem2D doiXungGoc() {
        return new Diem3D(-this.x, -this.y, -this.z);
    }

    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy);
        this.z += dz;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
