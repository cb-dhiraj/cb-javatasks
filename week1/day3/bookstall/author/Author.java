package week1.day3.bookstall.author;

public class Author {
    public Author(String name, String email, char gender){
        this.email = email;
        this.name = name;
        this.gender = gender;
    }
    String name, email;
    char gender;

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public char getGender(){
        return this.gender;
    }

    public String toDisplay(){
        return this.name+" "+this.gender+" at "+this.email;
    }

}
