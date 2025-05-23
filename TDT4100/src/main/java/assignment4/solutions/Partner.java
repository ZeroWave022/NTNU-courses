package assignment4.solutions;

public class Partner {
    private String name;
    private Partner partner;

    public Partner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Partner getPartner() {
        return this.partner;
    }

    public void setPartner(Partner partner) {
        if (this.partner == partner) {
            return;
        }

        Partner oldPartner = this.partner;
        this.partner = partner;

        if (oldPartner != null && oldPartner.getPartner() == this)
            oldPartner.setPartner(null);

        if (this.partner != null)
            this.partner.setPartner(this);
    }
}
