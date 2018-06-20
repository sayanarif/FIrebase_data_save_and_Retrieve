package com.example.user.nwp;

class SaveData {
    String name,email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SaveData(String name, String email) {
        this.name = name;
        this.email = email;

    }
}
