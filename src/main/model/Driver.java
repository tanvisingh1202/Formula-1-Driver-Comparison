package model;

public class Driver {
    private String name;
    private String team;
    private String country;
    private int points;
    private int racewins;
    private int topthrees;
    private int polepositions;
    private int fastestlaps;
    private double finalscore;

    public Driver(String name, String team, String country, int points, int racewins, int topthrees, int polepositions,
                  int fastestlaps) {
        this.name = name;
        this.team = team;
        this.country = country;
        this.points = 0;
        this.racewins = 0;
        this.topthrees = 0;
        this.polepositions = 0;
        this.fastestlaps = 0;
        this.finalscore = 0;
    }

// getters

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getCountry() {
        return country;
    }

    public int getPoints() {
        return points;
    }

    public int getRacewins() {
        return racewins;
    }

    public int getTopthrees() {
        return topthrees;
    }

    public int getPolepositions() {
        return polepositions;
    }

    public int getFastestlaps() {
        return fastestlaps;
    }

    public double getFinalscore() {
        return finalscore;
    }

// setters

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRacewins(int racewins) {
        this.racewins = racewins;
    }

    public void setTopthrees(int topthrees) {
        this.topthrees = topthrees;
    }

    public void setPolepositions(int polepositions) {
        this.polepositions = polepositions;
    }

    public void setFastestlaps(int fastestlaps) {
        this.fastestlaps = fastestlaps;
    }

    public void setFinalscore(double finalscore) {
        this.finalscore = finalscore;
    }


}



