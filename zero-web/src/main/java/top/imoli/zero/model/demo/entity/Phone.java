package top.imoli.zero.model.demo.entity;

/**
 * @author moli@hulai.com
 * @date 2022/2/22 11:15 AM
 */
public class Phone {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                '}';
    }
}
