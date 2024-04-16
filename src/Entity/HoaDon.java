package Entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class HoaDon {
	private String maHD;
	private LocalDate ngayLapHD;
	private KhachHang khachHang;
	private NhanVien nhanVien;

	private ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();

	
	public ArrayList<ChiTietHoaDon> getDsCTHD() {
		return dsCTHD;
	}

	public void setDsCTHD(ArrayList<ChiTietHoaDon> dsCTHD) {
		this.dsCTHD = dsCTHD;
	}
	
	public int getSize() {
		return dsCTHD.size();
	}

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHD, LocalDate ngayLapHD, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", khachHang=" + khachHang + ", nhanVien="
				+ nhanVien + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}

}
