package designpattern.com.designpattern.builderpattern;

public class Student {
    private String name;
    private int age;
    private String id;
    private String favColor;
    private String placeOfBirth;


    public Student(String name, int age, String id, String favColor, String placeOfBirth){
         this.name=name;
         this.age=age;
         this.id=id;
         this.favColor=favColor;
         this.placeOfBirth=placeOfBirth;
    }

    public void print(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.id);
        System.out.println(this.favColor);
        System.out.println(this.placeOfBirth);
    }
    public static class Builder{
        private String name;
        private int age;
        private String id;
        private String favColor;
        private String placeOfBirth;

        public static Builder newInstance()
        {
            return new Builder();
        }

        public Builder setName(String name){
            this.name=name;
            return this;
        }

        public Builder setAge(int age){
            this.age=age;
            return this;
        }

        public Builder setId(String id){
            this.id=id;
            return this;
        }

        public Builder setFavColor(String favColor){
            this.favColor=favColor;
            return this;
        }

        public Builder setPlaceOfBirth(String placeOfBirth){
            this.placeOfBirth=placeOfBirth;
            return this;
        }

        public Student build(){
            return new Student(name, age, id, favColor, placeOfBirth);
        }
    }

}
