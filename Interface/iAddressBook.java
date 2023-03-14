package Interface;

import Model.Contacts;

public interface iAddressBook {
	
	public void showCondition();
    public void insertContacts(Contacts contacts);
    public void showAllContacts();
    public void searchPersonBystateOrCity();

}
