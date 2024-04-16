package Entity;

public class ChiTietHoaDon {
	private SanPham sanPham;
	private HoaDon hoaDon;
	private double soLuongCTHD;
	
	public ChiTietHoaDon(SanPham sanPham, HoaDon hoaDon, double soLuongCTHD) {
		super();
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
		this.soLuongCTHD = soLuongCTHD;
	}
	
	
	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}


	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}


	public HoaDon getHoaDon() {
		return hoaDon;
	}


	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}


	public double getSoLuongCTHD() {
		return soLuongCTHD;
	}


	public void setSoLuongCTHD(double soLuongCTHD) {
		this.soLuongCTHD = soLuongCTHD;
	}


	@Override
	public String toString() {
		return "ChiTietHoaDon [sanPham=" + sanPham + ", hoaDon=" + hoaDon + ", soLuongCTHD=" + soLuongCTHD + "]";
	}
	
	
}
