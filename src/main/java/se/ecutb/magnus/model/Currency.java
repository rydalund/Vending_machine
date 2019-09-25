package se.ecutb.magnus.model;

public enum Currency { //Försökte först med siffror i benämning men fick fel
    ENKRONA(1), FEMKRONA(5), TIA(10), TJUGA(20),
    FEMTILAPP(50), HUNDRALAPP(100), TVAHUNDRALAPP(200),
    FEMHUNDRALAPP (500), TUSENLAPP(1000);
    int value;

    Currency(int value)
    {
        this.value = value;
    }
}