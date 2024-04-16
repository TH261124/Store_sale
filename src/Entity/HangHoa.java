package Entity;

import java.time.LocalDate;

public class HangHoa {
	private String maLoHang;
	private String tenLoHang;
	private double soLuong;
	private double giaNhapLoHang;
	private LocalDate ngayNhapLoHang;
	private String nhaCungCap;
	private String ghiChuLoHang;
	public HangHoa(String maLoHang, String tenLoHang, double soLuong, double giaNhapLoHang, LocalDate ngayNhapLoHang,
			String nhaCungCap, String ghiChuLoHang) {
		super();
		this.maLoHang = maLoHang;
		this.tenLoHang = tenLoHang;
		this.soLuong = soLuong;
		this.giaNhapLoHang = giaNhapLoHang;
		this.ngayNhapLoHang = ngayNhapLoHang;
		this.nhaCungCap = nhaCungCap;
		this.ghiChuLoHang = ghiChuLoHang;
	}
	
	public HangHoa() {
		// TODO Auto-generated constructor stub
	}

	public String getMaLoHang() {
		return maLoHang;
	}

	public void setMaLoHang(String maLoHang) {
		this.maLoHang = maLoHang;
	}

	public String getTenLoHang() {
		return tenLoHang;
	}

	public void setTenLoHang(String tenLoHang) {
		this.tenLoHang = tenLoHang;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaNhapLoHang() {
		return giaNhapLoHang;
	}

	public void setGiaNhapLoHang(double giaNhapLoHang) {
		this.giaNhapLoHang = giaNhapLoHang;
	}

	public LocalDate getNgayNhapLoHang() {
		return ngayNhapLoHang;
	}

	public void setNgayNhapLoHang(LocalDate ngayNhapLoHang) {
		this.ngayNhapLoHang = ngayNhapLoHang;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getGhiChuLoHang() {
		return ghiChuLoHang;
	}

	public void setGhiChuLoHang(String ghiChuLoHang) {
		this.ghiChuLoHang = ghiChuLoHang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoHang == null) ? 0 : maLoHang.hashCode());
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
		HangHoa other = (HangHoa) obj;
		if (maLoHang == null) {
			if (other.maLoHang != null)
				return false;
		} else if (!maLoHang.equals(other.maLoHang))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HangHoa [maLoHang=" + maLoHang + ", tenLoHang=" + tenLoHang + ", soLuong=" + soLuong
				+ ", giaNhapLoHang=" + giaNhapLoHang + ", ngayNhapLoHang=" + ngayNhapLoHang + ", nhaCungCap="
				+ nhaCungCap + ", ghiChuLoHang=" + ghiChuLoHang + "]";
	}
	
	
}
