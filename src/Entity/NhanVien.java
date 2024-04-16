package Entity;

import java.time.LocalDate;

public class NhanVien {
	private String maNV;
	private String hoTenNV;
	private String sdt;
	private LocalDate dob;
	private String cccd;
	private String diaChi;
	private float heSoLuong;
	private double soGioLam;
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNV, String hoTenNV, String sdt, LocalDate dob, String cccd, String diaChi, float heSoLuong,
			double soGioLam) {
		super();
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.sdt = sdt;
		this.dob = dob;
		this.cccd = cccd;
		this.diaChi = diaChi;
		this.heSoLuong = heSoLuong;
		this.soGioLam = soGioLam;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getSoGioLam() {
		return soGioLam;
	}

	public void setSoGioLam(double soGioLam) {
		this.soGioLam = soGioLam;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTenNV=" + hoTenNV + ", sdt=" + sdt + ", dob=" + dob + ", cccd=" + cccd
				+ ", diaChi=" + diaChi + ", heSoLuong=" + heSoLuong + ", soGioLam=" + soGioLam + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}
	
	
}
