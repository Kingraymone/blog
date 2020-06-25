package service;

import lombok.Data;

@Data
public class ConstructorTest {
    public String name;
    public int index;

    public ConstructorTest(String name, int i) {
        this.name = name;
        this.index = i;
    }
}
