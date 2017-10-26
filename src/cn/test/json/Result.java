package cn.test.json;

import java.io.Serializable;

public class Result implements Serializable{
	private String code;
	private String msg;
	private String content;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", content=" + content + "]";
	}
}
