package top.imoli.zero.model.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_central_control_server")
public class CCServer {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CCServer{" +
                "url='" + url + '\'' +
                '}';
    }

}
