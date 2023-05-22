package aeternias.aeternias.handlers;

public class Cathegory {
    private String name;
    private int exp;

    private int level;

    public Cathegory() {
    }

    public Cathegory(String name, int exp,int level) {
        this.name = name;
        this.exp = exp;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}