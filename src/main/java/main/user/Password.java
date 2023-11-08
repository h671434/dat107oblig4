package main.user;



//@Embeddable
public class Password {

    private String hash;
    private String salt;

    public Password(){
    }

    public Password(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;
    }


    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return "Password{" +
                "hash='" + hash + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}