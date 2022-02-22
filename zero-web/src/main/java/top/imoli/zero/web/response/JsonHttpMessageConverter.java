package top.imoli.zero.web.response;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JsonHttpMessageConverter extends FastJsonHttpMessageConverter {

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (object instanceof JsonOriginVo) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            outStream.write(((JsonOriginVo) object).getBytes());
            outStream.writeTo(outputMessage.getBody());
        } else {
            super.writeInternal(object, outputMessage);
        }
    }
}
