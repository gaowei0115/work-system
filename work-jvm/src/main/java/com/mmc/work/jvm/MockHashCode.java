package com.mmc.work.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @packageName：com.mmc.work.jvm
 * @desrciption:
 * @author: gaowei
 * @date： 2018-02-27 16:57
 * @history: (version) author date desc
 */
public class MockHashCode {

    public static void main(String[] args) {
        Map<Domain, String> map = new HashMap<Domain, String>();
        map.put(new Domain("1", "zhangsan"), "001");

        System.out.println(map.get(new Domain("1", "zhangsan")));
    }
}

class Domain {

    private String id;
    private String name;

    public Domain() {

    }

    public Domain(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Domain domain = (Domain) o;

        if (id != null ? !id.equals(domain.id) : domain.id != null) {
            return false;
        }
        return name != null ? name.equals(domain.name) : domain.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
