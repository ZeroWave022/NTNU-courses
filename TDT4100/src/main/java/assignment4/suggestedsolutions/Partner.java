package assignment4.suggestedsolutions;

public class Partner {

	private final String name;
	private Partner partner;

	public Partner(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}

		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		if (partner == this.partner) {
			return;
		}

		Partner oldPartner = this.partner;
		this.partner = partner;

		if (oldPartner != null && oldPartner.getPartner() == this) {
			oldPartner.setPartner(null);
		}
		if (this.partner != null) {
			this.partner.setPartner(this);
		}
	}

	@Override
	public String toString() {
		return String.format("[Partner %s is partner with %s]", this.name,
				partner != null ? partner.name : null);
	}
}
