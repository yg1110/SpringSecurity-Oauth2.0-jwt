package com.security_blog.yg1110.domain;

public class FileInfo {

	private int file_id;
    private int post_id;
    private String fileName;     //저장할 파일
    private String fileOriginalName;  //실제 파일
    private String fileUrl;
    
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	
	public FileInfo(int post_id, String fileName, String fileOriginalName, String fileUrl) {
		super();
		this.post_id = post_id;
		this.fileName = fileName;
		this.fileOriginalName = fileOriginalName;
		this.fileUrl = fileUrl;
	}
	@Override
	public String toString() {
		return "File [file_id=" + file_id + ", post_id=" + post_id + ", fileName=" + fileName + ", fileOriginalName="
				+ fileOriginalName + ", fileUrl=" + fileUrl + "]";
	}
}
