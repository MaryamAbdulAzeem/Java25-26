public class College {
    private String cName = "";
    private int numDepts = 0;
    private int numStds = 0;
    private int numFaculty = 0;
    private static int numColleges = 0;

    public College() {
        numColleges++;
    }

    public College(String name, int nD, int nS, int nF) {
        this.setAll(name, nD, nS, nF);
        numColleges++;
    }

    public int getnumCols() {
        return numColleges;
    }

    public String getName() {
        return cName;
    }

    public int getnumDepts() {
        return numDepts;
    }

    public int getnumStds() {
        return numStds;
    }

    public int getnumFaculty() {
        return numFaculty;
    }

    public void setName(String name) {
        cName = name;
    }

    public void setDepts(int num) {
        numDepts = num;
    }

    public void setFaculty(int num) {
        numFaculty = num;
    }

    public void setStds(int num) {
        numStds = num;
    }

    public void setAll(String name, int nD, int nS, int nF) {
        cName = name;
        numDepts = nD;
        numStds = nS;
        numFaculty = nF;
    }

    @Override
    public String toString() {
        return "College " + cName +
                ", number of dept. " + numDepts +
                ", number of students " + numStds +
                ", number of faculty members " + numFaculty;
    }
}
