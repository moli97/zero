package top.imoli.zero.web.response;

import java.nio.charset.StandardCharsets;

public class JsonOriginVo {
	
	static final byte[] EMPY_BYTES = new byte[0];
	
	final String value;
	
	public JsonOriginVo(String value) {
		this.value = value;
	}
	
	public byte[] getBytes() {
		return value == null ? EMPY_BYTES : value.getBytes(StandardCharsets.UTF_8);
	}

}
