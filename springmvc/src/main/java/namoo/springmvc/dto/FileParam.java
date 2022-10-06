package namoo.springmvc.dto;

public class FileParam {
	private String fileName;
	private String originaFileName;
	private String contentType;
	
	public FileParam(){}
	
	public FileParam(String fileName, String originaFileName, String contentType) {
		this.fileName = fileName;
		this.originaFileName = originaFileName;
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginaFileName() {
		return originaFileName;
	}

	public void setOriginaFileName(String originaFileName) {
		this.originaFileName = originaFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "FileParam [fileName=" + fileName + ", originaFileName=" + originaFileName + ", contentType="
				+ contentType + "]";
	}

}
