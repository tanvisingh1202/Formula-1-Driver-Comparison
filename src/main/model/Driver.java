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

    // effects: constructs a Driver object with the entered attributes
    public Driver(String name, String team, String country, int points, int racewins, int topthrees, int polepositions,
                  int fastestlaps) {
        this.name = name;
        this.team = team;
        this.country = country;
        this.points = points;
        this.racewins = racewins;
        this.topthrees = topthrees;
        this.polepositions = polepositions;
        this.fastestlaps = fastestlaps;
        this.finalscore = 0;
    }

// getters

    // effects: returns the drivers name
    public String getName() {
        return name;
    }

    // effects: returns the drivers team name
    public String getTeam() {
        return team;
    }

    // effects: returns the drivers country
    public String getCountry() {
        return country;
    }

    // effects: returns the drivers career points
    public int getPoints() {
        return points;
    }

    // effects: returns the drivers number of race wins
    public int getRacewins() {
        return racewins;
    }

    // effects: returns the drivers number of podium finishes
    public int getTopthrees() {
        return topthrees;
    }

    // effects: returns the drivers number of pole positions
    public int getPolepositions() {
        return polepositions;
    }

    // effects: returns the drivers number of fastest laps
    public int getFastestlaps() {
        return fastestlaps;
    }

    // effects: returns the drivers final score
    public double getFinalscore() {
        return finalscore;
    }

// setters

    // modifies: this
    //effects: sets the career points of the driver
    public void setPoints(int points) {
        this.points = points;
    }

    // modifies: this
    // effects: sets the number of race wins of the driver
    public void setRacewins(int racewins) {
        this.racewins = racewins;
    }

    // modifies: this
    // effects: sets the number of podium finishes of the driver
    public void setTopthrees(int topthrees) {
        this.topthrees = topthrees;
    }

    // modifies: this
    // effects: sets the number of pole positions of the driver
    public void setPolepositions(int polepositions) {
        this.polepositions = polepositions;
    }

    // modifies: this
    // effects: sets the number of fastest laps of the driver
    public void setFastestlaps(int fastestlaps) {
        this.fastestlaps = fastestlaps;
    }

    // modifies: this
    // effects: sets the final score of the driver
    public void setFinalscore(double finalscore) {
        this.finalscore = finalscore;
    }


}



