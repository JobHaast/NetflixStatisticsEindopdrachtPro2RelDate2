package logic;

public class Profile {
    private String profileName;
    private String profileLanguage;
    private int age;

    public Profile(String profileName, String profileLanguage, int age){
        this.profileName = profileName;
        this.profileLanguage = profileLanguage;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getProfileLanguage() {
        return profileLanguage;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return "Profilename: " + profileName+ "\n" + "Profilelanguage: " + profileLanguage + "\n" + "Age: " + age;
    }
}
