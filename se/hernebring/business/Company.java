package se.hernebring.business;
public class Company {
    private String name,nameCEO;
    private long orgNumber,totalAssets,totalDebts;

    Company(String name,long orgNumber,String nameCEO){
        this.name=name;
        this.orgNumber=orgNumber;
        this.nameCEO=nameCEO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCEO() {
        return nameCEO;
    }

    public void setNameCEO(String nameCEO) {
        this.nameCEO = nameCEO;
    }

    public long getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(int orgNumber) {
        this.orgNumber = orgNumber;
    }

    public long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(int totalAssets) {
        this.totalAssets = totalAssets;
    }

    public long getTotalDebts() {
        return totalDebts;
    }

    public void setTotalDebts(int totalDebts) {
        this.totalDebts = totalDebts;
    }

    @Override
    public String toString() {
        return "Namn: "+name+", VD: "+nameCEO+
        "\nOrgNummer: "+orgNumber+", Tillgångar: "+totalAssets+", Skulder: "+totalDebts;
    }
}
