package pgdp.adventuin;

import pgdp.color.RgbColor;

public class Adventuin {
    private final String name;
    private final int height;
    private final RgbColor color;
    private final HatType hat;
    private final Language language;

    public String getName() {
        return name;
    }

    public HatType  getHatType() {
        return hat;
    }

    public int getHeight() {
        return height;
    }

    public Language getLanguage() {
        return language;
    }

    public RgbColor getColor() {
        return color;
    }
    public Adventuin(String name, int size, RgbColor color, HatType hatType, Language lang){
        this.name = name;
        this.height = size;
        this.color = color;
        this.hat = hatType;
        this.language = lang;
    }
}
