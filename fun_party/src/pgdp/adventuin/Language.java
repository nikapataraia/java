package pgdp.adventuin;

public enum Language {

    ENGLISH{
        @Override
        public String getLocalizedChristmasGreeting(String name){
            return name + " wishes you a Merry Christmas!";
        }
    },
    GERMAN{
        @Override
        public String getLocalizedChristmasGreeting(String name){
            return "Fröhliche Weihnachten wünscht dir " + name + '!';
        }
    };
    public abstract String getLocalizedChristmasGreeting(String name);
}
