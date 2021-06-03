package cs174.starsrus.entities;


public class Admin {

    private String admin_username;
    private String admin_password;
    private String admin_name;
    private String admin_address;
    private String admin_state;
    private String admin_phone;
    private String admin_email;
    private String admin_taxid;
    private String admin_ssn;

     public Admin(
                // String admin_username, 
                // String admin_password, 
                // String admin_name, 
                // String admin_address,
                // String admin_state, 
                // String admin_phone, 
                // String admin_email, 
                // int admin_taxid, 
                // String admin_ssn
                )
    {
        // this.admin_username = admin_username;
        // this.admin_password = admin_password;
        // this.admin_name = admin_name;
        // this.admin_address = admin_address;
        // this.admin_state = admin_state;
        // this.admin_phone = admin_phone;
        // this.admin_email = admin_email;
        // this.admin_taxid = admin_taxid;
        // this.admin_ssn = admin_ssn;
    }


    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String username) {
		this.admin_username = username;
	}

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String password) {
		this.admin_password = password;
	}

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_Name(String name) {
		this.admin_name = name;
	}


    public String getAdmin_address() {
        return admin_address;
    }

    public void setAdmin_address(String address) {
		this.admin_address = address;
	}

    public String getAdmin_state() {
        return admin_state;
    }

    public void setAdmin_state(String state) {
		this.admin_state = state;
	}

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phonenumber(String phoneNumber) {
		this.admin_phone = phoneNumber;
	}

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String email) {
		this.admin_email = email;
	}

    public String getAdmin_taxid() {
        return admin_taxid;
    }

    public void setAdmin_tid(String TID) {
		this.admin_taxid = TID;
	}

    public String getAdmin_ssn() {
        return admin_ssn;
    }

    public void setAdmin_ssn(String ssn) {
		this.admin_ssn = ssn;
	}
}
