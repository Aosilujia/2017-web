package action;

import service.ImgService;

public class ImgAction extends BaseAction{
	private int number;
	private String img;
	
	private ImgService imgService;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}
	
	
	public void getImgById() throws Exception{
		img=imgService.getImgbyId(number);
		request().setAttribute("img", img);
	}

	public void save() throws Exception {
		imgService.save(number, img);
		System.out.println(number);
		System.out.println(img);
	}
	
}
