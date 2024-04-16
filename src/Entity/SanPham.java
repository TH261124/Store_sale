package Entity;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String donViTinh;
	private double donGiaNhap;
	protected double donGiaBan;
	private double soLuongTonKho;
	private HangHoa hangHoaSP;

	public SanPham() {
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSP, String tenSP, String donViTinh, double donGiaNhap, double donGiaBan,
			double soLuongTonKho, HangHoa hangHoaSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donViTinh = donViTinh;
		this.donGiaNhap = donGiaNhap;
		this.donGiaBan = donGiaBan;
		this.soLuongTonKho = soLuongTonKho;
		this.hangHoaSP = hangHoaSP;
	}

	public HangHoa getHangHoaSP() {
		return hangHoaSP;
	}

	public void setHangHoaSP(HangHoa hangHoaSP) {
		this.hangHoaSP = hangHoaSP;
	}

	public SanPham(String maSP, String tenSP, String donViTinh, double donGiaNhap, double donGiaBan,
			double soLuongTonKho) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donViTinh = donViTinh;
		this.donGiaNhap = donGiaNhap;
		this.donGiaBan = donGiaBan;
		this.soLuongTonKho = soLuongTonKho;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getDonGiaNhap() {
		return donGiaNhap;
	}

	public void setDonGiaNhap(double donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}

	public double getDonGiaBan() {
		return donGiaBan;
	}

	public void setDonGiaBan(double donGiaBan) {
		this.donGiaBan = donGiaBan;
	}

	public double getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public void setSoLuongTonKho(double soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", donViTinh=" + donViTinh + ", donGiaNhap=" + donGiaNhap
				+ ", donGiaBan=" + donGiaBan + ", soLuongTonKho=" + soLuongTonKho + ", hangHoaSP=" + hangHoaSP + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSP == null) ? 0 : maSP.hashCode());
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
		SanPham other = (SanPham) obj;
		if (maSP == null) {
			if (other.maSP != null)
				return false;
		} else if (!maSP.equals(other.maSP))
			return false;
		return true;
	}

}
